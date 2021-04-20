package com.ada.adalibrary.impl;

import com.ada.adalibrary.domain.Book;
import com.ada.adalibrary.domain.BookModel;
import com.ada.adalibrary.domain.CommentEntity;
import com.ada.adalibrary.domain.CommentModel;
import com.ada.adalibrary.repos.BookRepo;
import com.ada.adalibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;
    public List<Book> getBooks(){
        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("1","1984","Novel","George Orwell"));
        listOfBooks.add(new Book("2","Crime and Punishment","Novel","Fyodor Dostoyevski"));
        listOfBooks.add(new Book("3","The Stranger","Novel","Albert Camus"));
        listOfBooks.add(new Book("4","The Trial","Novel","Franz Kafka"));


        return listOfBooks;

    }




    public Book getBookByName(String name){
        Predicate<Book> byName = p -> p.getName().equals(name);
        return filterBooks(byName);

    }
    private Book filterBooks(Predicate<Book> st){
        return  getBooks().stream().filter(st).findFirst().orElse(null);

    }
    public Book addBook(Book newBook){
        newBook.setId("5");
        return newBook;

    }

    @Override
    public BookModel fetchById(Long id) {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isEmpty());
        BookModel bookModel = new BookModel(book.get());
        List<CommentModel> comments = new ArrayList<>(1);
        List<CommentEntity> commentEntities = commentService.getCommentByBookExtid(id);

        if(commentEntities.size()>0) {
commentEntities.stream().forEach((comentEntity - >{
    comments.add(new CommentModel(comments))
    );

        return bookModel;
}
        }
    }
}
