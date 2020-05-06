package com.cts.managerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.managerService.entityClass.RatingData;

@Repository
public interface RatingRepository extends JpaRepository<RatingData, Integer>{
	public RatingData findBydelivarableId(Integer delivarableId);
	
}
