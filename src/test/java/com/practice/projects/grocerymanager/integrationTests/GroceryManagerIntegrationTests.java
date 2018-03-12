package com.practice.projects.grocerymanager.integrationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.projects.grocerymanager.App;
import com.practice.projects.grocerymanager.entity.GroceryEntity;
import com.practice.projects.grocerymanager.service.GroceryManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = App.class)
@AutoConfigureMockMvc
@ActiveProfiles("testing")
public class GroceryManagerIntegrationTests {

	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getAvailableItems() throws Exception {
		mockMvc.perform(get("/getAvailableItems")).andExpect(status().isOk());

	}

	@Test
	public void getFinishedItems() throws Exception {
		mockMvc.perform(get("/getFinishedItems")).andExpect(status().isOk());
	}

	@Test
	public void getHaveToBuyItems() throws Exception {
		mockMvc.perform(get("/getHaveToBuyItems")).andExpect(status().isOk());
	}


	@Test
	public void getAboutToFinishItems() throws Exception {
		mockMvc.perform(get("/getAboutToFinishItems")).andExpect(status().isOk());
	}

	@Test
	public void addAnItem() throws Exception {
		mockMvc.perform(post("/addAnItem").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsBytes(new GroceryEntity()))).andExpect(status().isOk());
	}

}
