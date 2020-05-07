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

import com.cts.managerService.entityClass.RatingData;
import com.cts.managerService.modelClass.RatingDataModel;
import com.cts.managerService.repository.RatingRepository;
import com.cts.managerService.service.RatingService;
import com.cts.managerService.service.RatingServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManagerServiceServiceTests {
	
	@InjectMocks
	private RatingServiceImpl ratingService;
	
	@Mock
	private RatingRepository ratingRepository;
	
	@Test
	public void saveRating() {
		RatingDataModel model = new RatingDataModel(5,6,3);
		RatingData actualObj = this.ratingService.saveRating(model);
		RatingData expectedObj = new RatingData();
		expectedObj.setDelivarableId(1);
		expectedObj.setEmployeeId(2);
		expectedObj.setRating(1);
		assertEquals(expectedObj.getDelivarableId(),actualObj.getDelivarableId());
	}
	
	@Test
	public void getByDelivarableId() {
		ResponseEntity<RatingData> delivarable = this.ratingService.getBydelivarableId(1);
		assertEquals(HttpStatus.OK,delivarable.getStatusCode());
	}
	
	@Test
	public void getRatingsByOrder() {
		ResponseEntity<List<Integer>> data = this.ratingService.getRatingsByOrder();
		assertEquals(HttpStatus.OK,data.getStatusCode());
	}
}
