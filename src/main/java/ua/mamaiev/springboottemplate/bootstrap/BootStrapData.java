package ua.mamaiev.springboottemplate.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.mamaiev.springboottemplate.model.Author;
import ua.mamaiev.springboottemplate.model.Book;
import ua.mamaiev.springboottemplate.model.Publisher;
import ua.mamaiev.springboottemplate.repositories.AuthorRepository;
import ua.mamaiev.springboottemplate.repositories.BookRepository;
import ua.mamaiev.springboottemplate.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
    
    private final AuthorRepository authorRepository;
    
    private final BookRepository bookRepositiry;
    
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, 
                         BookRepository bookRepositiry, 
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepositiry = bookRepositiry;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher1 = new Publisher("Publisher1",
                "line1",
                "city1",
                "state1",
                "zip1");
        Author eric = new Author("Eric", "Evabs");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123999");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        
        publisher1.getBooks().add(ddd);
        ddd.setPublisher(publisher1);
        
        publisher1.getBooks().add(noEJB);
        noEJB.setPublisher(publisher1);

        publisherRepository.save(publisher1);

        authorRepository.save(eric);
        bookRepositiry.save(ddd);

        authorRepository.save(rod);
        bookRepositiry.save(noEJB);
        
        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepositiry.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
