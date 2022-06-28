package org.wecancoeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.Cuisine;

import java.util.Collection;

public interface CuisineRepository extends CrudRepository<Cuisine, Long> {
    Cuisine findByFoodTypeIgnoreCase(String foodType);
    Collection<Cuisine> findByLocationIgnoreCase(String location);
}
