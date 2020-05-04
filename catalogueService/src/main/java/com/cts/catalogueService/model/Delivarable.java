package com.cts.catalogueService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Delivarable {
	
	private Integer id;
	
	private Integer employeeId;
	
	private String pojectName;
	
	private String remarks;
	
	private Boolean rated;
	
	private Boolean reviewed;
	
}
