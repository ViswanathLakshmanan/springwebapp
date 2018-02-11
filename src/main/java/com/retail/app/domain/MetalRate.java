package com.retail.app.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class MetalRate implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long metalCode;
	@Column
	@NotNull
	private String metalName;
	@Column
	@NotNull
	private String metalShortcode; 
	@Column
	private LocalDateTime onDate;
	@Column
	@DecimalMax(value = "100.00", message = "The decimal value can not be more than 99999.999 ")
    @DecimalMin(value = "1.00", message = "The decimal value can not be less than 1.00 digit ")
	private double purity;
	@Column
	@NotNull
	private String metalUnit;
	@Column
	@DecimalMax(value = "99999.99", message = "The decimal value can not be more than 99999.99 ")
    @DecimalMin(value = "1.00", message = "The decimal value can not be less than 1.00 digit ")
	private double rate;
	@Column
	private long operatorCode;
	@Column
	private LocalDateTime updatedOn;
	
	public long getMetalCode() {
		return metalCode;
	}
	public void setMetalCode(long metalCode) {
		this.metalCode = metalCode;
	}
	public String getMetalName() {
		return metalName;
	}
	public void setMetalName(String metalName) {
		this.metalName = metalName;
	}
	public String getMetalShortcode() {
		return metalShortcode;
	}
	public void setMetalShortcode(String metalShortcode) {
		this.metalShortcode = metalShortcode;
	}
	
	public double getPurity() {
		return purity;
	}
	public void setPurity(double purity) {
		this.purity = purity;
	}
	public String getMetalUnit() {
		return metalUnit;
	}
	public void setMetalUnit(String metalUnit) {
		this.metalUnit = metalUnit;
	}
	
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public long getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(long operatorCode) {
		this.operatorCode = operatorCode;
	}
	public LocalDateTime getOnDate() {
		return onDate;
	}
	public void setOnDate(LocalDateTime onDate) {
		this.onDate = onDate;
	}
	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}
	

}
