package com.retail.app.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.retail.app.domain.Product;
import com.retail.app.repository.ProductRepository;
import com.retail.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product addProduct(Product product) {
		product.setOperatorCode(1);
		product.setUpdatedOn(LocalDateTime.now());
		Product savedProduct = productRepository.save(product);
		return savedProduct;
		
	}

	@Override
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override
	public Page<Product> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return productRepository.findAll(new PageRequest(page, size,Sort.Direction.ASC,"productName"));
	}

	@Override
	public Boolean deleteProduct(Long id) {
		Boolean status = false;
		try{
			productRepository.delete(id);
			status=true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
		
	}

	@Override
	public Product getById(Long id) {
		
		Product product = productRepository.findByProductCode(id);
		
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		Product updatedProduct = null;
		Product exist = productRepository.findByProductCode(product.getProductCode());
		if(exist != null)
		{
			exist.setMetal(product.getMetal());
			exist.setOperatorCode(1);
			exist.setProductName(product.getProductName());
			exist.setShortName(product.getShortName());
			exist.setTaggedYorN(product.getTaggedYorN());
			exist.setUpdatedOn(LocalDateTime.now());
			exist.setWastage(product.getWastage());
			exist.setWeightOrRate(product.getWeightOrRate());
            updatedProduct = productRepository.save(exist);
			
		}
		return updatedProduct;
	}

}
