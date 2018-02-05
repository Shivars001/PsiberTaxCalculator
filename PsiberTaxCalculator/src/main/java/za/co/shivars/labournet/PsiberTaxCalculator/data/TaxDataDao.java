/**
 * 
 */
package za.co.shivars.labournet.PsiberTaxCalculator.data;

/**
 * @author hlayisanishivambe
 *
 */
public interface TaxDataDao {
	
	public double calculateYearlyTaxSalary(String yearEnd, String age, String grossIncome,
			String medMembers, String earnPeriod);
	

	
}
