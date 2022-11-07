package com.example.literature.repository;

import com.example.literature.model.Language;
import com.example.literature.model.Literature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface LiteratureRepository extends JpaRepository<Literature, Long> {

//    @Query(value = "SELECT * FROM LITERATURE WHERE LITERATURE_ID=?1", nativeQuery = true)
//    public Literature findByLiteratureId(Long id);

    public List<Literature> findByTitle(String title);

    public List<Literature> findBySynopsis(String synopsis);

    public List<Literature> findByPublicationDateBetween(Date date1, Date date2);

    public List<Literature> findByPublicationDateBefore(Date date);

    public List<Literature> findByPublicationDateAfter(Date date);

    @Query(value = """
            SELECT * FROM LITERATURE
            LEFT JOIN LANGUAGES
            ON LITERATURE.LANGUAGE_ID = LANGUAGES.LANGUAGE_ID
            WHERE LANGUAGE = :language
            """,
            nativeQuery = true)
    public List<Literature> findByLanguage(@Param("language") String language);

    @Query(value = """
            SELECT * FROM LITERATURE
            LEFT JOIN LITERATURE_XREF_AUTHORS
            ON LITERATURE.ID=LITERATURE_XREF_AUTHORS.LITERATURE_ID
            JOIN AUTHORS
            ON LITERATURE_XREF_AUTHORS.AUTHOR_ID=AUTHORS.AUTHOR_ID
            WHERE AUTHORS.NAME=:author
            """,
            nativeQuery = true
    )
    public List<Literature> findByAuthor(@Param("author") String author);

    @Query(value = """
            SELECT * FROM LITERATURE
            LEFT JOIN LITERATURE_XREF_GENRES
            ON LITERATURE.ID=LITERATURE_XREF_GENRES.LITERATURE_ID
            JOIN GENRES
            ON LITERATURE_XREF_GENRES.GENRE_ID=GENRES.GENRE_ID
            WHERE GENRES.GENRE=:genre
            """,
            nativeQuery = true
    )
    public List<Literature> findByGenre(@Param("genre") String genre);

    @Query(value = """
            SELECT * FROM LITERATURE
            LEFT JOIN PUBLISHERS
            ON LITERATURE.PUBLISHER_ID=PUBLISHERS.PUBLISHER_ID
            WHERE PUBLISHER_NAME=:publisher
            """,
            nativeQuery = true)
    public List<Literature> findByPublisher(@PathVariable("publisher") String publisher);

}
