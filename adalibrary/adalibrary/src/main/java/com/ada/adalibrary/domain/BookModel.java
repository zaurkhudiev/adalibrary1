package com.ada.adalibrary.domain;

import java.util.List;

public class BookModel {

    private String id;
    private String name;
    private String author;
    private String category;


    private List<CommentModel> comments;
    public BookModel(Book book){

        this.id = book.getId();
        this.name = book.getName();
        this.author = book.getAuthorName();
        this.category = book.getCategory();



    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }
}
