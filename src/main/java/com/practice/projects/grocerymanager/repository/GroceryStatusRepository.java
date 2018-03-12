package com.practice.projects.grocerymanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.projects.grocerymanager.entity.GroceryStatus;
@Repository
public interface GroceryStatusRepository extends CrudRepository<GroceryStatus, Long>{
}

