package com.practice.projects.grocerymanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.practice.projects.grocerymanager.entity.GroceryEntity;
import com.practice.projects.grocerymanager.service.GroceryManagerService;

@RestController
public class GroceryManagerController {
	@Autowired
	private GroceryManagerService service;

	@RequestMapping("/getAvailableItems")
	public List<GroceryEntity> getAvailableItems(ModelAndView model) {
		return service.getAvailableItems();
	}

	@RequestMapping("/getFinishedItems")
	public List<GroceryEntity> getFinishedItems(ModelAndView model) {
		return service.getFinishedItems();
	}

	@RequestMapping("/getHaveToBuyItems")
	public List<GroceryEntity> getHaveToBuyItems(ModelAndView model) {
		return service.getHaveToBuyItems();
	}

	@RequestMapping("/getAboutToFinishItems")
	public List<GroceryEntity> getAboutToFinishItems(ModelAndView model) {
		return service.getAboutToFinishItems();
	}

	@RequestMapping(value = "/addAnItem", method = RequestMethod.POST)
	public GroceryEntity addAnItem(@Valid @RequestBody GroceryEntity entity, BindingResult bindingResult) {
		return service.addAnItem(entity);
	}

}
