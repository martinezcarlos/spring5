/*
 * Developed by carlosmartinez.
 * Last modified 28/07/18 15:42.
 * Copyright (c) 2018. All rights reserved.
 */

package mart.karle.spring5webapp.bootstrap;

import mart.karle.spring5webapp.model.Author;
import mart.karle.spring5webapp.model.Book;
import mart.karle.spring5webapp.model.Publisher;
import mart.karle.spring5webapp.repositories.AuthorRepository;
import mart.karle.spring5webapp.repositories.BookRepository;
import mart.karle.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public DevBootstrap(final AuthorRepository authorRepository, final BookRepository bookRepository,
      final PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(final ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData() {
    //Eric
    final Author eric = new Author("Eric", "Evans");
    final Publisher hc = new Publisher("Harper Collins", "Harp street, 123");
    final Book ddd = new Book("Domain Driven Design", "1234", hc);
    eric.getBooks().add(ddd);
    ddd.getAuthors().add(eric);

    publisherRepository.save(hc);
    authorRepository.save(eric);
    bookRepository.save(ddd);

    //Rod
    final Author rod = new Author("Rod", "Johnson");
    final Publisher worx = new Publisher("Worx", "Worx street, 123");
    final Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
    rod.getBooks().add(noEJB);
    noEJB.getAuthors().add(rod);

    publisherRepository.save(worx);
    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }
}
