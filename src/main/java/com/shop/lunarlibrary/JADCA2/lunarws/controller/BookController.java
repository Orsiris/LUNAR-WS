package com.shop.lunarlibrary.JADCA2.lunarws.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;

import com.shop.lunarlibrary.JADCA2.lunarws.dbaccess.Book;
import com.shop.lunarlibrary.JADCA2.lunarws.dbaccess.BookDAO;

@RestController
@RequestMapping("books")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })

public class BookController {

	@GetMapping("/getAllBooks")
	public ArrayList<Book> getAllBooks() {

		ArrayList<Book> bookList = new ArrayList<Book>();

		try {
			BookDAO db = new BookDAO();

			bookList = db.getAllBooks();
		} catch (Exception e) {
			System.out.print("Error: " + e);
		}

		return bookList;
	}

	@GetMapping("/getBook/{bookid}")
	public Book getBook(@PathVariable("bookid") String bookid) {

		Book book = new Book();

		try {
			BookDAO db = new BookDAO();

			book = db.getBookDetails(bookid);
		} catch (Exception e) {
			System.out.print("Error: " + e);
		}

		return book;
	}

	@GetMapping("/getBookByTitle/{title}")
	public ArrayList<Book> getBookByTitle(@PathVariable("title") String title) {

		ArrayList<Book> bookList = new ArrayList<Book>();

		try {
			BookDAO db = new BookDAO();

			bookList = db.getBookByTitle(title);
		} catch (Exception e) {
			System.out.print("Error: " + e);
		}

		return bookList;
	}

	@GetMapping("/getBookByAuthor/{author}")
	public ArrayList<Book> getBookByAuthor(@PathVariable("author") String author) {

		ArrayList<Book> bookList = new ArrayList<Book>();

		try {
			BookDAO db = new BookDAO();

			bookList = db.getBookByAuthor(author);
		} catch (Exception e) {
			System.out.print("Error: " + e);
		}

		return bookList;
	}

	@GetMapping("/getBookByGenre/{genre}")
	public ArrayList<Book> getBookByGenre(@PathVariable("genre") String genre) {

		ArrayList<Book> bookList = new ArrayList<Book>();

		try {
			BookDAO db = new BookDAO();

			bookList = db.getBookByGenre(genre);
		} catch (Exception e) {
			System.out.print("Error: " + e);
		}

		return bookList;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/addBook", consumes = "application/json")
	public int addBook(@RequestBody Book book) {
	    int rec = 0;

	    try {
	        BookDAO db = new BookDAO();

	        String title = book.getTitle();
	        String author = book.getAuthor();
	        double price = book.getPrice();
	        int quantity = book.getQuantity();
	        String publisher = book.getPublisher();
	        Date publicationDate = book.getDate();
	        String isbn = book.getIsbn();
	        String genre = book.getGenre();
	        double rating = book.getRating();
	        String description = book.getDescription();
	        String imgurl = book.getImgurl();

	        // Implement logic to insert the book details into the database using BookDAO
	        rec = db.insertBook(title, author, price, quantity, publisher, publicationDate, isbn, genre, rating, description, imgurl);

	        System.out.print("...done creating book...");

	    } catch (Exception e) {
	        System.out.print(e.toString());
	    }

	    return rec;
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/updateBook/{bookId}", consumes = "application/json")
	public int updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
	    int rec = 0;

	    try {
	        BookDAO db = new BookDAO();

	        String title = book.getTitle();
	        String author = book.getAuthor();
	        double price = book.getPrice();
	        int quantity = book.getQuantity();
	        String publisher = book.getPublisher();
	        Date publicationDate = book.getDate();
	        String isbn = book.getIsbn();
	        String genre = book.getGenre();
	        double rating = book.getRating();
	        String description = book.getDescription();
	        String imgurl = book.getImgurl();

	        // Implement logic to update the book details into the database using BookDAO
	        rec = db.updateBook(bookId, title, author, price, quantity, publisher, publicationDate, isbn, genre, rating, description, imgurl);

	        System.out.print("...done updating book...");

	    } catch (Exception e) {
	        System.out.print(e.toString());
	    }

	    return rec;
	}
	
	@DeleteMapping("/deleteBook/{bookId}")
    public int deleteBook(@PathVariable("bookId") int bookId) {
        int rec = 0;

        try {
            BookDAO db = new BookDAO();

            // Implement logic to delete the book from the database using BookDAO
            rec = db.deleteBook(bookId);

            System.out.print("...done deleting book...");

        } catch (Exception e) {
            System.out.print(e.toString());
        }

        return rec;
    }

	
}
