package com.cts.employeeService.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.employeeService.entity.Delivarable;
import com.cts.employeeService.entity.User;
import com.cts.employeeService.model.DelivarableModel;
import com.cts.employeeService.model.DelivarableStatus;

@Service
public interface EmployeeService {
	public Delivarable saveDelivarable(DelivarableModel delivarableModel);
	public Delivarable updateDelivarableRatingStatus(DelivarableStatus delivarableStatus);
	public Delivarable updateDelivarableReviewStatus(DelivarableStatus delivarableStatus);
	public ResponseEntity<List<Integer>> getEmployeeIds(Integer managerId);
	public ResponseEntity<List<Delivarable>> getDelivarablesByEmployeeId(Integer employeeId);
	public ResponseEntity<User> getUserByManagerId(Integer employeeId,Integer managerId);
}
