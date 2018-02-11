package com.retail.app.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.retail.app.domain.MetalRate;
import com.retail.app.repository.MetalRateRepository;
import com.retail.app.service.MetalRateService;

@Service
public class MetalRateServiceImpl implements MetalRateService{
	
	@Autowired
	private MetalRateRepository metalRateRepository;

	//private List<MetalRate> allMetalRate = new ArrayList<>();
	@Override
	public void addMetalRate(MetalRate metalRate) {
		// TODO Auto-generated method stub
		System.out.println(LocalDate.now());
		metalRate.setOnDate(LocalDateTime.now());
		metalRate.setOperatorCode(1);
		metalRate.setUpdatedOn(LocalDateTime.now());
		MetalRate mr = metalRateRepository.save(metalRate);
		//allMetalRate.add(mr);
	}

	@Override
	public List<MetalRate> getAllMetalRate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MetalRate> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return metalRateRepository.findAll(new PageRequest(page, size,Sort.Direction.DESC,"onDate"));
	}

}
