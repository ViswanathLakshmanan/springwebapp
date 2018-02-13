package com.retail.app.domain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long purchaseNo;    
	@NotNull
	private long purchaseBillNo;
	@NotNull
	private LocalDateTime purchaseDate;
	@NotNull
	private String dealerName;
	@NotNull
	private String dealerCompany;
	@ManyToOne
	@JoinColumn(name="product_Code")
	@NotNull
	private Product product;                                                     
	private int piece;
	private double grossWt;
	private double netWt;    
	//hidden filed
	private double lessWt;   
	//value pick from metal
	private double rate;                                                            
	private double wastage;                                                         
	private double makingCharge;      
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "purchase")
	private Set<PurchaseAddOn> purchaseAddon;
	/*private long stoneNo;                                                         
	private double stoneWt;                                                         
	private double stoneAmt;                                                        
	private long diamondNo;                                                       
	private double diamondWt;                                                       
	private double diamondAmt;*/
	@NotNull
	private String grossOrNet;                                                      
	private double purchaseTaxPercent;                                              
	private double discount;       
	//Autocalculated field
	private double roundOfAmount;     
	//Cumulative value stone/diamont or othermetal
	private double otherCharge;    
	private double amount;        
	
	private String purchaseType;
	@NotNull
	private String billRefno;
	
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime billRefDate;                                                     
	private String billStatus;                                                      
	private String description; 
// the below added background                                                   
	private int operatorCode;                                                    
	private LocalDateTime updatedOn;                                                     

}
