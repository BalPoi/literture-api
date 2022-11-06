package com.example.literature.repository;

import com.example.literature.model.Literature;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LiteratureRepository extends JpaRepository<Literature, Long> {
}
