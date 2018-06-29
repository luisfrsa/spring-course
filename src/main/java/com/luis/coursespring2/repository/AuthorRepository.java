package com.luis.coursespring2.repository;

import com.luis.coursespring2.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
