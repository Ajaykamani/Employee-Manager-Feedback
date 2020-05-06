package com.cts.managerService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.managerService.entityClass.RatingData;
import com.cts.managerService.modelClass.RatingDataModel;
import com.cts.managerService.modelClass.ReviewDataModel;
import com.cts.managerService.service.RatingService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


import io.swagger.annotations.Api;

@ControllerAdvice
@RestController
@Api
@RefreshScope
public class RatingController {
	
	@Autowired
	private RatingService ratingService;

	
	@Value("${msg:Config Server is not working. Please check...}")
    private String msg;
	
	@HystrixCommand(fallbackMethod = "fallBackGetMsg" , commandProperties = {
		      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
	   })
    @GetMapping("/msg")
    public String getMsg() {
        return this.msg;
    }
    public String fallBackGetMsg() {
        return "fall back method";
    }
	
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
	
	@GetMapping("/getByOrder")
	public ResponseEntity<List<Integer>> getRatingsByOrder(){
		return this.ratingService.getRatingsByOrder();
		
	}
	
	
}
