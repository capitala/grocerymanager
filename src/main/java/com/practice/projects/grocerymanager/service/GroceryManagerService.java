package com.practice.projects.grocerymanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.projects.grocerymanager.entity.GroceryEntity;
import com.practice.projects.grocerymanager.repository.GroceryEntityRepository;
@Service
public class GroceryManagerService {
	@Autowired
	private GroceryEntityRepository repo;
	

	public List<GroceryEntity> getAvailableItems() {
	return repo.findByStatus_Status("Available");
	}

	public List<GroceryEntity> getFinishedItems() {
		return repo.findByStatus_Status("Finished");
	}

	public List<GroceryEntity> getHaveToBuyItems() {
		return repo.findByStatus_Status("HaveToBuy");
	}

	public List<GroceryEntity> getAboutToFinishItems() {
		return repo.getAboutToFinishItems();
	}

	public GroceryEntity addAnItem(GroceryEntity entity) {
		return repo.save(entity);
	}

}
