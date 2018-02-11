package com.retail.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.app.domain.Metal;
import com.retail.app.repository.MetalRepository;
import com.retail.app.service.MetalService;

@Service
public class MetalServiceImpl implements MetalService{
	
	private final MetalRepository metalRepository;
	
	@Autowired
	public MetalServiceImpl(MetalRepository metalRepository) {
		this.metalRepository = metalRepository;
	}

	@Override
	public List<Metal> getAllMetal() {
		return metalRepository.findAll();
	}

}
