package com.kusak.dariusz.simplejwtauthorizationproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ManagerController {

    @GetMapping("/manager")
    public ResponseEntity<String> checkManagerPermission() {
        return new ResponseEntity<>("Manager permission confirmed", HttpStatus.OK);
    }
}