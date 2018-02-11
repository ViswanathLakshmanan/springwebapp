package com.retail.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.retail.app.domain.Product;
import com.retail.app.domain.Purchase;
import com.retail.app.repository.ProductRepository;
import com.retail.app.repository.PurchaseRepository;
import com.retail.app.service.ProductService;
import com.retail.app.service.PurchaseService;

@Controller
@RequestMapping("app")
public class PurchaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);
	
	private final ProductService productService;
	private final PurchaseService purchaseService;
	
	@Autowired
	public PurchaseController(PurchaseService purchaseService,ProductService productService) {
		this.purchaseService = purchaseService;
		this.productService = productService;
	}
	
	@GetMapping("/")
	public String showPage(Model model,@RequestParam(defaultValue="0") int page){
		model.addAttribute("allPurchases", purchaseService.findAll(page,1));
		model.addAttribute("currentPage", page);
		return "purchase-view";
		
	}
	
	@GetMapping("create-purchase")
	public ModelAndView createProductView() {
		System.out.println("reached the controller test");
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("purchase-creation");
	    mav.addObject("purchase", new Purchase());
	    mav.addObject("allProducts", getAllProducts());
	    return mav;
    }
	
	@PostMapping("create-purchase")
	public ModelAndView createProduct(@Valid Purchase purchase, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
        	logger.info("Validation errors while submitting form.");
        	mav.setViewName("purchase-creation");
        	 mav.addObject("purchase", new Purchase());
     	    mav.addObject("allProducts", getAllProducts());
     	    mav.addObject("allpurchase", eneteredPurchase(purchase));
    	    return mav;
        }
        mav.setViewName("purchase-creation");
   	 	mav.addObject("purchase", new Purchase());
	    mav.addObject("allProducts", getAllProducts());
	    mav.addObject("allpurchase", eneteredPurchase(purchase));
       /* Purchase p = purchaseService.addPurchase(purchase);
        if(p !=null){
        	mav.addObject("allPurchase", purchaseService.getAllPurchase());
	    	mav.setViewName("purchase-view");
	    	logger.info("Form submitted successfully.");	    
        }*/
        return mav;
    }	
	
	
	private List<Product> getAllProducts(){
		return productService.getAllProduct();
		
	}
	
	private List<Purchase> eneteredPurchase(Purchase purchase){
		System.out.println(" comming  ::" + purchase.getPurchaseBillNo());
		List<Purchase> enetered = new ArrayList<Purchase>();
		enetered.add(purchase);
		return enetered;
		
	}

}
