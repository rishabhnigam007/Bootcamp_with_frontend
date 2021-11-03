package com.icf.bootcamp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icf.bootcamp.model.Dependants;
import com.icf.bootcamp.service.DependantsService;

/**
 * This is a Spring Rest controller for handling the API operations. This
 * controller exposes various end-points to perform the CRUD operations on the
 * Dependant repository.
 *
 * All the APIs return response in a JSON format. Spring automatically
 * serializes the Java POJO classes into JSON.
 */

/**
 * 
 * @author 55683
 *
 */

@RestController
@JsonFormat
@RequestMapping(value = "/api/")
public class DependantController {
	private static final Logger logger = LoggerFactory.getLogger(DependantController.class);

	@Autowired
	private DependantsService dependantService;

	/**
	 * End-point to return a list of dependants
	 * 
	 * @return - List of all dependants
	 * @throws Exception - when there is no dependant in database
	 */

	/* ========== Get Mapping ========== */

	@GetMapping(value = "v1/getdependants")
	public List<Dependants> getAllDependants() throws Exception {

		logger.info("Getting all Dependants");

		List<Dependants> DependantsList = dependantService.getAllDependants();
		if (DependantsList.size() > 0) {
			logger.info("Getting all list of Dependants successfully !!");
			return DependantsList;
		} else {
			logger.error("There is no dependant !!");
			throw new Exception("There is no Dependants");
		}

	}

	/**
	 * End-point to Get details of a single dependant based on the dependant ID
	 * 
	 * @param id - Dependant id
	 * @return - Dependant by id
	 * @throws Exception - when there is no dependant for this particular id
	 */

	/* ========== Get Mapping ========== */

	@GetMapping(value = "v1/getdependant/{id}")
	public List<Dependants> getdependant(@PathVariable Integer id) throws Exception {

		logger.info("Getting Dependant by ID : " + id);

		try {
			Dependants dependant = dependantService.getDependantByID(id);
			logger.info("Getting Dependant by ID successfully !!");
			List<Dependants> deps = new ArrayList<Dependants>();
			deps.add(dependant);
			return deps;
		} catch (NoSuchElementException e) {
			logger.error("Dependant does not exist with this ID : " + id);
			throw new NoSuchElementException("Dependant does not exist with this ID : " + id);
		}

	}

	/**
	 * End-point to update an dependant.
	 * 
	 * @param dependantID - Dependant Id for updated dependant
	 * @param dependant   - Dependant details
	 * @return - updated dependant
	 * @throws Exception - if Id not present in database for which we want updation
	 */

	/* ========== Put Mapping ========== */

	@PutMapping(value = "v1/updatedependant/{dependantID}")
	public List<Dependants> updateDependant(@PathVariable("dependantID") int dependantID,
			@RequestBody Dependants dependant) throws Exception {

		logger.info("Dependant Updation...");

		boolean isDependantExist = dependantService.isDependantsExistById(dependantID);

		if (isDependantExist) {
			dependant.setDependentID(dependantID);
			dependantService.updateDependant(dependant);
			logger.info("Dependant update successfully !!");
			List<Dependants> updatedependant = new ArrayList<Dependants>();
			updatedependant.add(dependant);
			return updatedependant;
		} else {
			logger.error("Dependant does not exist with this ID : " + dependantID);
			throw new NoSuchElementException("Dependant does not exist with this ID : " + dependantID);
		}
	}

}
