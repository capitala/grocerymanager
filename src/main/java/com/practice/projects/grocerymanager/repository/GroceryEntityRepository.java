package com.practice.projects.grocerymanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.projects.grocerymanager.entity.GroceryEntity;

@Repository
public interface GroceryEntityRepository extends CrudRepository<GroceryEntity, Long> {
	@Query("Select ge from grocery_entity ge where ge.probable_end_date>DATE() AND ge.probable_end_date<DATE()")
	public List<GroceryEntity> getAboutToFinishItems();

	public List<GroceryEntity> findByStatus_Status(String status);
}
