package ua.mamaiev.springboottemplate.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.mamaiev.springboottemplate.model.Book;


public interface BookRepository extends CrudRepository<Book, Long> {
}
