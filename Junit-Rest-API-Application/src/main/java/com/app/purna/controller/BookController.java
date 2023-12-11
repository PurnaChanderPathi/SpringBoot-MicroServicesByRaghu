package com.app.purna.controller;

import com.app.purna.entity.Book;
import com.app.purna.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBookRecords() {
        return bookRepository.findAll();
    }

    @GetMapping(value = "{bookId}")
    public Book getBookById(@PathVariable(value = "bookId") Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @PostMapping
    public Book createBookRecord(@RequestBody Book bookRecord) {
        return bookRepository.save(bookRecord);
    }

    @PutMapping
    public Book updateBookRecord(@RequestBody Book bookRecord) throws FileNotFoundException {
        if (bookRecord == null || bookRecord.getBookId() == null) {
            throw new FileNotFoundException("Book record or ID must be not null ");
        }
        Optional<Book> optionalBook = bookRepository.findById(bookRecord.getBookId());
        if (!optionalBook.isPresent()) {
            throw new FileNotFoundException("Book with ID" + bookRecord.getBookId() + "does not exist");
        }
        Book existingBookRecord = optionalBook.get();
        existingBookRecord.setName(bookRecord.getName());
        existingBookRecord.setSummary(bookRecord.getSummary());
        existingBookRecord.setRating(bookRecord.getRating());

        return bookRepository.save(existingBookRecord);
    }

    @DeleteMapping(value = "{bookId}")
    public void deleteBookById(@PathVariable(value = "bookId") Long bookId) throws  FileNotFoundException
    {
        if(!bookRepository.findById(bookId).isPresent())
        {
            throw new FileNotFoundException("bookId" +bookId+ "not present");
        }
        bookRepository.deleteById(bookId);
    }

}


