package me.geso.yoki.expects;

import static me.geso.yoki.Yoki.expect;

import org.junit.Test;

public class IntegerExpectTest {
	@Test
	public void testToBe() {
		expect(3).toBe(3);
	}

}
