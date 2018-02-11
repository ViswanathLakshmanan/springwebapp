package com.retail.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.retail.app.domain.Metal;
import com.retail.app.domain.Product;
import com.retail.app.service.MetalService;
import com.retail.app.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	private final ProductService productService;
	private final MetalService metalService;

	@Autowired
	public ProductController(ProductService productService,MetalService metalService) {
		this.productService = productService;
		this.metalService = metalService;
	}
	
	@GetMapping("/")
	public String showPage(Model model,@RequestParam(defaultValue="0") int page){
		model.addAttribute("allProduct", productService.findAll(page,10));
		model.addAttribute("currentPage", page);
		return "product-view";
		
	}
	
	@GetMapping("/create-product")
	public ModelAndView createProductView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("product-creation");
	    mav.addObject("product", new Product());
	    mav.addObject("allMetals", getAllMetals());
	    return mav;
    }
	
	@PostMapping("/create-product")
	public ModelAndView createProduct(@Valid Product product, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
        	logger.info("Validation errors while submitting form.");
        	mav.setViewName("product-creation");
    	    mav.addObject("product", product);
    	    mav.addObject("allMetals", getAllMetals());
    	    return mav;
        }
        Product p = productService.addProduct(product);
        if(p !=null){
        	/*mav.addObject("allProduct", productService.findAll(0,10));
	    	mav.setViewName("product-view");*/
        	logger.info("Form submitted successfully.");
        	return new ModelAndView("redirect:/product/");
	    	
	    		    
        }
        return mav;
    }	
	
	
	
	@GetMapping("/edit-product")
	public ModelAndView editProduct(@RequestParam(value="id", required=true) Long id) {
	    ModelAndView mav = new ModelAndView();
	    Product product = productService.getById(id);
	    mav.setViewName("edit-product");
	    mav.addObject("allMetals", getAllMetals());
	    mav.addObject("product", product);
	    return mav;
        
    }	
	
	@PostMapping("/edit-product")
	public ModelAndView updateProduct(@Valid Product product, BindingResult result) {
		System.out.println("Reach Controller");
	    ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
        	logger.info("Validation errors while submitting form.");
        	mav.setViewName("edit-product");
        	mav.addObject("allMetals", getAllMetals());
    	    mav.addObject("product", product);
    	    return mav;
        }
        Product p = productService.updateProduct(product);
        if(p !=null){
        	/*mav.addObject("allProduct", productService.findAll(0,10));
	    	mav.setViewName("product-view");*/
        	logger.info("Form submitted successfully.");
        	return new ModelAndView("redirect:/product/");
	    		    
        }
        return mav;
    }	
	
	private List<Metal> getAllMetals()
	{
		List<Metal> metals = metalService.getAllMetal();
		return metals;
	}
	
	@DeleteMapping("/delete")
	public String deleteProduct(Long id){
		Boolean status = productService.deleteProduct(id);
		if(status == true)
			return "redirect:/product/";
		return null;
	}
	


}
