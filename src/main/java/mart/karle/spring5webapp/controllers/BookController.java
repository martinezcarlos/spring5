/*
 * Developed by carlosmartinez.
 * Last modified 27/07/18 0:42.
 * Copyright (c) 2018. All rights reserved.
 */

package mart.karle.spring5webapp.controllers;

import mart.karle.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

  private final BookRepository bookRepository;

  public BookController(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @RequestMapping("/books")
  public String getBooks(final Model model) {
    final String viewName = "books";
    model.addAttribute("books", bookRepository.findAll());
    return viewName;
  }
}
