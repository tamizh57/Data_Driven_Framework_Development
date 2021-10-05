import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Test_Prime {

	 private Integer inputNumber;
	 private Boolean expectedResult;
	 private Prime_Number primeNumberChecker;
	 
	 @Before
	 public void initialize()
	 {
		 primeNumberChecker=new Prime_Number();
	 }
	 
	 public Test_Prime(int num, boolean result) 
	 {
		 inputNumber = num;
		 expectedResult = result;
	 }
	 @Parameters
	 public static Collection<Object[]> samples()
	 {
		 return Arrays.asList(new Object[][] {
	         { 2, true },
	         { 6, false },
	         { 19, true },
	         { 22, false },
	         { 23, true }
	      });
	 }
	 
	 @Test
	   public void testPrimeNumberChecker() {
	      System.out.println("Parameterized Number is : " + inputNumber);
	      assertEquals(expectedResult, 
	      primeNumberChecker.prime_check(inputNumber));
	   }

}
