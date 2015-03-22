package me.geso.yoki.expects;

import static me.geso.yoki.Yoki.expect;
import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("SpellCheckingInspection")
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
			assertEquals("expectBlock starts with <f>, but <hoge>", e.getMessage());
		}
	}

	@Test
	public void testToBeGraterThan() throws Exception {
		// ok
		expect("hoge")
				.toBeGreaterThan("hage");

		// fail
		try {
			expect("hoge")
					.toBeGreaterThan("zzzz");
		} catch (AssertionError e) {
			assertEquals("\n"
					+ "Expected: a value greater than \"zzzz\"\n"
					+ "     but: \"hoge\" was less than \"zzzz\"", e.getMessage());
		}
	}

	@Test
	public void testToBeLessThan() throws Exception {
		// ok
		expect("hoge")
				.toBeLessThan("hzge");

		// fail
		try {
			expect("hoge")
					.toBeLessThan("aaaa");
		} catch (AssertionError e) {
			assertEquals("\n"
					+ "Expected: a value less than \"aaaa\"\n"
					+ "     but: \"hoge\" was greater than \"aaaa\"", e.getMessage());
		}
	}
}

