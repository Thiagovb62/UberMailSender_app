package org.yhiagovb62.desafiouber.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yhiagovb62.desafiouber.Model.Category;

@Repository
public interface CategoryRepository  extends MongoRepository<Category, String> {
}
