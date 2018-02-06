package za.co.shivars.labournet.PsiberTaxCalculator.model;

import java.io.Serializable;

public class TaxData implements Serializable {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -6290179260885101472L;
	
	String						yearEnd, age, grossIncome, medMembers, earnPeriod;
	
	public String getYearEnd() {
		return yearEnd;
	}
	
	public void setYearEnd(String yearEnd) {
		this.yearEnd = yearEnd;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getGrossIncome() {
		return grossIncome;
	}
	
	public void setGrossIncome(String grossIncome) {
		this.grossIncome = grossIncome;
	}
	
	public String getMedMembers() {
		return medMembers;
	}
	
	public void setMedMembers(String medMembers) {
		this.medMembers = medMembers;
	}
	
	public String getEarnPeriod() {
		return earnPeriod;
	}
	
	public void setEarnPeriod(String earnPeriod) {
		this.earnPeriod = earnPeriod;
	}
	
}
