package com.kusak.dariusz.simplejwtauthorizationproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CommonUserController {

    @GetMapping("/commonUser")
    public ResponseEntity<String> checkCommonUserPermission() {
        return new ResponseEntity<>("Common User permission confirmed", HttpStatus.OK);
    }
}
