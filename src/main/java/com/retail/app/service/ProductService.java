package com.retail.app.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.retail.app.domain.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public List<Product> getAllProduct();

	public Page<Product> findAll(int page, int i);

	public Boolean deleteProduct(Long id);

	public Product getById(Long id);

	public Product updateProduct(Product product);

}
