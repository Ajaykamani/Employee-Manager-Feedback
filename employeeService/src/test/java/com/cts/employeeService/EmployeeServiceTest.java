package com.cts.employeeService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.cts.employeeService.entityClass.Delivarable;
import com.cts.employeeService.modelClass.DelivarableModel;
import com.cts.employeeService.modelClass.DelivarableStatus;
import com.cts.employeeService.repository.DelivarableRepository;
import com.cts.employeeService.repository.UserRepository;
import com.cts.employeeService.service.EmployeeServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeServiceImpl empService;
	
	@Mock
	private UserRepository userRepository;
	
	@Mock
	private DelivarableRepository delivarableRepository;
	
	@Test
	public void saveDelivarable(){
		Delivarable delivarable = new Delivarable(1,1,"project","good",false,false);
		DelivarableModel del = new DelivarableModel(1,"project","good");
		//Delivarable obj_returned = this.empService.saveDelivarable(del);
		when(delivarableRepository.save(delivarable)).thenReturn(delivarable);
		//assertEquals((Delivarable)delivarable,(Delivarable)obj_returned);
		//assertEquals(del.getEmployeeId(),delivarable.getEmployeeId());
		//assertEquals(del,empService.saveDelivarable(del));
		assertEquals(del.getProjectname(),delivarable.getPojectName());
	}

	@Test
	public void updateDelivarableRatingStatus() {
		Delivarable delivarable = new Delivarable(1,1,"abc","good",true,false);
		DelivarableStatus del = new DelivarableStatus(1,1,"abc","poor");
		when(delivarableRepository.save(delivarable)).thenReturn(delivarable);
		//assertEquals(del.getDelivarableId(),delivarable.getId());
		assertEquals(del.getEmployeeId(),delivarable.getEmployeeId());
	}
	
	@Test
	public void updateDelivarableReviewStatus() {
		Delivarable delivarable = new Delivarable(1,1,"abc","good",true,true);
		DelivarableStatus del = new DelivarableStatus(1,1,"abc","poor");
		when(delivarableRepository.save(delivarable)).thenReturn(delivarable);
		assertEquals(del.getDelivarableId(),delivarable.getId());
	}
	
	@Test
	public void getEmployeeIds() {
		ResponseEntity<List<Integer>> list = this.empService.getEmployeeIds(1);
		assertEquals(HttpStatus.OK,list.getStatusCode());			
	}
	
	public void getDelivarablesByEmployeeId() {
		ResponseEntity<List<Delivarable>> result = this.empService.getDelivarablesByEmployeeId(1);
		assertEquals(HttpStatus.OK,result.getStatusCode());
	}


}
