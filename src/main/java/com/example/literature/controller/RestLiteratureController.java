package com.example.literature.controller;

import com.example.literature.model.Language;
import com.example.literature.model.Literature;
import com.example.literature.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

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

    @GetMapping("/literature/{id}")
    public Literature readById(@PathVariable("id") String id) {
        return literatureService.getLiterature(Long.valueOf(id));
    }

    @GetMapping("/literature/title/{title}")
    public List<Literature> readByTitle(@PathVariable(name = "title") String title) {
        return literatureService.getLiteratureByTitle(title);
    }

    @GetMapping("/literature/synopsis/{synopsis}")
    public List<Literature> readBySynopsis(@PathVariable(name = "synopsis") String synopsis) {
        return literatureService.getLiteratureBySynopsis(synopsis);
    }

    @GetMapping("/literature/language/{lang}")
    public List<Literature> readByLanguage(@PathVariable(name = "lang") String language) {
        return literatureService.getLiteratureByLanguage(language);
    }

    @GetMapping("/literature/author/{author}")
    public List<Literature> readByAuthor(@PathVariable(name = "author") String author) {
        return literatureService.getLiteratureByAuthor(author);
    }

    @GetMapping("/literature/genre/{genre}")
    public List<Literature> readByGenre(@PathVariable(name = "genre") String genre) {
        return literatureService.getLiteratureByGenre(genre);
    }

    @GetMapping("/literature/publisher/{publisher}")
    public List<Literature> readByPublisher(@PathVariable(name = "publisher") String publisher) {
        return literatureService.getLiteratureByPublisher(publisher);
    }

    @GetMapping("/literature/dateBetween/{date1},{date2}")
    public List<Literature> readByDateBetween(@PathVariable(name = "date1") String date1, @PathVariable(name = "date2") String date2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
        return literatureService.getLiteratureByDateBetween(sdf.parse(date1), sdf.parse(date2));
    }

    @GetMapping("/literature/dateBefore/{date}")
    public List<Literature> readByDateBefore(@PathVariable(name = "date") String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
        return literatureService.getLiteratureByDateBefore(sdf.parse(date));
    }

    @GetMapping("/literature/dateAfter/{date}")
    public List<Literature> readByDateAfter(@PathVariable(name = "date") String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
        return literatureService.getLiteratureByDateAfter(sdf.parse(date));
    }

    // Ну и так далее...

    @PutMapping("/literature/{literatureId}")
    public Literature updateLiterature(@PathVariable(value = "literatureId") Long id, @RequestBody Literature newLiterature) {
        return literatureService.updateLiterature(id, newLiterature);
    }

    @DeleteMapping("/literature/{literatureId}")
    public void deleteLiterature(@PathVariable(value = "literatureId") Long id) {
        literatureService.deleteLiterature(id);
    }

}
