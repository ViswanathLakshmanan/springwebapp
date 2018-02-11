package com.retail.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.app.domain.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
