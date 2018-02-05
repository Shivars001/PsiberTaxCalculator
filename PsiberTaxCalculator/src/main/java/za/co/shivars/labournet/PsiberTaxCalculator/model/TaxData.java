/**
 * 
 */
package za.co.shivars.labournet.PsiberTaxCalculator.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author hlayisanishivambe
 *
 */
public class TaxData implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -7065830896668822651L;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private BigDecimal netPay;
	private BigDecimal grossAmount;
	private BigDecimal tax;
	private String taxYear;
	
	public BigDecimal getNetPay() {
		return netPay;
	}

	public void setNetPay(BigDecimal netPay) {
		this.netPay = netPay;
	}

	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public String getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(String taxYear) {
		this.taxYear = taxYear;
	}


}
