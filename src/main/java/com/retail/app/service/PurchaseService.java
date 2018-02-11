package com.retail.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.retail.app.domain.Purchase;

public interface PurchaseService {

	public Purchase addPurchase(Purchase purchase);

	public List<Purchase> getAllPurchase();

	public Page<Purchase> findAll(int page, int size);

	public Long addPurchaseList(List<Purchase> purchaseLst);
	
	

}
