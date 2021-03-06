package com.briquedeckard.library.book.domain.services.contracts;

import java.util.List;

import com.briquedeckard.library.book.application.services.contracts.dto.BookDTO;
import com.briquedeckard.library.book.domain.aggregates.Book;

/**
 * Services qui font directement appel aux DAO présentés précédemment, afin de
 * récupérer les données, les traiter si nécessaire et les faire transiter vers
 * les services de niveau supérieur qui en ont fait la demande
 * 
 * @author pierr
 *
 */
public interface BookService {

	/**
	 * Delete a book.
	 * 
	 * @param bookId
	 */
	public void deleteBook(Integer bookId);

	/**
	 * Find books by their titles or a part of their titles
	 * 
	 * @param title
	 * @return
	 */
	public List<Book> findBooksByTitleOrPartTitle(String title);

	/**
	 * Find books by their Isbn
	 * 
	 * @param isbn
	 * @return
	 */
	public Book findBookByIsbn(String isbn);

	/**
	 * Check if an ID exists.
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkIfIdExists(Integer id);

	/**
	 * Get alls the books belonging to a category
	 * 
	 * @param codeCategory
	 * @return
	 */
	public List<Book> getBooksByCategory(String codeCategory);

	/**
	 * get all the books
	 * 
	 * @return
	 */
	List<Book> getAllBooks();

	/**
	 * Save a book
	 * 
	 * @param book
	 * @return
	 */
	Book saveBook(BookDTO book);

	/**
	 * Update a book.
	 * 
	 * @param book
	 * @return
	 */
	Book updateBook(BookDTO book);

}
