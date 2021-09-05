package com.booksmoviesapp.domain.dto;

import com.booksmoviesapp.domain.BookCategory;
import com.booksmoviesapp.domain.Review;

//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class BookDto {

    private Long bookId;
    private String title;
    private String author;
    private int releaseYear;
    private Long isbn;
    private int pages;
    private Review review;
    private BookCategory category;

    public static class BookBuilder {

        private Long bookId;
        private String title;
        private String author;
        private int releaseYear;
        private Long isbn;
        private int pages;
        private Review review;
        private BookCategory category;

        public BookBuilder bookId(Long bookId) {
            this.bookId = bookId;
            return this;
        }

        public BookBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder releaseYear(int releaseYear) {
            this.releaseYear = releaseYear;
            return this;
        }

        public BookBuilder isbn(Long isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder pages(int pages) {
            this.pages = pages;
            return this;
        }

        public BookBuilder review(Review review) {
            this.review = review;
            return this;
        }

        public BookBuilder category(BookCategory category) {
            this.category = category;
            return this;
        }

        public BookDto build() {
            return new BookDto(bookId, title, author, releaseYear, isbn, pages, review, category);
        }
    }

    public BookDto(Long bookId, String title, String author, int releaseYear, Long isbn, int pages, Review review, BookCategory category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.isbn = isbn;
        this.pages = pages;
        this.review = review;
        this.category = category;
    }

    public BookDto() {}

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }
}
