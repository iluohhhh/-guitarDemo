package com.github.cumtfc.guitar.controller;

import com.github.cumtfc.guitar.po.builder.Builder;
import com.github.cumtfc.guitar.service.BuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController()
@RequestMapping(value = "builders", produces = {APPLICATION_JSON_UTF8_VALUE})
public class BuilderController {

    @Autowired
    BuilderService builderService;

    @GetMapping(value = "")
    public ResponseEntity<List<Builder>> getAll() {
        return ResponseEntity.ok(builderService.getAll());
    }
}