package testing.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import testing.junit.MyCalculator;

class MyCalculatorTest {
	
	private MyCalculator myCalculator;
	
	@BeforeEach
	void setUp() {
		myCalculator = new MyCalculator();
	}

	@Test
	void testDivideDividendLargerThanDivisor() {
		assertEquals(4, myCalculator.divide(100, 25));
	}
	
	@Test
	void testDivideDivisorLargerThanDividend() {
		assertEquals(0, myCalculator.divide(25, 100));
	}
	
	@Test
	void testDivideDividendEqualToDivisor() {
		assertEquals(1, myCalculator.divide(999, 999));
	}

}
