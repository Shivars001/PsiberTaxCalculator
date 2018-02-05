
package za.co.shivars.labournet.PsiberTaxCalculator.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import za.co.shivars.labournet.PsiberTaxCalculator.data.TaxDataDao;

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
	public void saveTaxData() {
		
		
		taxDataDao.calculateYearlyTaxSalary("2016/2017", "75", "30000", "0", "MONTHLY");
		
		taxDataDao.calculateYearlyTaxSalary("2016/2017", "75", "360000", "0", "YEARLY");
		
		
		taxDataDao.calculateYearlyTaxSalary("2017/2018", "65", "360000", "0", "YEARLY");
		
		taxDataDao.calculateYearlyTaxSalary("2017/2018", "75", "30000", "0", "MONTHLY");
		
		
	}
	
}
