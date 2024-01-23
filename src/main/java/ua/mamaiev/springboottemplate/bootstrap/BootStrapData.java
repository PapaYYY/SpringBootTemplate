package ua.mamaiev.springboottemplate.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.mamaiev.springboottemplate.model.Author;
import ua.mamaiev.springboottemplate.model.Book;
import ua.mamaiev.springboottemplate.repositories.AuthorRepository;
import ua.mamaiev.springboottemplate.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {
    
    private final AuthorRepository authorRepository;
    
    private final BookRepository bookRepositiry;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepositiry) {
        this.authorRepository = authorRepository;
        this.bookRepositiry = bookRepositiry;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evabs");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123999");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        
        authorRepository.save(eric);
        bookRepositiry.save(ddd);

        authorRepository.save(rod);
        bookRepositiry.save(noEJB);

        System.out.println("Started in bootstrap");
        System.out.printf("Number of books: " + bookRepositiry.count());
        
    }
}
