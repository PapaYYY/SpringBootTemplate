package ua.mamaiev.springboottemplate.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.mamaiev.springboottemplate.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
