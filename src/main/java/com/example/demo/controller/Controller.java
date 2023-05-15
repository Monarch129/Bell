package com.example.demo.controller;

import com.example.demo.entitys.UserCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/bell")
public class Controller {

    @GetMapping(value = "/hello", produces = "application/json")
    public ResponseEntity<String> getString() {
        return new ResponseEntity<>("Hello Bell Integrator", HttpStatus.OK);
    }

    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postString(@RequestBody UserCredentials userCredentials) {
        LocalDate currentDate = LocalDate.now();
        String login = userCredentials.getLogin();
        return new ResponseEntity<>("{\"Login\":" + "\""  + login + "\"" + ", \"Date\": " + "\""
                + currentDate + "\"" + "}", HttpStatus.OK);
    }
}
