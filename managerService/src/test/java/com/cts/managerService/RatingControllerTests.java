package com.cts.managerService;



import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.managerService.controller.RatingController;
import com.cts.managerService.entityClass.RatingData;
import com.cts.managerService.repository.RatingRepository;
import com.cts.managerService.service.RatingServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RatingControllerTests {
	@InjectMocks
	private RatingController ratingController;
	
	/*@Mock
	private RatingServiceImpl ratingService;*/
	
	@Mock
	private RatingRepository ratingRepository;
	
	@Test
	public void getRatingsByOrder() {
		ResponseEntity<List<Integer>> data = this.ratingController.getRatingsByOrder();
		assertEquals(HttpStatus.OK,data.getStatusCode());
	}
	
	@Test
	public void getRatingById() {
		ResponseEntity<RatingData> data = this.ratingController.getRatingByDelivarableId(1);
		assertEquals(HttpStatus.OK,data.getStatusCode());
	}
}
