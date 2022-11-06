package com.example.literature.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "literature")
public class Literature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "literature_id")
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
    @JoinColumn(name = "type_id")
    private LiteratureType type;

    public Literature() {
    }

    public Literature(String title, String synopsis, Language language, int pageNum, Date publicationDate, LiteratureType type) {
        this.title = title;
        this.synopsis = synopsis;
        this.language = language;
        this.pageNum = pageNum;
        this.publicationDate = publicationDate;
        this.type = type;
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

    @Override
    public String toString() {
        return "Literature{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", language=" + language +
                ", pageNum=" + pageNum +
                ", publicationDate=" + publicationDate +
                ", type=" + type +
                '}';
    }
}
