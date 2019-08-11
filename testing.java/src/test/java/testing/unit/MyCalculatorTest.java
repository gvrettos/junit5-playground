package testing.unit;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

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

	@Test
	void testDivideByZero() {
		Throwable exception = assertThrows(ArithmeticException.class, () -> myCalculator.divide(999, 0));
	    assertEquals("/ by zero", exception.getMessage());
	}
	
	@Test
	void testDividePerformance() {
		assertTimeout(ofMillis(1), () -> {
			for (int i=4; i<10000 ;i++) {
				myCalculator.divide(i*3, i-3);
			}
		});
	}
}
