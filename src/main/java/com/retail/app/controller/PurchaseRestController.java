package com.retail.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.app.domain.Purchase;
import com.retail.app.service.PurchaseService;

@RestController
@RequestMapping("/app/purchase")
public class PurchaseRestController {
	
private static final Logger logger = LoggerFactory.getLogger(PurchaseRestController.class);

	
	//private final ProductService productService;
	private final PurchaseService purchaseService;
	
	@Autowired
	public PurchaseRestController(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
/*List<Customer> cust = new ArrayList<Customer>();
	
	@GetMapping(value = "/all")
	public List<Customer> getResource(){
			return cust;
	}*/
	
	@PostMapping(value="/save")
	public String postCustomer(@RequestBody List<Purchase> purchaseLst){
		System.out.println("Reach rest controller");
		Long purchaseBillNo = purchaseService.addPurchaseList(purchaseLst);
		
		return "Post Successfully!";
	}
	

}
