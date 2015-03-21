package me.geso.yoki;

import static me.geso.yoki.Yoki.expect;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.ComparisonFailure;
import org.junit.Test;

public class ExpectBlockTest {

	@Test
	public void testToThrow() throws Exception {
		// OK
		expect(() -> {
			throw new Exception("tagomoris");
		}).toThrow();

		// FAIL
		{
			boolean thrown = false;
			try {
				expect(() -> {
				}).toThrow();
			} catch (AssertionError e) {
				thrown = true;
			}
			assertTrue(thrown);
		}
	}

	@Test
	public void testHasMessage() {
		// OK
		expect(() -> {
			throw new Exception("tagomoris");
		}).toThrow()
			.hasMessage("tagomoris");

		// FAIL
		{
			boolean thrown = false;
			try {
				expect(() -> {
					throw new Exception("kazeburo");
				}).toThrow()
					.hasMessage("tagomoris");
			} catch (ComparisonFailure e) {
				assertEquals("expected:<[tagomoris]> but was:<[kazeburo]>", e.getMessage());
				thrown = true;
			}
			assertTrue(thrown);
		}
	}

	@Test
	public void testIsInstanceOf() throws Exception {
		// OK
		expect(() -> {
			throw new IllegalAccessError();
		}).toThrow()
			.isInstanceOf(IllegalAccessError.class);

		// FAIL
		try {
			expect(() -> {
				throw new IllegalAccessError();
			}).toThrow()
				.isInstanceOf(IllegalStateException.class);
		} catch (AssertionError e) {
			assertThat(e.getMessage(), is("expect <class java.lang.IllegalStateException>, but <class java.lang.IllegalAccessError>"));
		}
	}
}
