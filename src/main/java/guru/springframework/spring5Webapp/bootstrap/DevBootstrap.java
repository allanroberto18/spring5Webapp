package guru.springframework.spring5Webapp.bootstrap;

import guru.springframework.spring5Webapp.model.Author;
import guru.springframework.spring5Webapp.model.Book;
import guru.springframework.spring5Webapp.model.Publisher;
import guru.springframework.spring5Webapp.repositories.AuthorRepository;
import guru.springframework.spring5Webapp.repositories.BookRepository;
import guru.springframework.spring5Webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;

  public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData() {
    Publisher objPublisher1 = new Publisher("Harper Collins", "Some Address");
    publisherRepository.save(objPublisher1);

    Publisher objPublisher2 = new Publisher("Worx", "Another Address");
    publisherRepository.save(objPublisher2);

    Author objAuthor1 = new Author("Eric", "Evans");
    Book objBook1 = new Book("Domain Driven Design", "1234", objPublisher1);
    objAuthor1.getBooks().add(objBook1);
    objBook1.getAuthors().add(objAuthor1);

    authorRepository.save(objAuthor1);
    bookRepository.save(objBook1);

    Author objAuthor2 = new Author("Rob", "Johnson");
    Book objBook2 = new Book("J2EE Development with EJB", "23444", objPublisher2);
    objAuthor2.getBooks().add(objBook2);
    objBook2.getAuthors().add(objAuthor2);

    authorRepository.save(objAuthor2);
    bookRepository.save(objBook2);
  }
}
