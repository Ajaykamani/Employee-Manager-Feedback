package com.cts.employeeService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DelivarableStatus {
	
	private Integer delivarableId;
	private Integer EmployeeId;
	private String projectname;
	private String remarks;
	
}
