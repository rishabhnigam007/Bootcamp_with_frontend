package com.icf.bootcamp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.icf.bootcamp.model.Dependants;
import com.icf.bootcamp.model.Employee;
import com.icf.bootcamp.repository.DependantsRepository;
import com.icf.bootcamp.repository.EmployeeRepository;
import com.icf.bootcamp.service.DependantsService;
import com.icf.bootcamp.service.EmployeeService;

/**
 * 
 * @author 55683
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BootcampApplicationTests {

	@MockBean
	private EmployeeRepository employeeRepository;
	@MockBean
	private DependantsRepository dependantsRepository;
	@MockBean
	private EmployeeService employeeService;
	@MockBean
	private DependantsService dependantsService;

	/**
	 * 
	 * @throws ParseException - This method is for testing getAllEmployee method
	 */
	@Test
	@Order(1)
	public void getAllEmployeesTest() throws ParseException {
		String date = "1997-02-07";
		Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		Employee employee = new Employee();
		employee.setEmployeeID((int) Math.random());
		employee.setFirstName("james");
		employee.setLastName("gosling");
		employee.setGender("male");
		employee.setDob(dob);
		employee.setStartDate(dob);
		employee.setQualification("ms");
		employee.setAddress("usa");
		employee.setPanNumber("asdf");
		employee.setDesignation("ms");
		employee.setDepartment("operation");
		employee.setEndDate(dob);
		employee.setStatus("working");
		employee.setReportingManager("creator");
		employee.setBloodGroup("a+");
		employee.setDependents(null);

		employeeRepository.save(employee);
		assertThat(employeeRepository.findByEmployeeId(employee.getEmployeeID())).isNotNull();
	}

	/**
	 * 
	 * @throws ParseException - This method is for testing createEmployee method
	 */
	@Test
	@Order(2)
	public void createEmployeeTest() throws ParseException {

		String date = "1997-02-07";
		Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		Employee employee = new Employee((int) Math.random(), "bjanre", "stroustrop", "male", dob, dob, "ms", "usa",
				"asdf", "creator", "operation", dob, "working", "qwerty", "o+", null);

		Employee employeeJsonObject = employeeRepository.save(employee);

		if (employeeJsonObject != null) {
			assertTrue(true);
		} else {
			assertFalse(false);
		}

	}

	/**
	 * 
	 * @throws ParseException - This method is for testing getEmployeeByID method
	 */
	@Test
	@Order(3)
	public void getEmployeeByIDTest() throws ParseException {

		String date = "1997-02-07";
		Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		Employee employee = new Employee((int) Math.random(), "tim", "berner", "male", dob, dob, "ms", "us", "asdf",
				"creator", "operation", dob, "working", "qwerty", "a+", null);

		employeeRepository.save(employee);

		Employee employeeByID = employeeService.getEmployeeByID(employee.getEmployeeID());
		boolean isExistById = false;
		if (employeeByID != null) {
			isExistById = true;
			assertTrue(isExistById);
		} else {
			assertFalse(isExistById);
		}
	}

	/**
	 * 
	 * @throws ParseException - This method is for testing deleteEmployee method
	 */
	@Test
	@Order(4)
	public void deleteEmployeeTest() throws ParseException {

		String date = "1997-02-07";
		Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		Employee employee = new Employee((int) Math.random(), "james", "gosling", "male", dob, dob, "ms", "usa", "asdf",
				"creator", "operation", dob, "working", "qwerty", "a+", null);

		employeeRepository.save(employee);

		employeeService.deleteEmployee(employee.getEmployeeID());
		if (employeeService.isEmployeeExistById(employee.getEmployeeID())) {
			assertFalse(false);
		} else {
			assertTrue(true);
		}

	}

	/**
	 * 
	 * @throws ParseException - This method is for testing getAllDependants method
	 */
	@Test
	@Order(5)
	public void getAllDependantsTest() throws ParseException {

		String date = "1997-02-07";
		Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		Dependants dependants = new Dependants((int) Math.random(), "roman", "reign", "male", dob, "brother");

		dependantsRepository.save(dependants);
		assertThat(dependantsRepository.findById(dependants.getDependentID())).isNotNull();
	}

	/**
	 * 
	 * @throws ParseException - This method is for testing getDependantByID method
	 */
	@Test
	@Order(6)
	public void getDependantByID() throws ParseException {

		String date = "1997-02-07";
		Date dob = new SimpleDateFormat("yyyy-MM-dd").parse(date);

		Dependants dependants = new Dependants((int) Math.random(), "roman", "reign", "male", dob, "brother");

		dependantsRepository.save(dependants);

		Dependants dependantByID = dependantsService.getDependantByID(dependants.getDependentID());
		boolean isExistById = false;
		if (dependantByID != null) {
			isExistById = true;
			assertTrue(isExistById);
		} else {
			assertFalse(isExistById);
		}

	}

}