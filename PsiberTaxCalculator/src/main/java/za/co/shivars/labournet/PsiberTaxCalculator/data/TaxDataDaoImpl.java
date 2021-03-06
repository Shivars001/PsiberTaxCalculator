/**
 * 
 */
package za.co.shivars.labournet.PsiberTaxCalculator.data;

import org.springframework.stereotype.Service;

import za.co.shivars.labournet.PsiberTaxCalculator.model.TaxData;
import za.co.shivars.labournet.PsiberTaxCalculator.util.Constant;

/**
 * @author hlayisanishivambe
 *
 */

@Service
public class TaxDataDaoImpl implements TaxDataDao {
	
	int		yearlyGross;
	double	tax;
	int		ageLevel;
	
	double	MonthlyTax;
	double	netSalary;
	double	MonthlyGross;
	
	int		rebate;
	
	public TaxDataResponse calculateYearlyTaxSalary(TaxData taxData) {
		
		if (taxData.getYearEnd().equalsIgnoreCase("2017")) {
			
			if (taxData.getEarnPeriod().equalsIgnoreCase("MONTHLY")) {
				
				yearlyGross = Integer.parseInt(taxData.getGrossIncome()) * 12;
				
				System.out.println("Your Tax Gross" + yearlyGross);
				return calculateTaxRate2017(yearlyGross, taxData.getAge());
				
			}
			else {
				
				yearlyGross = Integer.parseInt(taxData.getGrossIncome());
				
				System.out.println("Your Tax is  gross" + yearlyGross + taxData.getAge());
				return calculateTaxRate2017(yearlyGross, taxData.getAge());
			}
			
		}
		else if (taxData.getYearEnd().equals("2018")) {
			if (taxData.getEarnPeriod().equalsIgnoreCase("MONTHLY")) {
				yearlyGross = Integer.parseInt(taxData.getGrossIncome()) * 12;
				
				return calculateTaxRate2018(yearlyGross, taxData.getAge());
				
			}
			else {
				yearlyGross = Integer.parseInt(taxData.getGrossIncome());
				
				return calculateTaxRate2018(yearlyGross, taxData.getAge());
			}
		}
		else {
			return null;
		}
	}
	
	private TaxDataResponse calculateTaxRate2017(Integer totalIncome, String ageLevel) {
		
		TaxDataResponse tdata = new TaxDataResponse();
		int primary = 13500;
		int secondary = 7407;
		int tertiary = 2466;
		
		if (totalIncome <= 188000) {
			tax = totalIncome * Constant.INCOME_TAX_RATE_2017;
			
		}
		else if (totalIncome >= 188001 && totalIncome <= 293600) {
			tax = (totalIncome - 188000) * Constant.INCOME_TAX_RATE_1_2017 + 33840;
			
		}
		else if (totalIncome >= 293601 && totalIncome <= 406400) {
			tax = (totalIncome - 293600) * Constant.INCOME_TAX_RATE_2_2017 + 61296;
			
		}
		else if (totalIncome >= 406401 && totalIncome <= 550100) {
			tax = (totalIncome - 406400) * Constant.INCOME_TAX_RATE_3_2017 + 96264;
			
		}
		else if (totalIncome >= 550101 && totalIncome <= 701300) {
			tax = (totalIncome - 550100) * Constant.INCOME_TAX_RATE_4_2017 + 147996;
			
		}
		else if (totalIncome >= 701301) {
			tax = (totalIncome - 701300) * Constant.INCOME_TAX_RATE_5_2017 + 206964;
			
		}
		
		tdata.setTax(Math.round(tax));
		
		//
		
		if (Integer.parseInt(ageLevel) < 65) {
			tax -= primary;
			
		}
		
		if (Integer.parseInt(ageLevel) >= 65) {
			rebate = primary + secondary;
			
			tax -= rebate;
			MonthlyTax = tax / 12;
			
		}
		if (Integer.parseInt(ageLevel) >= 75) {
			tax -= primary + tertiary;
			
		}
		
		// Tax Threshold
		
		if (Integer.parseInt(ageLevel) < 65 && yearlyGross < 75000) {
			tax = 0.0;
		}
		else if (Integer.parseInt(ageLevel) >= 65 && Integer.parseInt(ageLevel) < 75
				&& yearlyGross < 116150) {
			tax = 0.0;
		}
		else if (Integer.parseInt(ageLevel) >= 75 && yearlyGross < 129850) {
			tax = 0.0;
		}
		
		MonthlyGross = totalIncome / 12;
		netSalary = MonthlyGross - MonthlyTax;
		
		tdata.setMonthlyGross(MonthlyGross);
		tdata.setMonthlyTax(MonthlyTax);
		tdata.setNetSalary(netSalary);
		tdata.setYearlyGross(yearlyGross);
		
		return tdata;
		
	}
	
	private TaxDataResponse calculateTaxRate2018(Integer totalIncome, String ageLevel) {
		
		TaxDataResponse tdata = new TaxDataResponse();
		int primary = 13635;
		int secondary = 7479;
		int tertiary = 2493;
		
		if (totalIncome <= 189880) {
			tax = totalIncome * Constant.INCOME_TAX_RATE_2018;
		}
		else if (totalIncome >= 189881 && totalIncome <= 296540) {
			tax = (totalIncome - 189880) * Constant.INCOME_TAX_RATE_1_2018 + 34178;
		}
		else if (totalIncome >= 296541 && totalIncome <= 410460) {
			tax = (totalIncome - 296540) * Constant.INCOME_TAX_RATE_2_2018 + 61910;
		}
		else if (totalIncome >= 410461 && totalIncome <= 555600) {
			tax = (totalIncome - 410460) * Constant.INCOME_TAX_RATE_3_2018 + 97225;
		}
		else if (totalIncome >= 555601 && totalIncome <= 708310) {
			tax = (totalIncome - 555600) * Constant.INCOME_TAX_RATE_4_2018 + 149475;
		}
		else if (totalIncome >= 708311 && totalIncome <= 1500000) {
			tax = (totalIncome - 708310) * Constant.INCOME_TAX_RATE_5_2018 + 209032;
		}
		else if (totalIncome >= 1500001) {
			tax = (totalIncome - 701300) * Constant.INCOME_TAX_RATE_6_2018 + 533634;
		}
		
		// Tax Rebate
		if (Integer.parseInt(ageLevel) < 65) {
			tax -= primary;
			
		}
		
		if (Integer.parseInt(ageLevel) >= 65) {
			rebate = primary + secondary;
			
			tax -= rebate;
			MonthlyTax = tax / 12;
			
		}
		if (Integer.parseInt(ageLevel) >= 75) {
			tax -= primary + tertiary;
			
		}
		
		// Tax Threshold
		
		if (Integer.parseInt(ageLevel) < 65 && yearlyGross < 75000) {
			tax = 0.0;
		}
		else if (Integer.parseInt(ageLevel) >= 65 && Integer.parseInt(ageLevel) < 75
				&& yearlyGross < 117300) {
			tax = 0.0;
		}
		else if (Integer.parseInt(ageLevel) >= 75 && yearlyGross < 131150) {
			tax = 0.0;
		}
		
		MonthlyGross = totalIncome / 12;
		netSalary = MonthlyGross - MonthlyTax;
		
		tdata.setTax(tax);
		tdata.setMonthlyGross(MonthlyGross);
		tdata.setMonthlyTax(MonthlyTax);
		tdata.setNetSalary(netSalary);
		tdata.setYearlyGross(yearlyGross);
		
		return tdata;
		
	}
	
}
