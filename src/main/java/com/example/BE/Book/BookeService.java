package com.example.BE.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookeService {
	
	@Autowired
	private BookRepository BookRepo;
	
	
	public boolean CreateBookRecord(Book o)
	{
		boolean status;
		
		try {
			
			BookRepo.save(o);
			status=true;
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			status=false;
			
		}
		
		return status;
		
	}
	
	public boolean UpdateBookRecord(Book o,int id)
	{ 
		boolean status ;
		
		try {
			
			Book Exitingobj=BookRepo.findById(id);
			
			if(Exitingobj!=null) {
				
				Exitingobj.setBookName(o.getBookName());
				Exitingobj.setBookPrice(o.getBookPrice());
				Exitingobj.setPublishedDate(o.getPublishedDate());
				Exitingobj.setBookPdf(o.getBookPdf());
				Exitingobj.setAuthor(o.getAuthor());
				
				BookRepo.save(Exitingobj);
				status=true;
				
			}
			
			else {
				status=false;
				
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
			status=false;
		}
		
		return status;
		
	}

	
	public boolean DeletBookRecord(int id)
	{
		boolean status;
		
		try {
			
			BookRepo.findById(id);
			status=true;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			status=false;
			
		}
		return status;
		
	}
	
	
	public List<Book> GetallBooks(){
		
		return BookRepo.findAll();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
