package com.cts.catalogueService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.catalogueService.feignProxy.EmployeeFeignProxy;
import com.cts.catalogueService.feignProxy.ManagerFeignProxy;
import com.cts.catalogueService.model.Delivarable;
import com.cts.catalogueService.model.DelivarableData;
import com.cts.catalogueService.model.DelivarableResponse;
import com.cts.catalogueService.model.DelivarableStatus;
import com.cts.catalogueService.model.RatingData;
import com.cts.catalogueService.model.RatingDataModel;
import com.cts.catalogueService.model.ReviewDataModel;
import com.cts.catalogueService.model.User;
import com.cts.catalogueService.model.UserDetails;

import io.swagger.annotations.Api;



@ControllerAdvice
@RestController
@Api
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
	@GetMapping("/getDelivarablesOrder/{managerId}")
	public ResponseEntity<List<UserDetails>> getDelivarablesBymanagerId(@PathVariable Integer managerId){
			List<Integer> list = this.managerProxy.getRatingsByOrder().getBody();
			List<UserDetails> data = new ArrayList<UserDetails>();
			list.stream().forEach(id->{
				UserDetails userData = new UserDetails();
				User user = this.empProxy.getDetailsByEmployeeIdAndBymanagerId(id, managerId).getBody();
				userData.setUserId(user.getUserId());
				userData.setUserName(user.getUserName());
				userData.setRole(user.getRole());
				userData.setManagerId(user.getManagerId());
				data.add(userData);
			});
			ResponseEntity<List<UserDetails>> result = new ResponseEntity<List<UserDetails>>(data,HttpStatus.OK);
			return result;
	}
	
	//retrieve all delivarables of an employee
	@GetMapping("/getDelivarables/{employeeId}")
	public ResponseEntity<List<DelivarableResponse>> getDelivarablesbyEmployeeId(@PathVariable Integer employeeId){
		List<Delivarable> list = this.empProxy.getDelivarablesByEmployeeId(employeeId).getBody();
		List<DelivarableResponse> response = new ArrayList<DelivarableResponse>();
		list.stream().forEach(delivarable->{
			//delivarableId, employeeId, pojectName, remarks, rated, reviewed, rating, review
			DelivarableResponse data = new DelivarableResponse();
			data.setDelivarableId(delivarable.getId());
			data.setEmployeeId(delivarable.getEmployeeId());
			data.setPojectName(delivarable.getPojectName());
			data.setRemarks(delivarable.getRemarks());
			data.setRated(delivarable.getRated());
			data.setReviewed(delivarable.getReviewed());
			RatingData rating = this.managerProxy.getRatingByDelivarableId(delivarable.getId()).getBody();
			data.setRating(rating.getRating());
			data.setReview(rating.getReview());
			response.add(data);
		});
		ResponseEntity<List<DelivarableResponse>> result = new ResponseEntity<List<DelivarableResponse>>(response,HttpStatus.OK);
		
		return result;
	}
	
	
}
