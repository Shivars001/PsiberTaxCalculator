package za.co.shivars.labournet.PsiberTaxCalculator.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import za.co.shivars.labournet.PsiberTaxCalculator.data.TaxDataDao;
import za.co.shivars.labournet.PsiberTaxCalculator.model.TaxData;

@Controller
@RequestMapping(value = "/")
public class TaxDataController {
	
	@Autowired
	private TaxDataDao taxDataDao;
	
	// Create new Record
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView uploadTaxData(ModelAndView model, HttpServletRequest request) {
		TaxData taxData = new TaxData();
		
		model.addObject("taxData", taxData);
		model.setViewName("index");
		return model;
	}
	
	// Save or Update
	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public ModelAndView updateTaxData(@Valid @ModelAttribute TaxData taxData,
			BindingResult result)
			throws ServletException, IOException, UnexpectedRollbackException {
		
		ModelAndView model = new ModelAndView();
		
		if (!result.hasErrors()) {
			taxDataDao.calculateYearlyTaxSalary(taxData);
			
		}
		
		// return new ModelAndView("redirect:/calculatedTaxResponse");
		model.addObject("calculatedTaxResponse",
				taxDataDao.calculateYearlyTaxSalary(taxData));
		model.setViewName("index");
		
		return model;
		
	}
	
}
