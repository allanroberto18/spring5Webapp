package guru.springframework.spring5Webapp.repositories;

import guru.springframework.spring5Webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
