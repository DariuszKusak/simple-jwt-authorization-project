package com.kusak.dariusz.simplejwtauthorizationproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @GetMapping("/admin")
    public ResponseEntity<String> checkAdminPermission() {
        return new ResponseEntity<>("Admin permission confirmed", HttpStatus.OK);
    }
}
