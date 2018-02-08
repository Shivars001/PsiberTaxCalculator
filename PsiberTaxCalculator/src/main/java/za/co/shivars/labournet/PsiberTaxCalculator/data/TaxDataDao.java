/**
 * 
 */
package za.co.shivars.labournet.PsiberTaxCalculator.data;

import za.co.shivars.labournet.PsiberTaxCalculator.model.TaxData;

/**
 * @author hlayisanishivambe
 *
 */
public interface TaxDataDao {
	
	public TaxDataResponse calculateYearlyTaxSalary(TaxData taxData);

	

	
}
