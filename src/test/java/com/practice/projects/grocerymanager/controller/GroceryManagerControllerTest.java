package com.practice.projects.grocerymanager.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.projects.grocerymanager.entity.GroceryEntity;
import com.practice.projects.grocerymanager.service.GroceryManagerService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class GroceryManagerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private GroceryManagerService service;
	
	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void getAvailableItems() throws Exception {
		Mockito.when(service.getAvailableItems()).thenReturn(new ArrayList<GroceryEntity>());
		mockMvc.perform(get("/getAvailableItems")).andExpect(status().isOk());

	}

	@Test
	public void getFinishedItems() throws Exception {
		Mockito.when(service.getFinishedItems()).thenReturn(new ArrayList<GroceryEntity>());
		mockMvc.perform(get("/getFinishedItems")).andExpect(status().isOk());
	}

	@Test
	public void getHaveToBuyItems() throws Exception {
		Mockito.when(service.getHaveToBuyItems()).thenReturn(new ArrayList<GroceryEntity>());
		mockMvc.perform(get("/getHaveToBuyItems")).andExpect(status().isOk());
	}



	@Test
	public void getAboutToFinishItems() throws Exception {
		Mockito.when(service.getAboutToFinishItems()).thenReturn(new ArrayList<GroceryEntity>());
		mockMvc.perform(get("/getAboutToFinishItems")).andExpect(status().isOk());
	}

	@Test
	public void addAnItem() throws Exception {
		Mockito.when(service.addAnItem(Mockito.any(GroceryEntity.class))).thenReturn(new GroceryEntity());
		mockMvc.perform(post("/addAnItem").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(new GroceryEntity()))).andExpect(status().isOk());
	}

}
