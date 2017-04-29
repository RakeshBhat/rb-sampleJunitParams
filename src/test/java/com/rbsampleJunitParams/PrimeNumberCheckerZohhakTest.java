package com.rbsampleJunitParams;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.runner.RunWith;

import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;

@RunWith(ZohhakRunner.class)
public class PrimeNumberCheckerZohhakTest {

	PrimeNumberChecker primeNumberChecker = null;
	
	@Before
	public void setUp(){
		primeNumberChecker = new PrimeNumberChecker();
	}
	
	@TestWith({ "2, true",
	          "6, false",
	          "19, true",
	          "22, false",
	          "23, true"})
	public void testValidate(int primeNumber, boolean matcher) {
		boolean isPrime = primeNumberChecker.validate(primeNumber);
		
		assertThat(isPrime, is(matcher));
	}
	
	@TestWith(value="7 | 19, 23", separator="[\\|,]")
	public void mixedSeparators(int i, int j, int k) {
	    assertThat(i).isEqualTo(7);
	    assertThat(j).isEqualTo(19);
	    assertThat(k).isEqualTo(23);
	}
	
	@TestWith(value=" 7 = 7 > 5 => true", separator="=>")
	public void multiCharSeparator(String string, boolean bool) {
	    assertThat(string).isEqualTo("7 = 7 > 5");
	    assertThat(bool).isTrue();
	}

}
