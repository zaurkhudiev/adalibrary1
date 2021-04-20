package com.ada.adalibrary.services;

import com.ada.adalibrary.domain.Book;
import com.ada.adalibrary.domain.BookModel;
import org.springframework.stereotype.Repository;

@Repository
public interface BookService {
    BookModel fetchById(Long id);

}
