package com.cts.managerService.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.managerService.entity.RatingData;
import com.cts.managerService.model.RatingDataModel;
import com.cts.managerService.model.ReviewDataModel;
import com.cts.managerService.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	//It saves the rating of a delivarable
	@Override
	public RatingData saveRating(RatingDataModel dataModel) {
		RatingData data = new RatingData();
		data.setDelivarableId(dataModel.getDelivarableId());
		data.setEmployeeId(dataModel.getEmployeeId());
		data.setRating(dataModel.getRating());
		 return this.ratingRepository.save(data);
	}
	
	//It update the review pf a delivarable
	@Override
	public RatingData updateRating(ReviewDataModel dataModel) {
		RatingData data = new RatingData();
		data.setDelivarableId(dataModel.getDelivarableId());
		data.setEmployeeId(dataModel.getEmployeeId());
		data.setRating(dataModel.getRating());
		data.setReview(dataModel.getReview());
		return this.ratingRepository.save(data);
	}
	
	//It retrueves the rating data by delivarable id
	@Override
	public ResponseEntity<RatingData> getBydelivarableId(Integer delivarableId) {
		RatingData data  = this.ratingRepository.findBydelivarableId(delivarableId);
		return new ResponseEntity<RatingData>(data,HttpStatus.OK);
	}

	//It retrieves the employee ids based on average of rating
	@Override
	public ResponseEntity<List<Integer>> getRatingsByOrder() {
		List<Integer> list = this.ratingRepository.findAllemployeeId();
		return  new ResponseEntity<List<Integer>>(list,HttpStatus.OK);
	}

}