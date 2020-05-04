package com.cts.employeeService.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employeeService.entityClass.Delivarable;
import com.cts.employeeService.modelClass.DelivarableModel;
import com.cts.employeeService.modelClass.DelivarableStatus;
import com.cts.employeeService.service.EmployeeService;

import io.swagger.annotations.Api;

@ControllerAdvice
@RestController
@Api
@RefreshScope
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/saveDelivarable")
	public void saveDelivarable(@RequestBody DelivarableModel delivarableModel ) {
		
		//logger.info("In Controller ----> "+delivarableModel.getEmployeeId());
		
		this.employeeService.saveDelivarable(delivarableModel);
		
	}
	
	@PutMapping("/updateRatingStatus")
	public void updatedelivarableRatingStatus(@RequestBody DelivarableStatus delivarableStatus) {
		
		this.employeeService.updateDelivarableRatingStatus(delivarableStatus);
	}
	
	@PutMapping("/updateReviewStatus")
	public void updatedelivarableReviewStatus(@RequestBody DelivarableStatus delivarableStatus) {
		
		this.employeeService.updateDelivarableReviewStatus(delivarableStatus);
	}
	
	@GetMapping("/employeeIds/{managerId}")
	public ResponseEntity<List<Integer>> getEmployeeIdsBymanagerId(@PathVariable Integer managerId){
		return this.employeeService.getEmployeeIds(managerId);
	}
	
	@GetMapping("/getDelivarables/{employeeId}")
	public ResponseEntity<List<Delivarable>> getDelivarablesByEmployeeId(@PathVariable Integer employeeId){
		return this.employeeService.getDelivarablesByEmployeeId(employeeId);
	}
	
}
