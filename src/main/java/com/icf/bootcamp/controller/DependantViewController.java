package com.icf.bootcamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author 55683
 *
 */
@Controller
@RequestMapping("/api/v1")
public class DependantViewController {

	/**
	 * 
	 * @param model for display title name of the getalldependant page
	 * @return getalldependant html page
	 */
	@RequestMapping("/getalldependant")
	public String gettingDependantList(Model model) {
		model.addAttribute("title", "Get All Dependants");
		return "getalldependant";
	}

	/**
	 * 
	 * @param model for display title name of the getdependantbyid page
	 * @return getdependantbyid html page
	 */
	@RequestMapping("/getdependantbyid")
	public String getDependantByID(Model model) {
		model.addAttribute("title", "Get Dependant By ID");
		return "getdependantbyid";
	}
	
	/**
	 * 
	 * @param model for display title name of the updatedependantbyid page
	 * @return updatedependantbyid html page
	 */
	@RequestMapping("/updatedependantbyid")
	public String updateDependantByID(Model model) {
		model.addAttribute("title", "Update Dependant");
		return "updatedependantbyid";
	}
}