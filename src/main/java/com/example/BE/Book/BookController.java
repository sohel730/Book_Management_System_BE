package com.example.BE.Book;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.rsocket.annotation.ConnectMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class BookController 
{

    @Autowired
    private BookeService bookService;

    @PostMapping("/CreateBook")
    public ResponseEntity<String> createBookRecord(
    		
            @RequestParam("bookName") String bookName,
            @RequestParam("bookPrice") BigDecimal bookPrice,
            @RequestParam("publishedDate") String publishedDate,
            @RequestParam("bookPdf") MultipartFile bookPdf,
            @RequestParam("authorId") int authorId
            
    		) 
    {

        // Validate inputs
        if (bookName == null || bookName.isEmpty() || 
            bookPrice == null || 
            publishedDate == null || 
            bookPdf == null || bookPdf.isEmpty() || 
            authorId <= 0) {
            return ResponseEntity.badRequest().body("All fields are required");
        }

        // Create a new Book object
        Book book = new Book();
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setPublishedDate(Date.valueOf(publishedDate));
        
        try {
            book.setBookPdf(bookPdf.getBytes()); // Convert MultipartFile to byte array
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing PDF: " + e.getMessage());
        }

        // Find the author by ID
        Author author = new Author();
        author.setId(authorId);
        book.setAuthor(author);

        // Save the book record
        boolean status = bookService.CreateBookRecord(book);
        if (status) {
            return ResponseEntity.ok("Book created successfully");
        } else {
            return ResponseEntity.status(500).body("Error creating book record");
        }
    }
    
    
    
    @PutMapping("/UpdateBookRecord/{id}")
    public ResponseEntity<String> updatebookrecord(
    		@RequestParam("bookName") String bookName,
            @RequestParam("bookPrice") BigDecimal bookPrice,
            @RequestParam("publishedDate") String publishedDate,
            @RequestParam("bookPdf") MultipartFile bookPdf,
            @RequestParam("authorId") int authorId,
            @RequestParam("id") int id
            
    		
    		) 
    {
    	boolean status;
    	
    	 // Validate inputs
        if (bookName == null || bookName.isEmpty() || 
            bookPrice == null || 
            publishedDate == null || 
            bookPdf == null || bookPdf.isEmpty() || 
            authorId <= 0) {
            return ResponseEntity.badRequest().body("All fields are required");
        }
    	
     // Create a new Book object
        Book book = new Book();
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setPublishedDate(Date.valueOf(publishedDate));
        
        try {
            book.setBookPdf(bookPdf.getBytes()); // Convert MultipartFile to byte array
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error processing PDF: " + e.getMessage());
        }

     // Find the author by ID
        Author author = new Author();
        author.setId(authorId);
        book.setAuthor(author);

        // update the book record
         status = bookService.UpdateBookRecord(book,id);
        if (status) {
            return ResponseEntity.ok("Book Updated successfully");
        } else {
            return ResponseEntity.status(500).body("Error creating book record");
        }
    }
    	
    
    @DeleteMapping("/DeletBookRecord/{id}")
    public boolean deletboolrecord(@RequestParam("id") int id) 
    
    {
       return  bookService.DeletBookRecord(id);
    	
    }
   
    
    
  }
    
   

