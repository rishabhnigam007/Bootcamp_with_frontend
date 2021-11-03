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
public class EmployeeViewController {
	
	/**
	 * 
	 * @param model for display title name of the home page
	 * @return home html page
	 */
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home Page");
		return "home";
	}
	
	/**
	 * 
	 * @param model for display title name of the createemployees page
	 * @return createemployees html page
	 */
	@RequestMapping("/createemployees")
	public String createEmployee(Model model)
	{
		model.addAttribute("title", "Register Employee");
		return "createemployees";
	}
	
	/**
	 * 
	 * @param model for display title name of the getallemployees page
	 * @return getallemployees html page
	 */
	@RequestMapping("/getallemployees")
	public String gettingEmployeeList(Model model)
	{
		model.addAttribute("title", "Get All Employee");
		return "getallemployees";
	}
	
	/**
	 * 
	 * @param model for display title name of the getemployeebyid page
	 * @return getemployeebyid html page
	 */
	@RequestMapping("/getemployeebyid")
	public String getEmployeeByID(Model model) {
		model.addAttribute("title", "Get Employee By ID");
		return "getemployeebyid";
	}
	
	/**
	 * 
	 * @param model for display title name of the getemployeebymanager page
	 * @return getemployeebymanager html page
	 */
	@RequestMapping("/getemployeebymanager")
	public String getEmployeeByManager(Model model) {
		model.addAttribute("title", "Get Employee By Manager");
		return "getemployeebymanager";
	}
	
	/**
	 * 
	 * @param model for display title name of the deleteemployeebyid page
	 * @return deleteemployeebyid html page
	 */
	@RequestMapping("/deleteemployeebyid")
	public String deleteEmployeeByID(Model model) {
		model.addAttribute("title", "Delete Employee");
		return "deleteemployeebyid";
	}
	
	/**
	 * 
	 * @param model for display title name of the updateemployeebyid page
	 * @return updateemployeebyid html page
	 */
	@RequestMapping("/updateemployeebyid")
	public String updateEmployeeByID(Model model) {
		model.addAttribute("title", "Update Employee");
		return "updateemployeebyid";
	}

}