package com.retail.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.app.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public Product findByProductCode(Long id);

}
