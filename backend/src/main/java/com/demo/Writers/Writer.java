package com.demo.Writers;

import java.time.LocalDate;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity 
@Table(name="writer")

public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "date_create")
    private LocalDate dateCreate;

    @Column(name = "description")
    private String description;

    public Writer() {

    }

    public Writer(Long id, String name, LocalDate dateCreate, String description) {
        this.id = id;
        this.name = name;
        this.dateCreate = dateCreate;
        this.description = description;
    }

    public long getWriterid() {
        return id;
    }

    public void setWriterid(long id) {
        this.id = id;
    }

    public String getWritername() {
        return name;
    }

    public void setWritername(String name) {
        this.name = name;
    }

    public LocalDate getDatecreate() {
        return dateCreate;
    }

    public void setWriterDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getWriterdescription() {
        return description;
    }

    public void setWriterdescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Writer [id=" + id + ", name=" + name + ",datecreate=" + dateCreate + ", description=" + description + "]";
    }
}
