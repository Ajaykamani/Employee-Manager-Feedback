package com.cts.catalogueService.feignProxy;

import java.util.List;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cts.catalogueService.model.DelivarableStatus;
import com.cts.catalogueService.model.User;
import com.cts.catalogueService.model.Delivarable;

@FeignClient(name ="api-gateway",url = "http://localhost:8765/")
@RibbonClient(name ="employee-service")
public interface EmployeeFeignProxy {
	
	@PutMapping("/updateRatingStatus")
	public void updatedelivarableRatingStatus(@RequestBody DelivarableStatus delivarableStatus);
	
	@PutMapping("/updateReviewStatus")
	public void updatedelivarableReviewStatus(@RequestBody DelivarableStatus delivarableStatus);
	
	@GetMapping("/getDelivarables/{employeeId}")
	public ResponseEntity<List<Delivarable>> getDelivarablesByEmployeeId(@PathVariable Integer employeeId);
	
	@GetMapping("/userDetails/{employeeId}/{managerId}")
	public ResponseEntity<User> getDetailsByEmployeeIdAndBymanagerId(@PathVariable Integer employeeId,@PathVariable Integer managerId);
}
