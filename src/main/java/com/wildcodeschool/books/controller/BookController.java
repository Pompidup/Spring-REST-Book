package com.wildcodeschool.books.controller;

import com.wildcodeschool.books.model.Book;
import com.wildcodeschool.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;


    //Show all books
    @GetMapping("/books")
    public List<Book> index(){
        return bookRepository.findAll();
    }

    //Search book(s)
    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRepository.findByTitleContainingOrDescriptionContaining(searchTerm, searchTerm);
    }

    //Show one book
    @GetMapping("/books/{id}")
    public Book show(@PathVariable int id) {
        return bookRepository.findById(id).get();
    }

    //Add one book
    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    //Update one book
    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        //Get the book
        Book bookToUpdate = bookRepository.findById(id).get();
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setDescription((book.getDescription()));
        return bookRepository.save(bookToUpdate);
    }

    //Delete one book
    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable int id) {
        bookRepository.deleteById(id);
        return true;
    }
}
