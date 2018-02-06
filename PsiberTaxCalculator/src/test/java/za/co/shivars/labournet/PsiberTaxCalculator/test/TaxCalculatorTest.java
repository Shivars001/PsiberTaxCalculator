
package za.co.shivars.labournet.PsiberTaxCalculator.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import za.co.shivars.labournet.PsiberTaxCalculator.data.TaxDataDao;
import za.co.shivars.labournet.PsiberTaxCalculator.model.TaxData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:test-context.xml", "classpath:/META-INF/spring/applicationContext.xml"
})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class TaxCalculatorTest {
	
	@Autowired
	TaxDataDao taxDataDao;
	
	@Test
	public void saveTaxMonthlyData() {
		
		TaxData data = new TaxData();
		data.setAge("75");
		data.setEarnPeriod("MONTHLY");
		data.setGrossIncome("30000");
		data.setMedMembers("0");
		data.setYearEnd("2016/2017");
		
		taxDataDao.calculateYearlyTaxSalary(data);
	
		
	}
	
	@Test
	public void saveTaxYearlyData() {
		
		TaxData data = new TaxData();
		data.setAge("65");
		data.setEarnPeriod("YEARLY");
		data.setGrossIncome("360000");
		data.setMedMembers("0");
		data.setYearEnd("2017/2018");
		
		taxDataDao.calculateYearlyTaxSalary(data);
	
		
	}
}
