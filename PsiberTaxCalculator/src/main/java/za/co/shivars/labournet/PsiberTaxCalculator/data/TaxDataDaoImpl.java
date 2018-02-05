/**
 * 
 */
package za.co.shivars.labournet.PsiberTaxCalculator.data;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.shivars.labournet.PsiberTaxCalculator.util.Constant;

/**
 * @author hlayisanishivambe
 *
 */

@Repository
@Transactional
@Service
public class TaxDataDaoImpl implements TaxDataDao {
	
	int		yearlyGross;
	double	tax;
	int		ageLevel;
	
	double	MonthlyTax;
	double netSalary;
	double MonthlyGross;
	
	int		rebate;
	
	public double calculateYearlyTaxSalary(String yearEnd, String age, String grossIncome,
			String medMembers, String earnPeriod) {
		
		
		
		if (yearEnd.equalsIgnoreCase("2016/2017")) {
			System.out.println("Your Tax is year " + yearEnd);
			if (earnPeriod.equalsIgnoreCase("MONTHLY")) {
				System.out.println("Your Tax is  period" + earnPeriod);
				yearlyGross = Integer.parseInt(grossIncome) * 12;
				calculateTaxRate2017(yearlyGross, age);
				
			}
			else if (earnPeriod.equalsIgnoreCase("YEARLY")) {
				System.out.println("Your Tax is  yearly" + earnPeriod);
				yearlyGross = Integer.parseInt(grossIncome);
				System.out.println("Your Tax is  gross" + yearlyGross + age);
				calculateTaxRate2017(yearlyGross, age);
			}
			
		}
		
		if (yearEnd.equals("2017/2018")) {
			if (earnPeriod.equalsIgnoreCase("MONTHLY")) {
				yearlyGross = Integer.parseInt(grossIncome) * 12;
				
				calculateTaxRate2018(yearlyGross, age);
			}
			else if (earnPeriod.equalsIgnoreCase("YEARLY")) {
				yearlyGross = Integer.parseInt(grossIncome);
				
				calculateTaxRate2018(yearlyGross, age);
			}
		}
		
		return tax;
	}
	
	private int calculateTaxRate2017(Integer totalIncome, String ageLevel) {
		
		int		primary		= 13500;
		int		secondary	= 7407;
		int		tertiary	= 2466;
		
		if (totalIncome <= 188000) {
			tax = totalIncome * Constant.INCOME_TAX_RATE_2017;
			System.out.println("Your Tax is 18% " + tax);
		}
		else if (totalIncome >= 188001 && totalIncome <= 293600) {
			tax = (totalIncome - 188000) * Constant.INCOME_TAX_RATE_1_2017 + 33840;
			System.out.println("Your Tax is " + tax);
			
		}
		else if (totalIncome >= 293601 && totalIncome <= 406400) {
			tax = (totalIncome - 293600) * Constant.INCOME_TAX_RATE_2_2017 + 61296;
			System.out.println("Your Tax is 31 %" + tax);
		}
		else if (totalIncome >= 406401 && totalIncome <= 550100) {
			tax = (totalIncome - 406400) * Constant.INCOME_TAX_RATE_3_2017 + 96264;
			System.out.println("Your Tax is other" + tax);
		}
		else if (totalIncome >= 550101 && totalIncome <= 701300) {
			tax = (totalIncome - 550100) * Constant.INCOME_TAX_RATE_4_2017 + 147996;
			System.out.println("Your Tax is here" + tax);
		}
		else if (totalIncome >= 701301) {
			tax = (totalIncome - 701300) * Constant.INCOME_TAX_RATE_5_2017 + 206964;
			
			System.out.println("Your Tax is taxed" + tax);
		}
		
		//
		
		if (Integer.parseInt(ageLevel) < 65) {
			tax -= primary;
			System.out.println("Your Tax is  primary" + tax);
		}
		
		if (Integer.parseInt(ageLevel) >= 65) {
			rebate = primary + secondary;
			System.out.println(rebate + "rebate");
			tax = tax - rebate;
			MonthlyTax = tax / 12;
			
			System.out
					.println("Your Tax is  Secondary" + tax + "monthlyTax" + MonthlyTax);
		}
		if (Integer.parseInt(ageLevel) >= 75) {
			tax -= primary + tertiary;
			System.out.println("Your Tax is Tertiary" + tax);
		}
		
		MonthlyGross = totalIncome/12;
		netSalary = MonthlyGross - MonthlyTax;
		System.out.println("Your monthly is" + netSalary);
		// Tax Threshold
		if (Integer.parseInt(ageLevel) < 65 && yearlyGross < 75000) {
			return 0;
		}
		else if (Integer.parseInt(ageLevel) >= 65 && Integer.parseInt(ageLevel) < 75
				&& yearlyGross < 116150) {
			return 0;
		}
		else if (Integer.parseInt(ageLevel) >= 7 && yearlyGross < 129850) {
			return 0;
		}
		
		return 0;
		
	}
	
	private int calculateTaxRate2018(Integer totalIncome, String ageLevel) {
		
		int		primary		= 13635;
		int		secondary	= 7479;
		int		tertiary	= 2493;
		
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
		
		//
		if (Integer.parseInt(ageLevel) < 65) {
			tax -= primary;
			System.out.println("Your Tax is  primary" + tax);
		}
		
		if (Integer.parseInt(ageLevel) >= 65) {
			rebate = primary + secondary;
			System.out.println(rebate + "rebate");
			tax = tax - rebate;
			MonthlyTax = tax / 12;
			
			System.out
					.println("Your Tax is  Secondary" + tax + "monthlyTax" + MonthlyTax);
		}
		if (Integer.parseInt(ageLevel) >= 75) {
			tax -= primary + tertiary;
			System.out.println("Your Tax is Tertiary" + tax);
		}
		
		MonthlyGross = totalIncome/12;
		netSalary = MonthlyGross - MonthlyTax;
		System.out.println("Your monthly is" + netSalary);
		
		// Tax Threshold
		if (Integer.parseInt(ageLevel) < 65 && yearlyGross < 75000) {
			return 0;
		}
		else if (Integer.parseInt(ageLevel) >= 65 && Integer.parseInt(ageLevel) < 75 && yearlyGross < 117300) {
			return 0;
		}
		else if (Integer.parseInt(ageLevel) >= 7 && yearlyGross < 131150) {
			return 0;
		}
		
		return 0;
		
	}
	
}
