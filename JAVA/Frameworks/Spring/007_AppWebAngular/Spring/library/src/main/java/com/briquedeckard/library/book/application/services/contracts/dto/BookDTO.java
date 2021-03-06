package com.briquedeckard.library.book.application.services.contracts.dto;

import java.time.LocalDate;

import com.briquedeckard.library.category.dto.CategoryDTO;

public class BookDTO implements Comparable<BookDTO> {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public Integer getTotalExamplaries() {
		return totalExamplaries;
	}

	public void setTotalExamplaries(Integer totalExamplaries) {
		this.totalExamplaries = totalExamplaries;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	private Integer id;

	private String title;

	private String isbn;

	private LocalDate releaseDate;

	private LocalDate registerDate;

	private Integer totalExamplaries;

	private String author;

	private CategoryDTO category;

	@Override
	public int compareTo(BookDTO o) {
		return title.compareToIgnoreCase(o.getTitle());
	
	}

}
