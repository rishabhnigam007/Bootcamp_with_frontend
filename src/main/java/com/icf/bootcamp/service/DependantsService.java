package com.icf.bootcamp.service;

import java.util.List;

import com.icf.bootcamp.model.Dependants;

/**
 * 
 * @author 55683
 *
 */

/*
 * This is all method for Dependant fetching and updating.
 * There is all service method for Dependant Class 
 * */

public interface DependantsService {
 
	/**
	 * This method is for getting list of dependant
	 * @return - list of all dependants
	 */
	public abstract List<Dependants> getAllDependants();

	/**
	 * This method is for getting dependant by specific id only
	 * @param dependantID - dependant id
	 * @return - dependant by id only
	 */
	public abstract Dependants getDependantByID(int dependantID);

	/**
	 * This method is for checking dependant exist or not exist with there id only
	 * @param id - employee id
	 * @return - checking employee by id only
	 */
	public abstract boolean isDependantsExistById(int id);

	/**
	 * This method is for Updating Dependant 
	 * @param dependant - dependants details
	 */
	public abstract void updateDependant(Dependants dependant);

}