package org.wecancoeit.reviews.repos;

import org.springframework.data.repository.CrudRepository;
import org.wecancoeit.reviews.model.Review;


public interface reviewRepository extends CrudRepository<Review, Long>{
}
