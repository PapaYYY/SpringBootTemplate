package ua.mamaiev.springboottemplate.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.mamaiev.springboottemplate.model.Book;


public interface BookRepositiry extends CrudRepository<Book, Long> {
}
