package com.shop.lunarlibrary.JADCA2.lunarws.dbaccess;

import java.sql.*;
import java.util.*;
import java.util.Date;






public class BookDAO {
	
	public ArrayList<Book> getAllBooks() throws SQLException, ClassNotFoundException{
		ArrayList<Book> bookList = new ArrayList<Book>();
		Book book = null;
		
		Connection conn = null;
		
		try {
			conn = DBConnection.getConnection();
			String sqlStr = "SELECT * FROM books";
			PreparedStatement pstmt = conn.prepareStatement(sqlStr);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book = new Book();
				book.setBookid(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPublisher(rs.getString("publisher"));
				book.setDate(rs.getDate("publication_date"));
				book.setIsbn(rs.getString("isbn"));
				book.setGenre(rs.getString("genre"));
				book.setRating(rs.getDouble("rating"));
				book.setDescription(rs.getString("description"));
				book.setImgurl(rs.getString("image_url"));
				
				bookList.add(book);
			}
		} catch (Exception e) {
			System.out.print("........... bookDetailsDB:" + e);
		} finally {
			conn.close();
		}
		
		return bookList;
	}
	
public Book getBookDetails(String bookid) throws SQLException{
		
		Book book = null;
		
		Connection conn = null;
		
		try {
			conn = DBConnection.getConnection();
			String sqlStr = "SELECT * FROM books WHERE book_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sqlStr);
			pstmt.setString(1, bookid);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book();
				book.setBookid(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("price"));
				book.setQuantity(rs.getInt("quantity"));
				book.setPublisher(rs.getString("publisher"));
				book.setDate(rs.getDate("publication_date"));
				book.setIsbn(rs.getString("isbn"));
				book.setGenre(rs.getString("genre"));
				book.setRating(rs.getDouble("rating"));
				book.setDescription(rs.getString("description"));
				book.setImgurl(rs.getString("image_url"));
				
			}
		} catch (Exception e) {
			System.out.print("........... bookDetailsDB:" + e);
		} finally {
			conn.close();
		}
		
		return book;
	}

