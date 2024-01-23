package ua.mamaiev.springboottemplate.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.mamaiev.springboottemplate.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
