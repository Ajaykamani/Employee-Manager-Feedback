package com.cts.managerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.cts.managerService.entityClass.RatingData;

@Repository
public interface RatingRepository extends JpaRepository<RatingData,Integer>{
	public RatingData findBydelivarableId(Integer delivarableId);
	
	@Query("select r.employeeId from RatingData r group by employeeId order by avg(rating) desc")
	public List<Integer> findAllemployeeId();
	
}
