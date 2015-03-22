package me.geso.yoki.expects;

import static me.geso.yoki.Yoki.expect;
import static me.geso.yoki.Yoki.expectBlock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BooleanExpectTest {

	@Test
	public void testToBeTrue() throws Exception {
		expect(true).toBeTrue();
		expectBlock(() -> expect(false).toBeTrue())
				.toThrow()
				.hasMessage("expected true, but was <false>");
		expectBlock(() -> expect((Boolean)null).toBeTrue())
				.toThrow()
				.isInstanceOf(AssertionError.class)
				.hasMessage("expected true, but was <null>");
	}

	@Test
	public void testToBeFalse() throws Exception {
		expect(false)
				.toBeFalse();
		{
			boolean thrown = false;
			try {
				expect(true)
						.toBeFalse();
			} catch (AssertionError e) {
				assertEquals("expected false, but was <true>", e.getMessage());
				thrown = true;
			}
			assertTrue(thrown);
		}
		{
			boolean thrown = false;
			try {
				expect((Boolean)null)
						.toBeFalse();
			} catch (AssertionError e) {
				assertEquals("expected false, but was <null>", e.getMessage());
				thrown = true;
			}
			assertTrue(thrown);
		}
	}
}
