package me.geso.yoki.expects;

import static me.geso.yoki.Yoki.expect;
import static org.junit.Assert.*;

import org.junit.Test;

public class StringExpectTest {

	@Test
	public void testToMatch() throws Exception {
		expect("hoge")
				.toMatch("h.g.");
		{
			boolean thrown = false;
			try {
				expect("hoge")
						.toMatch("fuga");
			} catch (AssertionError e) {
				assertEquals("expected /fuga/ matches <hoge>", e.getMessage());
				thrown = true;
			}
			assertTrue(thrown);
		}
	}

	@Test
	public void testStartsWith() throws Exception {
		// ok
		expect("hoge")
				.startsWith("h");

		// fail
		try {
			expect("hoge")
					.startsWith("f");
		} catch (AssertionError e) {
			assertEquals("expect starts with <f>, but <hoge>", e.getMessage());
		}
	}
}

