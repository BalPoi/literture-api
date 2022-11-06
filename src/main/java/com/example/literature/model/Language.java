package com.example.literature.model;

import javax.persistence.*;

@Entity
@Table(name = "languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private long id;

    //FIXME: createLiterature() add same languages to the table. Make column unique.
    @Column(name = "language")
    private String language;

    public Language() {
    }

    public Language(String language) {
        this.language = language;
    }

    public long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return language;
    }
}
