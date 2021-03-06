/*
 * Developed by carlosmartinez.
 * Last modified 29/07/18 16:35.
 * Copyright (c) 2018. All rights reserved.
 */

package mart.karle.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"id"})
@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String address;

  public Publisher(final String name, final String address) {
    this.name = name;
    this.address = address;
  }
}
