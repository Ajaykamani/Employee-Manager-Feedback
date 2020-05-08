package com.cts.employeeService.entityClass;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Entity
@Table
public class Authorities implements Serializable {
	
	@Id
	@Column(insertable = true ,name = "username", length=100)
	private String username;
	
	@Id
	@Column(insertable = true ,name = "authority",length=100)
	private String authority;

}
