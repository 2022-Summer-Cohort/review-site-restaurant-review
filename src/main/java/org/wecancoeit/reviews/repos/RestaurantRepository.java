package org.wecancoeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.Restaurant;


public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {
}
