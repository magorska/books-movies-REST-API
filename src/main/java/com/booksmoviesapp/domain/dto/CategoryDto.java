package com.booksmoviesapp.domain.dto;

import com.booksmoviesapp.domain.Book;
import com.booksmoviesapp.domain.Category;
import com.booksmoviesapp.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class CategoryDto {

    private Long categoryId;
    private String categoryName;
    private List<Book> booksCategory;
    private List<Movie> moviesCategory;

    public static class CategoryBuilder {
        private Long categoryId;
        private String categoryName;
        private List<Book> booksCategories = new ArrayList<>();
        private List<Movie> moviesCategories = new ArrayList<>();

        public CategoryBuilder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public CategoryBuilder categoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public CategoryBuilder booksCategory(Book booksCategory) {
            booksCategories.add(booksCategory);
            return this;
        }

        public CategoryBuilder moviesCategory(Movie movieCategory) {
            moviesCategories.add(movieCategory);
            return this;
        }

        public CategoryDto build() {
            return new CategoryDto(categoryId, categoryName, booksCategories, moviesCategories);
        }
    }

    public CategoryDto(Long categoryId, String categoryName, List<Book> booksCategory, List<Movie> moviesCategory) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.booksCategory = new ArrayList<>(booksCategory);
        this.moviesCategory = new ArrayList<>(moviesCategory);
    }

    public CategoryDto() {}

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Book> getBooksCategory() {
        return booksCategory;
    }

    public void setBooksCategory(List<Book> booksCategory) {
        this.booksCategory = booksCategory;
    }

    public List<Movie> getMoviesCategory() {
        return moviesCategory;
    }

    public void setMoviesCategory(List<Movie> moviesCategory) {
        this.moviesCategory = moviesCategory;
    }
}
