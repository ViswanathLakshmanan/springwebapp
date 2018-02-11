package com.retail.app.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class PurchaseAddOn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addonPurchaseSno;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaseNo", nullable = false)
	private Purchase purchase;
	private Long addonProductCode;
	private int addonPiece;

	private double addonGrossWt;

	private double addonNetWt;                                                           
	private double addonLessWt;                                                          
	private double addonRate;  
	private double addonWastage;                                                         
	private double addonMakingCharge;
	private double addonAmount;

}
