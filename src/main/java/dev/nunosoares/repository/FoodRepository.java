package dev.nunosoares.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.nunosoares.model.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

}
