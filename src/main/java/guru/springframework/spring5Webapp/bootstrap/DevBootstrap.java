package guru.springframework.spring5Webapp.bootstrap;

import guru.springframework.spring5Webapp.model.Author;
import guru.springframework.spring5Webapp.model.Book;
import guru.springframework.spring5Webapp.repositories.AuthorRepository;
import guru.springframework.spring5Webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;

  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData() {
    Author objAuthor1 = new Author("Eric", "Evans");
    Book objBook1 = new Book("Domain Driven Design", "1234", "Harper Collins");
    objAuthor1.getBooks().add(objBook1);
    objBook1.getAuthors().add(objAuthor1);

    authorRepository.save(objAuthor1);
    bookRepository.save(objBook1);

    Author objAuthor2 = new Author("Rob", "Johnson");
    Book objBook2 = new Book("J2EE Development with EJB", "23444", "Worx");
    objAuthor2.getBooks().add(objBook2);
    objBook2.getAuthors().add(objAuthor2);

    authorRepository.save(objAuthor2);
    bookRepository.save(objBook2);
  }
}
