package com.cts.catalogueService.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RatingData {

	private Integer delivarableId;
	
	private Integer employeeId;
	
	private Integer rating;
	
	private String review;
}
