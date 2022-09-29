package com.PostgreSql.employees;

import com.PostgreSql.employees.Entity.Employee;
import com.PostgreSql.employees.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
class EmployeesApplicationTests {
	@Autowired
	private EmployeeRepository repo;

	@Test
	public void testCreate(){
		Employee E = new Employee();
		E.setId(15L);
		E.setFirstName("Surya");
		E.setLastName("J");
		E.setEmailId("suryaj@gmail.com");
		repo.save(E);
		assertNotNull(repo.findById(15L).get());
	}

	@Test
	public void readAll(){
		List<Employee> list=repo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	public void testSingleEmployee(){
		Employee employee = repo.findById(8L).get();
		assertEquals("Gokul",employee.getFirstName());
		assertEquals("S",employee.getLastName());
	}

	@Test
	public void updateTest(){
		Employee e = repo.findById(5L).get();
		e.setLastName("S");
		repo.save(e);
		assertNotEquals("s",repo.findById(5L).get().getId());
	}

	@Test
	public void  testDelete(){
		repo.deleteById(14L);
		assertThat(repo.existsById(14L)).isFalse();
	}
}
