package com.luis.coursespring2.bootstrap;

import com.luis.coursespring2.model.Author;
import com.luis.coursespring2.model.Book;
import com.luis.coursespring2.model.Publisher;
import com.luis.coursespring2.repository.AuthorRepository;
import com.luis.coursespring2.repository.BookRepository;
import com.luis.coursespring2.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher pub = new Publisher()
                .setName("Publisher name")
                .setAddress("My adress");

        publisherRepository.save(pub);

        Author author = new Author()
                .setFirstName("Luis 1")
                .setLastName("Alves");

        Book book = new Book()
                .setTitle("A book title 1")
                .setIsbn("1234a")
                .setPublisher(pub);

        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(book);

        Author author2 = new Author()
                .setFirstName("Natalia 2")
                .setLastName("Alves");

        Book book2 = new Book()
                .setTitle("An other book title 2")
                .setIsbn("3210b")
                .setPublisher(pub);

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);

        authorRepository.save(author2);
        bookRepository.save(book2);

    }
}
