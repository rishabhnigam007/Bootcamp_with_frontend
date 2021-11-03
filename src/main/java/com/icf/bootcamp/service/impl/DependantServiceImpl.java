package com.icf.bootcamp.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icf.bootcamp.model.Dependants;
import com.icf.bootcamp.repository.DependantsRepository;
import com.icf.bootcamp.service.DependantsService;

/**
 * 
 * @author 55683
 *
 */

/*
 * This is a dependant service implimentation class 
 * here we override all method of dependantservice interface
 * */

@Service
public class DependantServiceImpl implements DependantsService {
	private static final Logger logger = LoggerFactory.getLogger(DependantServiceImpl.class);

	@Autowired
	private DependantsRepository dependantsRepository;

	/**
	 * This method is for getting list of all dependants
	 */
	
	@Override
	public List<Dependants> getAllDependants() {
		logger.info("Getting list of all dependants method called !!");
		List<Dependants> allDependants = dependantsRepository.findAllDependants();
		return allDependants;
	}

	/**
	 * This method is for getting dependant by ID only
	 */

	@Override
	public Dependants getDependantByID(int dependantID) {
		logger.info("Getting Dependant by ID method called !!");
		Optional<Dependants> optionalDependant = dependantsRepository.findByDependantId(dependantID);
		Dependants dependant = optionalDependant.get();
		return dependant;
	}

	/**
	 * This method is for checking dependant whether dependant is exist or not in
	 * our database by using dependantsID
	 */

	@Override
	public boolean isDependantsExistById(int id) {
		logger.info("Checking is dependant exist by Id method called !!");
		return dependantsRepository.existsById(id);
	}

	/**
	 * This method is for updating dependant
	 */

	@Override
	public void updateDependant(Dependants dependant) {
		dependantsRepository.saveAndFlush(dependant);
		logger.info("Update Dependant method called !!");
	}

}
