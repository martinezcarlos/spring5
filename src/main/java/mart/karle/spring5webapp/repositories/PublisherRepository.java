/*
 * Developed by carlosmartinez.
 * Last modified 24/07/18 23:13.
 * Copyright (c) 2018. All rights reserved.
 */

package mart.karle.spring5webapp.repositories;

import mart.karle.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
