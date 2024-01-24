package com.demo.Content;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "content")
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "writerid")
    private long writerid;

    @Column(name = "summary")
    private String summary;

    @Column(name = "writername")
    private String writername;

    @Column(name = "article")
    private String article;

    @Column(name = "date_create")
    private LocalDate dateCreate;

    @Column(name = "category")
    private String category;

    @Column(name = "imglink")
    private String imglink;

    public Content() {

    }

    public Content(Long id, String title, long writerid, String summary, String writername, String article,
            LocalDate dateCreate, String category, String imglink) {
        this.id = id;
        this.title = title;
        this.writerid = writerid;
        this.summary = summary;
        this.writername = writername;
        this.article = article;
        this.dateCreate = dateCreate;
        this.category = category;
        this.imglink = imglink;
    }

    public long getContentid() {
        return id;
    }

    public void setContentid(long id) {
        this.id = id;
    }

    public String getContenttitle() {
        return title;
    }

    public void setContenttitle(String title) {
        this.title = title;
    }

    public long getWriterid() {
        return writerid;
    }

    public void setWriterid(long writerid) {
        this.writerid = writerid;
    }

    public String getContentSummary() {
        return summary;
    }

    public void setContentSummary(String summary) {
        this.summary = summary;
    }

    public String getWritername() {
        return writername;
    }

    public void setWritername(String writername) {
        this.writername = writername;
    }

    public String getContentArticle() {
        return article;
    }

    public void setContentArticle(String article) {
        this.article = article;
    }

    public LocalDate getContentDatecreate() {
        return dateCreate;
    }

    public void setContentDatecreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getContentCategory() {
        return category;
    }

    public void setContentCategory(String category) {
        this.category = category;
    }

    public String getContentImglink() {
        return imglink;
    }

    public void setContentImglink(String imglink) {
        this.imglink = imglink;
    }

    @Override
    public String toString() {
        return "Content [id=" + id + ", title=" + title + "writerid=" + writerid + "summary=" + summary + "writername=" + writername + "article=" + article + "dateCreate=" + dateCreate + "category=" + category + "imglink=" + imglink + "]";
    }
}

