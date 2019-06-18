package guru.springframework.spring5Webapp.repositories;

import guru.springframework.spring5Webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
