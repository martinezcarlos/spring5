/*
 * Developed by carlosmartinez.
 * Last modified 27/07/18 0:49.
 * Copyright (c) 2018. All rights reserved.
 */

package mart.karle.spring5webapp.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = {"books"})
@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;
  @ManyToMany(mappedBy = "authors")
  private Set<Book> books = new HashSet<>();

  public Author() {
  }

  public Author(final String firstName, final String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Author(final String firstName, final String lastName, final Set<Book> books) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.books = books;
  }
}
