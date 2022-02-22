package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Books;
import com.service.BooksService;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BooksService booksService;

	@GetMapping(value = "getAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping(value = "getBookById/{bookId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Books> getBookById(@PathVariable("bookId") int bookId) {
		return booksService.getBookById(bookId);
	}

	@PostMapping(value = "storeBooks", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeBooks(@RequestBody Books book) {

		return booksService.storeBook(book);
	}

	@DeleteMapping(value = "deleteBook/{bookId}")
	public String deleteBook(@PathVariable("bookId") int bookId) {
		return booksService.deleteBook(bookId);
	}

	@PatchMapping(value = "updateBookName")
	public String updateBookName(@RequestBody Books book) {
		return booksService.updateBookName(book);
	}

	@PatchMapping(value = "updateAuthor")
	public String updateAuthor(@RequestBody Books book) {
		return booksService.updateAuthor(book);
	}

	@PatchMapping(value = "updateBookGenre")
	public String updateBookGenre(@RequestBody Books book) {
		return booksService.updateBookGenre(book);
	}

	@PatchMapping(value = "updateBookPrice")
	public String uupdateBookPrice(@RequestBody Books book) {
		return booksService.updateBookPrice(book);

	}

	@PatchMapping(value = "updateBookInStock")
	public String updateBookStock(@RequestBody Books book) {
		return booksService.updateBookStock(book);
	}
}
