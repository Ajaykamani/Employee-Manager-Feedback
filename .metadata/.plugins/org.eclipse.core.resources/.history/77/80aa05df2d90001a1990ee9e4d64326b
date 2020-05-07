package com.cts.employeeService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.employeeService.entityClass.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByuserName(String username);
	List<User> findBymanagerId(Integer managerId);

}

