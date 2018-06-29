package com.luis.coursespring2.repository;

import com.luis.coursespring2.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
