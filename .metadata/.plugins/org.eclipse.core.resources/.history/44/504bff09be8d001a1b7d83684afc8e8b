package com.cts.managerService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.managerService.entityClass.RatingData;
import com.cts.managerService.modelClass.RatingDataModel;
import com.cts.managerService.modelClass.ReviewDataModel;
import com.cts.managerService.repository.CustomRatingrepository;
import com.cts.managerService.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private CustomRatingrepository customRepo;
	
	
	@Override
	public void saveRating(RatingDataModel dataModel) {
		// TODO Auto-generated method stub
		RatingData data = new RatingData();
		data.setDelivarableId(dataModel.getDelivarableId());
		data.setEmployeeId(dataModel.getEmployeeId());
		data.setRating(dataModel.getRating());
		
		this.ratingRepository.save(data);
	}

	@Override
	public void updateRating(ReviewDataModel dataModel) {
		// TODO Auto-generated method stub
		
		RatingData data = new RatingData();
		data.setDelivarableId(dataModel.getDelivarableId());
		data.setEmployeeId(dataModel.getEmployeeId());
		data.setRating(dataModel.getRating());
		data.setReview(dataModel.getReview());
		
		this.ratingRepository.save(data);

	}

	@Override
	public ResponseEntity<RatingData> getBydelivarableId(Integer delivarableId) {
		// TODO Auto-generated method stub
		RatingData data  = this.ratingRepository.findBydelivarableId(delivarableId);
		ResponseEntity<RatingData> result = new ResponseEntity<RatingData>(data,HttpStatus.OK);
		return result;
	}

	@Override
	public ResponseEntity<List<RatingData>> getRatingsByOrder(Integer employeeId) {
		// TODO Auto-generated method stub
		List<RatingData> list = this.customRepo.getRatingsByOrder(employeeId);
		ResponseEntity<List<RatingData>> result = new ResponseEntity<List<RatingData>>(list,HttpStatus.OK);
		return result;
	}

}
