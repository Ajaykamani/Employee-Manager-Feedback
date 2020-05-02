package com.cts.employeeService.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.employeeService.modelClass.DelivarableModel;
import com.cts.employeeService.modelClass.DelivarableStatus;

@Service
public interface EmployeeService {
	public void saveDelivarable(DelivarableModel delivarableModel);
	public void updateDelivarableRatingStatus(DelivarableStatus delivarableStatus);
	public void updateDelivarableReviewStatus(DelivarableStatus delivarableStatus);
	public ResponseEntity<List<Integer>> getEmployeeIds(Integer managerId);
}
