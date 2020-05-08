package com.cts.managerService.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.managerService.entity.RatingData;
import com.cts.managerService.model.RatingDataModel;
import com.cts.managerService.model.ReviewDataModel;

@Service
public interface RatingService {
	public RatingData saveRating(RatingDataModel dataModel);
	public RatingData updateRating(ReviewDataModel dataModel);
	public ResponseEntity<RatingData> getBydelivarableId(Integer delivarableId);
	public ResponseEntity<List<Integer>> getRatingsByOrder();
}