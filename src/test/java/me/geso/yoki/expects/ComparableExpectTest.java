package me.geso.yoki.expects;

import static me.geso.yoki.Yoki.expect;

import java.math.BigDecimal;

import org.junit.Test;

public class ComparableExpectTest {

	@Test
	public void testToBeGreaterThan() throws Exception {
		// OK
		expect(BigDecimal.ONE).toBeGreaterThan(BigDecimal.ZERO);

		// FAIL
		expect(() -> {
			expect(BigDecimal.ONE).toBeGreaterThan(BigDecimal.TEN);
		}).toThrow().hasMessage("\n"
				+ "Expected: a value greater than <10>\n"
				+ "     but: <1> was less than <10>");
	}

	@Test
	public void testToBeLessThan() throws Exception {
		// OK
		expect(BigDecimal.ZERO).toBeLessThan(BigDecimal.ONE);

		// FAIL
		expect(() -> {
			expect(BigDecimal.TEN).toBeLessThan(BigDecimal.ZERO);
		}).toThrow().hasMessage("\n"
				+ "Expected: a value less than <0>\n"
				+ "     but: <10> was greater than <0>");
	}
}
