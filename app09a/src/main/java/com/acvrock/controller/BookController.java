package com.acvrock.controller;

import com.acvrock.domain.Book;
import com.acvrock.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/book_list")
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "BookList";
    }
}