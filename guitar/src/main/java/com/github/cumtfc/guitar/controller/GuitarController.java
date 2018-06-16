package com.github.cumtfc.guitar.controller;

import com.github.cumtfc.guitar.po.guitar.Guitar;
import com.github.cumtfc.guitar.po.guitar.GuitarSpec;
import com.github.cumtfc.guitar.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CrossOrigin
@RestController()
@RequestMapping(value = "guitars", produces = {APPLICATION_JSON_UTF8_VALUE})
public class GuitarController {

    @Autowired
    GuitarService guitarService;

    @PostMapping(value = "search", consumes = {APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<Guitar>> searchGuitars(@RequestBody GuitarSpec guitarSpec) {
        return ResponseEntity.ok(guitarService.searchGuitar(guitarSpec));
    }

    @PostMapping(value = "")
    public ResponseEntity<Guitar> saveOne(@RequestBody Guitar guitar) {
        return ResponseEntity.ok(guitarService.save(guitar));
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Guitar>> getAll() {
        return ResponseEntity.ok(guitarService.getAll());
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteOne(@PathVariable Integer id) {
        return ResponseEntity.ok(guitarService.deleteById(id));
    }
}