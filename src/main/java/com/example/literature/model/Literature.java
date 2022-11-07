package com.example.literature.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "literature")
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "synopsis")
    private String synopsis;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "page_number")
    private int pageNum;

    @Column(name = "publication_date")
    private Date publicationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "literature_xref_authors",
            joinColumns = @JoinColumn(name = "literature_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private LiteratureType type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "literature_xref_genres",
            joinColumns = @JoinColumn(name = "literature_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;



    public Literature() {
    }

    public Literature(String title, String synopsis, Language language, int pageNum, Date publicationDate,
                      Publisher publisher, LiteratureType type, Set<Author> authors, Set<Genre> genres) {
        this.title = title;
        this.synopsis = synopsis;
        this.language = language;
        this.pageNum = pageNum;
        this.publicationDate = publicationDate;
        this.publisher = publisher;
        this.type = type;
        this.authors = authors;
        this.genres = genres;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public LiteratureType getType() {
        return type;
    }

    public void setType(LiteratureType type) {
        this.type = type;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Literature{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", language=" + language +
                ", pageNum=" + pageNum +
                ", publicationDate=" + publicationDate +
                ", publisher=" + publisher +
                ", authors=" + authors +
                ", type=" + type +
                ", genres=" + genres +
                '}';
    }

}