public ArrayList<Book> getBookByTitle(String title) throws SQLException, ClassNotFoundException{
	ArrayList<Book> bookList = new ArrayList<Book>();
	Book book = null;
	
	Connection conn = null;
	
	try {
		conn = DBConnection.getConnection();
		String sqlStr = "SELECT * FROM books WHERE locate(?, title)";
		PreparedStatement pstmt = conn.prepareStatement(sqlStr);
		pstmt.setString(1, title);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			book = new Book();
			book.setBookid(rs.getInt("book_id"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setQuantity(rs.getInt("quantity"));
			book.setPublisher(rs.getString("publisher"));
			book.setDate(rs.getDate("publication_date"));
			book.setIsbn(rs.getString("isbn"));
			book.setGenre(rs.getString("genre"));
			book.setRating(rs.getDouble("rating"));
			book.setDescription(rs.getString("description"));
			book.setImgurl(rs.getString("image_url"));
			
			bookList.add(book);
		}
	} catch (Exception e) {
		System.out.print("........... bookDetailsDB:" + e);
	} finally {
		conn.close();
	}
	
	return bookList;
}

public ArrayList<Book> getBookByAuthor(String author) throws SQLException, ClassNotFoundException{
	ArrayList<Book> bookList = new ArrayList<Book>();
	Book book = null;
	
	Connection conn = null;
	
	try {
		conn = DBConnection.getConnection();
		String sqlStr = "SELECT * FROM books WHERE locate(?, author)";
		PreparedStatement pstmt = conn.prepareStatement(sqlStr);
		pstmt.setString(1, author);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			book = new Book();
			book.setBookid(rs.getInt("book_id"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setQuantity(rs.getInt("quantity"));
			book.setPublisher(rs.getString("publisher"));
			book.setDate(rs.getDate("publication_date"));
			book.setIsbn(rs.getString("isbn"));
			book.setGenre(rs.getString("genre"));
			book.setRating(rs.getDouble("rating"));
			book.setDescription(rs.getString("description"));
			book.setImgurl(rs.getString("image_url"));
			
			bookList.add(book);
		}
	} catch (Exception e) {
		System.out.print("........... bookDetailsDB:" + e);
	} finally {
		conn.close();
	}
	
	return bookList;
}

public ArrayList<Book> getBookByGenre(String genre) throws SQLException, ClassNotFoundException{
	ArrayList<Book> bookList = new ArrayList<Book>();
	Book book = null;
	
	Connection conn = null;
	
	try {
		conn = DBConnection.getConnection();
		String sqlStr = "SELECT * FROM books WHERE genre = ?";
		PreparedStatement pstmt = conn.prepareStatement(sqlStr);
		pstmt.setString(1, genre);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			book = new Book();
			book.setBookid(rs.getInt("book_id"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setPrice(rs.getDouble("price"));
			book.setQuantity(rs.getInt("quantity"));
			book.setPublisher(rs.getString("publisher"));
			book.setDate(rs.getDate("publication_date"));
			book.setIsbn(rs.getString("isbn"));
			book.setGenre(rs.getString("genre"));
			book.setRating(rs.getDouble("rating"));
			book.setDescription(rs.getString("description"));
			book.setImgurl(rs.getString("image_url"));
			
			bookList.add(book);
		}
	} catch (Exception e) {
		System.out.print("........... bookDetailsDB:" + e);
	} finally {
		conn.close();
	}
	
	return bookList;
}

public int insertBook(String title, String author, double price, int quantity, String publisher, Date publication_date, String isbn, String genre, double rating, String description, String imgurl) throws SQLException, ClassNotFoundException {
    Connection conn = null;
    int nrow = 0;

    try {
        conn = DBConnection.getConnection();
        String sqlStr = "INSERT INTO books (title, author, price, quantity, publisher, publication_date, isbn, genre, rating, description, image_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sqlStr);
        pstmt.setString(1, title);
        pstmt.setString(2, author);
        pstmt.setDouble(3, price);
        pstmt.setInt(4, quantity);
        pstmt.setString(5, publisher);
        pstmt.setDate(6, new java.sql.Date(publication_date.getTime())); // Use new java.sql.Date(...)
        pstmt.setString(7, isbn);
        pstmt.setString(8, genre);
        pstmt.setDouble(9, rating);
        pstmt.setString(10, description);
        pstmt.setString(11, imgurl);

        nrow = pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            conn.close();
        }
    }
    return nrow;
}

public int updateBook(int bookId, String title, String author, double price, int quantity, String publisher, Date publication_date, String isbn, String genre, double rating, String description, String imgurl) throws SQLException, ClassNotFoundException {
    Connection conn = null;
    int nrow = 0;

    try {
        conn = DBConnection.getConnection();
        String sqlStr = "UPDATE books SET title=?, author=?, price=?, quantity=?, publisher=?, publication_date=?, isbn=?, genre=?, rating=?, description=?, image_url=? WHERE book_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sqlStr);
        pstmt.setString(1, title);
        pstmt.setString(2, author);
        pstmt.setDouble(3, price);
        pstmt.setInt(4, quantity);
        pstmt.setString(5, publisher);
        pstmt.setDate(6, new java.sql.Date(publication_date.getTime())); // Use new java.sql.Date(...)
        pstmt.setString(7, isbn);
        pstmt.setString(8, genre);
        pstmt.setDouble(9, rating);
        pstmt.setString(10, description);
        pstmt.setString(11, imgurl);
        pstmt.setInt(12, bookId);

        nrow = pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            conn.close();
        }
    }
    return nrow;
}

public int deleteBook(int bookId) throws SQLException, ClassNotFoundException {
    Connection conn = null;
    int nrow = 0;

    try {
        conn = DBConnection.getConnection();
        String sqlStr = "DELETE FROM books WHERE book_id=?";
        PreparedStatement pstmt = conn.prepareStatement(sqlStr);
        pstmt.setInt(1, bookId);

        nrow = pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            conn.close();
        }
    }
    return nrow;
}


}
