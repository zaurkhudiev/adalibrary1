package com.ada.adalibrary.resources;

import com.ada.adalibrary.domain.Book;
import com.ada.adalibrary.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookRestController {
@Autowired
BookServiceImpl bookServiceImpl;

    @GetMapping("/api/users/login/books")
    public List<Book> getBooks(){

        return bookServiceImpl.getBooks();
    }

    @GetMapping("/api/users/login/book/{name}")
    public Book getBookByName(@PathVariable("name") String bookName){

    return bookServiceImpl.getBookByName(bookName);
    }



}
