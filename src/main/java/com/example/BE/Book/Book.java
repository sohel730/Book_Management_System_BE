package com.example.BE.Book;

import java.math.BigDecimal;
import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private  int id;
	
	@Column(name="Book_name")
	private String bookName;
	
	@Column(name="Book_price")
	private BigDecimal bookPrice;
	
	@Column(name="Published_date")
	private Date  publishedDate;
	
	@Column(name="Book_pdf")
	private byte[] bookPdf;
	

	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "author_id", nullable = false)
	 private Author author;

	 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public BigDecimal getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	

	

	public byte[] getBookPdf() {
		return bookPdf;
	}

	public void setBookPdf(byte[] bookPdf) {
		this.bookPdf = bookPdf;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	
	
 



}
