package com.ada.adalibrary.resources;


import com.ada.adalibrary.domain.Book;
import com.ada.adalibrary.services.BookService;
import com.ada.adalibrary.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController implements BookService {


    @Autowired
    private BookServiceImpl bookServiceImpl;
    @GetMapping("/all")
    public String getBooks(Model model){
        model.addAttribute("books", bookServiceImpl.getBooks());
        return "book_all";

    }

    @GetMapping("/{bookName}")
    public String getBookById(Model model, @PathVariable("bookName") String bookName){

        model.addAttribute("book", bookServiceImpl.getBookByName(bookName));
        return "book";

    }
    @GetMapping("/{id}")
    public ResponseEntity getBookById(Model model, @PathVariable("id") int book_id){

        return null;

    }

    @Override
    public Book fetchById(Long id) {
        return null;
    }
}
