/*
 * Developed by carlosmartinez.
 * Last modified 28/07/18 14:55.
 * Copyright (c) 2018. All rights reserved.
 */

package mart.karle.spring5webapp.controllers;

import mart.karle.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

  private final AuthorRepository authorRepository;

  public AuthorController(final AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @RequestMapping("/authors")
  public String getAuthors(final Model model) {
    final String viewName = "authors";
    model.addAttribute("authors", authorRepository.findAll());
    return viewName;
  }
}
