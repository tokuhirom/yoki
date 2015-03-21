package me.geso.yoki;

import static me.geso.yoki.Yoki.expect;
import static org.junit.Assert.*;

import org.junit.ComparisonFailure;
import org.junit.Test;

public class ExpectTest {

	@Test
	public void testToBeNull() throws Exception {
		expect((String)null).toBeNull();

		expect(() -> {
			expect("hoge").toBeNull();
		})
			.toThrow()
			.hasMessage("expected null, but was <hoge>");
	}

	@Test
	public void testNotToBeNull() throws Exception {
		expect("hoge").notToBeNull();

		expect(() -> {
			expect((String)null).notToBeNull();
		})
				.toThrow()
				.hasMessage("expected not null, but was <null>");
	}

	@Test
	public void testToBe() throws Exception {
		// OK
		expect("hoge").toBe("hoge");

		// FAIL
		{
			boolean thrown = false;
			try {
				expect("hoge").toBe("huge");
			} catch (ComparisonFailure e) {
				assertEquals(e.getActual(), "hoge");
				assertEquals(e.getExpected(), "huge");
				thrown = true;
			}
			assertTrue(thrown);
		}

		// FAIL(int)
		{
			boolean thrown = false;
			try {
				expect(1).toBe(3);
			} catch (AssertionError e) {
				assertEquals("expected:<3> but was:<1>", e.getMessage());
				thrown = true;
			}
			assertTrue(thrown);
		}
	}

	@Test
	public void testNotToBe() throws Exception {
		// OK
		expect("hige").notToBe("hoge");

		// FAIL
		{
			boolean thrown = false;
			try {
				expect("hoge").notToBe("hoge");
			} catch (AssertionError e) {
				assertEquals(e.getMessage(), "Values should be different. Actual: hoge");
				thrown = true;
			}
			assertTrue(thrown);
		}

		// FAIL(int)
		{
			boolean thrown = false;
			try {
				expect(1).notToBe(1);
			} catch (AssertionError e) {
				assertEquals("Values should be different. Actual: 1", e.getMessage());
				thrown = true;
			}
			assertTrue("Exception needed", thrown);
		}
	}
}
