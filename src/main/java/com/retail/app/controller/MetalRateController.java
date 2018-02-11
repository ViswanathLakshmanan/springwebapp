package com.retail.app.controller;

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

import com.retail.app.domain.MetalRate;
import com.retail.app.service.MetalRateService;

@Controller
@RequestMapping("/")
public class MetalRateController {
	private static final Logger logger = LoggerFactory.getLogger(MetalRateController.class);
	
	@Autowired
	private MetalRateService metalRateService;
	
	@GetMapping("/")
	public String showPage(Model model,@RequestParam(defaultValue="0") int page){
		model.addAttribute("allMetalRate", metalRateService.findAll(page,10));
		model.addAttribute("currentPage", page);
		return "metalrate-view";
		
	}
	
	@GetMapping("create-metalrate")
	public ModelAndView createMetalRateView() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("metalrate-creation");
	    mav.addObject("metalRate", new MetalRate());
	    return mav;
    }
	
	@PostMapping("create-metalrate")
	public ModelAndView createMetalRate(@Valid MetalRate metalRate, BindingResult result) {
	    ModelAndView mav = new ModelAndView();
	    System.out.println("testing::: "+metalRate.getRate());
        if(result.hasErrors()) {
        	logger.info("Validation errors while submitting form.");
        	mav.setViewName("metalrate-creation");
    	    mav.addObject("metalRate", metalRate);
    	    return mav;
        }		
		metalRateService.addMetalRate(metalRate);
	    mav.addObject("allMetalRate", metalRateService.findAll(0,10));
	    mav.setViewName("metalrate-view");
    	logger.info("Form submitted successfully.");	    
	    return mav;
    }	

}
