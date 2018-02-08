/**
 * 
 */
package za.co.shivars.labournet.PsiberTaxCalculator.data;

import java.io.Serializable;

/**
 * @author hlayisanishivambe
 *
 */
public class TaxDataResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 2518720440749594329L;
	int							yearlyGross;
	double						tax;
	int							ageLevel;
	
	double						monthlyTax;
	double						netSalary;
	double						monthlyGross;
	
	public int getYearlyGross() {
		return yearlyGross;
	}
	
	public void setYearlyGross(int yearlyGross) {
		this.yearlyGross = yearlyGross;
	}
	
	public double getTax() {
		return tax;
	}
	
	public void setTax(double tax) {
		this.tax = tax;
	}
	
	public int getAgeLevel() {
		return ageLevel;
	}
	
	public void setAgeLevel(int ageLevel) {
		this.ageLevel = ageLevel;
	}
	
	public double getMonthlyTax() {
		return monthlyTax;
	}
	
	public void setMonthlyTax(double monthlyTax) {
		this.monthlyTax = monthlyTax;
	}
	
	public double getNetSalary() {
		return netSalary;
	}
	
	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}
	
	public double getMonthlyGross() {
		return monthlyGross;
	}
	
	public void setMonthlyGross(double monthlyGross) {
		this.monthlyGross = monthlyGross;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
