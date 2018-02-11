package com.retail.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.retail.app.domain.MetalRate;

public interface MetalRateService {

	public void addMetalRate(MetalRate metalRate);

	public List<MetalRate> getAllMetalRate();

	public Page<MetalRate> findAll(int page, int i);

}
