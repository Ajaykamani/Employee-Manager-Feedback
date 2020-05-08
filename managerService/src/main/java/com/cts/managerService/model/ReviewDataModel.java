package com.cts.managerService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDataModel {
	
	private Integer delivarableId;
	
	private Integer employeeId;
	
	private Integer rating;
	
	private String review;
}
