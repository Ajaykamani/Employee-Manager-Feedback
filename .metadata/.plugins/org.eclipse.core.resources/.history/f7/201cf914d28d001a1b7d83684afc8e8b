package com.cts.catalogueService.feignProxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.catalogueService.model.RatingDataModel;
import com.cts.catalogueService.model.ReviewDataModel;


@FeignClient(name ="api-gateway",url = "http://localhost:8765/")
@RibbonClient(name ="manager-service")
public interface ManagerFeignProxy {
	@PostMapping("/saveRating")
	public void saveRating(@RequestBody RatingDataModel dataModel);
	
	@PutMapping("/updateReview")
	public void updateReview(@RequestBody ReviewDataModel dataModel);
}
