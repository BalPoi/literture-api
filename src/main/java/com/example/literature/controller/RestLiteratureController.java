package com.example.literature.controller;

import com.example.literature.model.Literature;
import com.example.literature.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestLiteratureController {

    @Autowired
    LiteratureService literatureService;

    @PostMapping("/literature")
    public Literature createLiterature(@RequestBody Literature literature) {
        return literatureService.createLiterature(literature);
    }

    @GetMapping("/literature")
    public List<Literature> readAllLiterature() {
        return literatureService.getAllLiterature();
    }

    @GetMapping("/literature/{literatureId}")
    public Literature readLiterature(@PathVariable(value = "literatureId") Long id) {
        return literatureService.getLiterature(id);
    }

    @PutMapping("/literature/{literatureId}")
    public Literature updateLiterature(@PathVariable(value = "literatureId") Long id, @RequestBody Literature newLiterature) {
        return literatureService.updateLiterature(id, newLiterature);
    }

    @DeleteMapping("/literature/{literatureId}")
    public void deleteLiterature(@PathVariable(value = "literatureId") Long id) {
        literatureService.deleteLiterature(id);
    }

}
