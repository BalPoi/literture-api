package com.example.literature.service;

import com.example.literature.model.Language;
import com.example.literature.model.Literature;
import com.example.literature.repository.LiteratureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LiteratureService {

    @Autowired
    LiteratureRepository literatureRepository;

    public Literature createLiterature(Literature literature) {
        return literatureRepository.save(literature);
    }

    public List<Literature> getAllLiterature() {
        return literatureRepository.findAll();
    }

    public Literature getLiterature(Long id) {
        return literatureRepository.findById(id).get();
    }

    public List<Literature> getLiteratureByTitle(String title) {
        return literatureRepository.findByTitle(title);
    }

    public List<Literature> getLiteratureBySynopsis(String synopsis) {
        return literatureRepository.findBySynopsis(synopsis);
    }

    public List<Literature> getLiteratureByLanguage(String language) {
        return literatureRepository.findByLanguage(language);
    }

    public List<Literature> getLiteratureByAuthor(String author) {
        return literatureRepository.findByAuthor(author);
    }

    public List<Literature> getLiteratureByGenre(String genre) {
        return literatureRepository.findByGenre(genre);
    }

    public List<Literature> getLiteratureByPublisher(String publisher) {
        return literatureRepository.findByPublisher(publisher);
    }

    public List<Literature> getLiteratureByDateBetween(Date date1, Date date2) {
        return literatureRepository.findByPublicationDateBetween(date1, date2);
    }

    public List<Literature> getLiteratureByDateBefore(Date date) {
        return literatureRepository.findByPublicationDateBefore(date);
    }

    public List<Literature> getLiteratureByDateAfter(Date date) {
        return literatureRepository.findByPublicationDateAfter(date);
    }

    public void deleteLiterature(Long literatureId) {
        System.out.printf("DELETE deleteLiterature: ID = %d%n", literatureId);
        literatureRepository.deleteById(literatureId);
    }

    public Literature updateLiterature(Long literatureId, Literature newLiterature) {
        System.out.println("PUT updateLiterature:");
        Literature literature = literatureRepository.findById(literatureId).get();
        literature.setTitle(newLiterature.getTitle());
        literature.setSynopsis(newLiterature.getSynopsis());
        literature.setLanguage(newLiterature.getLanguage());
        literature.setPageNum(newLiterature.getPageNum());
        literature.setPublicationDate(newLiterature.getPublicationDate());
        literature.setType(newLiterature.getType());
        literature.setPublisher(newLiterature.getPublisher());
        literature.setAuthors(newLiterature.getAuthors());
        literature.setGenres(newLiterature.getGenres());

        return literatureRepository.save(literature);
    }
}
