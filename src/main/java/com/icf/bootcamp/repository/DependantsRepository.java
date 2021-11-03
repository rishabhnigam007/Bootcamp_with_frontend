package com.icf.bootcamp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.icf.bootcamp.model.Dependants;

/**
 * @author 55683 This is a Dependant Repository for intracting Dependant table
 *         in database.
 */

@Repository
public interface DependantsRepository extends JpaRepository<Dependants, Integer> {

	/**
	 * This is a custom query for fetching list of dependant instead of using
	 * hibernate method findAll()
	 * 
	 * @return - list of dependant
	 */
	@Query(value = "select * from dependent", nativeQuery = true)
	List<Dependants> findAllDependants();

	/**
	 * This is a custom query for fetching dependant by ID
	 * 
	 * @param dependentid - dependant id
	 * @return - all dependant with id only
	 */
	@Query(value = "select * from dependent d where d.dependentid=:dependentid", nativeQuery = true)
	Optional<Dependants> findByDependantId(@Param("dependentid") int dependentid);

}
