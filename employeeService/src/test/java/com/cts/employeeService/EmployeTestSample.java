package com.cts.employeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.cts.employeeService.controller.EmployeeController;
import com.cts.employeeService.entityClass.Delivarable;
import com.cts.employeeService.service.EmployeeService;

@RunWith(SpringRunner.class)
public class EmployeTestSample {

	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	EmployeeService employeeService;
	
	
	@Test
	public void getEmployeeIdsBymanagerId(){
		ResponseEntity<List<Integer>> data = this.employeeController.getEmployeeIdsBymanagerId(1);
		assertEquals(HttpStatus.OK, data.getStatusCode());
	}
	
	@Test
	public void getDelivarablesByEmployeeIdTest() {
		ResponseEntity<List<Delivarable>> data = this.employeeController.getDelivarablesByEmployeeId(1);
		assertEquals(HttpStatus.OK, data.getStatusCode());
	}
}