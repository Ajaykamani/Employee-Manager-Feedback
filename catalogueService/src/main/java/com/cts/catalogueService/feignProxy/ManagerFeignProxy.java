package com.cts.catalogueService.feignProxy;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.catalogueService.model.RatingData;
import com.cts.catalogueService.model.RatingDataModel;
import com.cts.catalogueService.model.ReviewDataModel;


@FeignClient(name ="api-gateway",url = "http://localhost:8765/")
@RibbonClient(name ="manager-service")
public interface ManagerFeignProxy {
	
	@PostMapping("/saveRating")
	public void saveRating(@RequestBody RatingDataModel dataModel);
	
	@PutMapping("/updateReview")
	public void updateReview(@RequestBody ReviewDataModel dataModel);
	
	@GetMapping("/getRating/{delivarableId}")
	public ResponseEntity<RatingData> getRatingByDelivarableId(@PathVariable Integer delivarableId);
	
	@GetMapping("/getByOrder}")
	public ResponseEntity<List<Integer>> getRatingsByOrder();
		

}
