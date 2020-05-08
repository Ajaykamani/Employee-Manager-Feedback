package com.cts.employeeService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.employeeService.entity.Delivarable;

public interface DelivarableRepository extends JpaRepository<Delivarable, Integer>{
	
	public List<Delivarable> findByemployeeId(Integer employeeId);

}
