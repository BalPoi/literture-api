package com.example.literature.service;

import com.example.literature.model.Literature;
import com.example.literature.repository.LiteratureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteratureService {

    @Autowired
    LiteratureRepository literatureRepository;

    public Literature createLiterature(Literature literature) {
        System.out.printf("POST createLiterature():%n%s%n", literature.toString());
        return literatureRepository.save(literature);
    }

    public List<Literature> getAllLiterature() {
        System.out.println("GET getAllLiterature():%n");
        return literatureRepository.findAll();
    }

    public Literature getLiterature(Long id) {
        System.out.println("GET getAllLiterature():%n");
        return literatureRepository.findById(id).get();
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
