package com.cts.managerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.managerService.entityClass.RatingData;
import com.cts.managerService.modelClass.RatingDataModel;
import com.cts.managerService.modelClass.ReviewDataModel;
import com.cts.managerService.service.RatingService;

@RestController
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/saveRating")
	public void saveRating(@RequestBody RatingDataModel dataModel) {
		
		this.ratingService.saveRating(dataModel);
	}
	
	@PutMapping("/updateReview")
	public void updateReview(@RequestBody ReviewDataModel dataModel) {
		
		this.ratingService.updateRating(dataModel);
	}
	
	@GetMapping("/getRating/{delivarableId}")
	public ResponseEntity<RatingData> getRatingByDelivarableId(@PathVariable Integer delivarableId){
		return this.ratingService.getBydelivarableId(delivarableId);
	}
	
	@GetMapping("/getByOrder/{employeeId}")
	public ResponseEntity<List<RatingData>> getRatingsByOrder(@PathVariable Integer employeeId){
		return this.ratingService.getRatingsByOrder(employeeId);
		
	}
	
	
}
