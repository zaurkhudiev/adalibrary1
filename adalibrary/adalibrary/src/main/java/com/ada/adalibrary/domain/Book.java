package com.ada.adalibrary.domain;

public class Book {
    private String id;
    private String name;
    private String category;
    private String authorName;

    public Book(String id, String name, String category, String authorName) {
       this.id = id;
        this.name = name;
        this.category = category;
        this.authorName = authorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
