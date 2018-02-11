package com.retail.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.app.domain.MetalRate;

@Repository
public interface MetalRateRepository extends JpaRepository<MetalRate, Long> {

}
