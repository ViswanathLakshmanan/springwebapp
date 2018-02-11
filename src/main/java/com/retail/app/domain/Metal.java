package com.retail.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Metal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long metalId;
	@Column
	private String metalCode;
	@Column
	private String metalName;
	@Column
	private String metalType;
	@Column
	private double metalRate;
}
