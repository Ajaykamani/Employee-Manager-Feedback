package com.cts.managerService.entityClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class RatingData {
	
	@Id
	@Column(insertable = true)
	private Integer delivarableId;
	
	@Column
	private Integer employeeId;
	
	@Column
	private Integer rating;
	
	@Column
	private String review;
}
