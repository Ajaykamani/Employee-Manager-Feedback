package com.cts.managerService.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cts.managerService.entityClass.RatingData;
import com.cts.managerService.modelClass.RatingDataModel;
import com.cts.managerService.modelClass.ReviewDataModel;
import com.cts.managerService.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public RatingData saveRating(RatingDataModel dataModel) {
		// TODO Auto-generated method stub
		RatingData data = new RatingData();
		data.setDelivarableId(dataModel.getDelivarableId());
		data.setEmployeeId(dataModel.getEmployeeId());
		data.setRating(dataModel.getRating());
		 return this.ratingRepository.save(data);
	}

	@Override
	public RatingData updateRating(ReviewDataModel dataModel) {
		// TODO Auto-generated method stub
		RatingData data = new RatingData();
		data.setDelivarableId(dataModel.getDelivarableId());
		data.setEmployeeId(dataModel.getEmployeeId());
		data.setRating(dataModel.getRating());
		data.setReview(dataModel.getReview());
		return this.ratingRepository.save(data);
	}

	@Override
	public ResponseEntity<RatingData> getBydelivarableId(Integer delivarableId) {
		// TODO Auto-generated method stub
		RatingData data  = this.ratingRepository.findBydelivarableId(delivarableId);
		log.info(data.toString());
		log.info(data.getDelivarableId()+"");
		log.info(data.getEmployeeId()+"");
		log.info(data.getReview());
		log.info(data.getRating()+"");
		ResponseEntity<RatingData> result = new ResponseEntity<RatingData>(data,HttpStatus.OK);
		return result;
	}

	@Override
	public ResponseEntity<List<Integer>> getRatingsByOrder() {
		// TODO Auto-generated method stub
		//List<Integer> list = this.customRepo.getRatingsByOrder(employeeId);
		List<Integer> list = this.ratingRepository.findAllemployeeId();
		ResponseEntity<List<Integer>> result = new ResponseEntity<List<Integer>>(list,HttpStatus.OK);
		return result;
	}

}
