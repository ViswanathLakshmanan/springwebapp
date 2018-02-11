package com.retail.app.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long productCode;
	@Column
	@NotNull
	private String productName;
	@Column
	@NotNull
	private String taggedYorN;
	@Column
	@NotNull
	private String weightOrRate;
	
	@Column
	@NotNull
	private String shortName;
	
	@Column
	@DecimalMax(value = "100.0", message = "The decimal value can not be more than 99999.999 ")
	private double wastage;
	
	@ManyToOne
	@JoinColumn(name="metal_code")
	@NotNull
	private Metal metal;
	@Column
	private long operatorCode;
	@Column
	private LocalDateTime updatedOn;

}
