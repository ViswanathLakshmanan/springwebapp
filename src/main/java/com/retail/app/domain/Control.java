package com.retail.app.domain;

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
public class Control {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sno;
	private long purchaseSno;

}
