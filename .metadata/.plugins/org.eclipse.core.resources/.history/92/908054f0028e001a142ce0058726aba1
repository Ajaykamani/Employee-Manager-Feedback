package com.cts.catalogueService.feignProxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.catalogueService.model.DelivarableStatus;

@FeignClient(name ="api-gateway",url = "http://localhost:8765/")
@RibbonClient(name ="employee-service")
public interface EmployeeFeignProxy {
	
	@PutMapping("/updateRatingStatus")
	public void updatedelivarableRatingStatus(@RequestBody DelivarableStatus delivarableStatus);
	
	@PutMapping("/updateReviewStatus")
	public void updatedelivarableReviewStatus(@RequestBody DelivarableStatus delivarableStatus);
		
}
