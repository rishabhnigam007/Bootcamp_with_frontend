package com.icf.bootcamp.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.icf.bootcamp.model.Employee;

/**
 * @author 55683 
 * This is a Employee Repository for intracting Employee table in database.
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	/**
	 * This is a custom query for fetching list of employee instead of using
	 * hibernate method findAll()
	 * 
	 * @return - list of employee
	 */
	@Query(value = "select * from employee", nativeQuery = true)
	List<Employee> findAllEmployee();

	/**
	 * This is a custom query for fetching employee by ID
	 * 
	 * @param employeeid - employee id
	 * @return - all employee with id only
	 */
	@Query(value = "select * from employee e where e.employeeid=:employeeid", nativeQuery = true)
	Optional<Employee> findByEmployeeId(@Param("employeeid") int employeeid);

	/**
	 * This is a custom query for fetching employee with its pan number
	 * 
	 * @param panNumber - employee pan number
	 * @return - employee with specific pan number
	 */
	@Query(value = "select count(*) from employee e where e.pan_number=:panNumber", nativeQuery = true)
	int existsByPanNumber(@Param("panNumber") String panNumber);

	/**
	 * This is a custom query for fetching employee with reporting manager respect
	 * 
	 * @param reportingManager - finding employee by specific reporting manager only
	 * @return - employee by reporting manager
	 */
	@Query(value = "select count(*) from employee e where e.reporting_manager=:reportingManager", nativeQuery = true)
	int existsByReportingManager(@Valid @Param("reportingManager") String reportingManager);

	/**
	 * This is a custom query for deleting employee by ID
	 * 
	 * @param employeeid - employee id
	 */
//	@Query(value = "delete from employee e where e.employeeid=:employeeid", nativeQuery = true)
//	void deleteByEmployeeId(@Param("employeeid") int employeeid);

}