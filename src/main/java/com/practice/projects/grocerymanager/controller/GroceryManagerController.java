package com.practice.projects.grocerymanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String getAvailableItems(ModelAndView model) {
		model.addObject("getHaveToBuyItems", service.getAvailableItems());
		return "showResults";
	}

	@RequestMapping("/getFinishedItems")
	public String getFinishedItems(ModelAndView model) {
		model.addObject("getHaveToBuyItems", service.getFinishedItems());
		return "showResults";
	}

	@RequestMapping("/getHaveToBuyItems")
	public String getHaveToBuyItems(ModelAndView model) {
		model.addObject("getHaveToBuyItems", service.getHaveToBuyItems());
		return "showResults";
	}

	@RequestMapping("/getAboutToFinishItems")
	public String getAboutToFinishItems(ModelAndView model) {
		model.addObject("aboutToFinishList", service.getAboutToFinishItems());
		return "showResults";
	}

	@RequestMapping(value = "/addAnItem", method = RequestMethod.POST)
	public String addAnItem(@RequestBody GroceryEntity entity, ModelAndView model) {
		model.addObject("addedItem", service.addAnItem(entity));
		return "showResults";
	}

}
