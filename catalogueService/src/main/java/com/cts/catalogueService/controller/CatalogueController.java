package com.cts.catalogueService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.catalogueService.feignProxy.EmployeeFeignProxy;
import com.cts.catalogueService.feignProxy.ManagerFeignProxy;
import com.cts.catalogueService.model.DelivarableData;
import com.cts.catalogueService.model.DelivarableStatus;
import com.cts.catalogueService.model.RatingDataModel;
import com.cts.catalogueService.model.ReviewDataModel;

@RestController
public class CatalogueController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeFeignProxy empProxy;
	
	@Autowired
	private ManagerFeignProxy managerProxy;
	
	@PostMapping("/updateRating")
	public Boolean updateDelivarableRating(@RequestBody DelivarableData delivarableData) {
		RatingDataModel rating = new RatingDataModel();
		rating.setDelivarableId(delivarableData.getDelivarableId());
		rating.setEmployeeId(delivarableData.getEmployeeId());
		rating.setRating(delivarableData.getRating());
		//this.managerProxy.saveRating(rating);
		this.restTemplate.postForObject("http://localhost:8765/manager-service/saveRating", rating, RatingDataModel.class);
		
		DelivarableStatus status = new DelivarableStatus();
		status.setDelivarableId(delivarableData.getDelivarableId());
		status.setEmployeeId(delivarableData.getEmployeeId());
		status.setProjectname(delivarableData.getProjectname());
		status.setRemarks(delivarableData.getRemarks());
		//this.empProxy.updatedelivarableRatingStatus(status);
		this.restTemplate.put("http://localhost:8765/employee-service/updateRatingStatus", status);
		return true;
		
	}
	
	@PostMapping("/updateReview")
	public Boolean updateDelivarableReview(@RequestBody DelivarableData delivarableData) {
		ReviewDataModel review = new ReviewDataModel();
		review.setDelivarableId(delivarableData.getDelivarableId());
		review.setEmployeeId(delivarableData.getEmployeeId());
		review.setRating(delivarableData.getRating());
		review.setReview(delivarableData.getReview());
		//this.managerProxy.updateReview(review);
		this.restTemplate.put("http://localhost:8765/manager-service/updateReview", review);
		//this.restTemplate.exchange("http://localhost:8765/manager-service", HttpMethod.PUT, review,null);
		
		DelivarableStatus status = new DelivarableStatus();
		status.setDelivarableId(delivarableData.getDelivarableId());
		status.setEmployeeId(delivarableData.getEmployeeId());
		status.setProjectname(delivarableData.getProjectname());
		status.setRemarks(delivarableData.getRemarks());
		//this.empProxy.updatedelivarableReviewStatus(status);
		this.restTemplate.put("http://localhost:8765/employee-service/updateReviewStatus", status);
		return true;
		//this.restTemplate.exchange("http://localhost:8765/manager-service", HttpMethod.PUT, review,null);
		
	}
	
	// retrieve all the employees of a manager
	@GetMapping("/getDelivarables/{managerId}")
	public ResponseEntity<DelivarableData> getDelivarables(@PathVariable Integer managerId){
		
		
		return null;
		
	}
}
