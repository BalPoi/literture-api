package com.example.literature.model;

import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "types")
public class LiteratureType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private long id;

    @Column(name = "type")
    private String type;

    public LiteratureType() {
    }

    public LiteratureType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
