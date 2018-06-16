package com.github.cumtfc.guitar.controller;

import com.github.cumtfc.guitar.po.type.Type;
import com.github.cumtfc.guitar.service.TypeService;
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
@RequestMapping(value = "types", produces = {APPLICATION_JSON_UTF8_VALUE})
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping(value = "")
    public ResponseEntity<List<Type>> getAll() {
        return ResponseEntity.ok(typeService.getAll());
    }
}