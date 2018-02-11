package com.retail.app.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.retail.app.domain.Control;
import com.retail.app.domain.Purchase;
import com.retail.app.repository.ControlRepository;
import com.retail.app.repository.PurchaseRepository;
import com.retail.app.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	private final PurchaseRepository purchaseRepository;
	private final ControlRepository controlRepository;
	
	
	@Autowired
	public PurchaseServiceImpl(PurchaseRepository purchaseRepository,ControlRepository controlRepository) {
		this.purchaseRepository = purchaseRepository;
		this.controlRepository = controlRepository;
	}

	@Override
	@Transactional
	public Purchase addPurchase(Purchase purchase) {
		purchase.setOperatorCode(1);
		purchase.setUpdatedOn(LocalDateTime.now());
		Purchase savedPurchase = purchaseRepository.save(purchase);
		return savedPurchase;
	}

	@Override
	public List<Purchase> getAllPurchase() {
		// TODO Auto-generated method stub
		return purchaseRepository.findAll();
	}

	@Override
	public Page<Purchase> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return purchaseRepository.findAll(new PageRequest(page, size));
	}

	@Override
	@Transactional
	public Long addPurchaseList(List<Purchase> purchaseLst) {
		System.out.println("Reach serviceImple");
		Control cntrl = controlRepository.findOne(1l);
		long purchasebillNo = cntrl.getPurchaseSno();
		List<Purchase> validPurchase = new ArrayList<>();
		for(Purchase purchase : purchaseLst){
			purchase.setPurchaseBillNo(purchasebillNo);
			purchase.setPurchaseDate(LocalDateTime.now());
			purchase.setOperatorCode(1);
			purchase.setUpdatedOn(LocalDateTime.now());
			purchase.setBillRefDate(LocalDateTime.now());
			validPurchase.add(purchase);
		}
		purchaseRepository.save(validPurchase);
		cntrl.setPurchaseSno(purchasebillNo+1);
		controlRepository.save(cntrl);
		return purchasebillNo;
	}

}
