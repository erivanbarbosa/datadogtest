package br.com.redesprou.datadogtest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<Void> getAllUsers() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}