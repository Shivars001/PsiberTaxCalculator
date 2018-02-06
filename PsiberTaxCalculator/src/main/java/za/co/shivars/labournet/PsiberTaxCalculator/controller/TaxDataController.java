package za.co.shivars.labournet.PsiberTaxCalculator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import za.co.shivars.labournet.PsiberTaxCalculator.data.TaxDataDao;
import za.co.shivars.labournet.PsiberTaxCalculator.model.TaxData;

public class TaxDataController {
	
	@Autowired
	private TaxDataDao taxDataDao;
	
	// Create new Record
	@RequestMapping(value = "/calculateTax", method = RequestMethod.GET)
	public ModelAndView uploadTaxData(ModelAndView model, HttpServletRequest request) {
		TaxData taxData = new TaxData();
		
		model.addObject("taxData", taxData);
		model.setViewName("index");
		return model;
	}
	
}
