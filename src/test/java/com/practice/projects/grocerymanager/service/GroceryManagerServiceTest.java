package com.practice.projects.grocerymanager.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.practice.projects.grocerymanager.entity.GroceryEntity;
import com.practice.projects.grocerymanager.repository.GroceryEntityRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(GroceryManagerService.class)
public class GroceryManagerServiceTest {
	@MockBean
	private GroceryEntityRepository repo;
	
	@Autowired
	private GroceryManagerService service;
	@Test
	public void getAvailableItems() {
		Mockito.when(repo.findByStatus_Status("Available")).thenReturn(new ArrayList<GroceryEntity>());
		List<GroceryEntity> results=service.getAvailableItems();
        assertEquals(results.size(), 0);
	}
	@Test
	public void getFinishedItems() {
		Mockito.when(repo.findByStatus_Status("Finished")).thenReturn(new ArrayList<GroceryEntity>());
		List<GroceryEntity> results=service.getAvailableItems();
        assertEquals(results.size(), 0);
	}
	@Test
	public void getHaveToBuyItems() {
		
		Mockito.when(repo.findByStatus_Status("HaveToBuy")).thenReturn(new ArrayList<GroceryEntity>());
		List<GroceryEntity> results=service.getHaveToBuyItems();
        assertEquals(results.size(), 0);
	}
	@Test
	public void getAboutToFinishItems() {
		
		Mockito.when(repo.getAboutToFinishItems()).thenReturn(new ArrayList<GroceryEntity>());
		List<GroceryEntity> results=service.getAboutToFinishItems();
        assertEquals(results.size(), 0);
	}
	@Test
	public void addAnItem() {
		Mockito.when(repo.save(Mockito.any(GroceryEntity.class))).thenReturn(new GroceryEntity());
		GroceryEntity results=service.addAnItem(new GroceryEntity());
        assertEquals(results.getClass(), GroceryEntity.class);
	
	}
}
