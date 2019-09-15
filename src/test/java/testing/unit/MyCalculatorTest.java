package testing.unit;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import testing.junit.MyCalculator;

class MyCalculatorTest {
	
	private MyCalculator myCalculator;
	
	@BeforeEach
	void setUp() {
		myCalculator = new MyCalculator();
	}

	public static int[][] data() {
        return new int[][] { 
        	{ 100, 25, 4 }, 
        	{ 25, 100, 0 }, 
        	{ 999, 999, 1 } 
        };
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    void testDivideBasic(int[] data) {
        int numerator = data[0];
        int denominator = data[1];
        int expected = data[2];
        assertEquals(expected, myCalculator.divide(numerator, denominator));
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
