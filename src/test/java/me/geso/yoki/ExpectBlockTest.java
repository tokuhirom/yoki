package me.geso.yoki;

import static me.geso.yoki.Yoki.expectBlock;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.ComparisonFailure;
import org.junit.Test;

public class ExpectBlockTest {

	@Test
	public void testToThrow() throws Exception {
		// OK
		expectBlock(() -> {
			throw new Exception("tagomoris");
		}).toThrow();

		// FAIL
		{
			boolean thrown = false;
			try {
				expectBlock(() -> {
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
		expectBlock(() -> {
			throw new Exception("tagomoris");
		}).toThrow()
			.hasMessage("tagomoris");

		// FAIL
		{
			boolean thrown = false;
			try {
				expectBlock(() -> {
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
		expectBlock(() -> {
			throw new IllegalAccessError();
		}).toThrow()
			.isInstanceOf(IllegalAccessError.class);

		// FAIL
		try {
			expectBlock(() -> {
				throw new IllegalAccessError();
			}).toThrow()
				.isInstanceOf(IllegalStateException.class);
		} catch (AssertionError e) {
			assertThat(e.getMessage(), is("expectBlock <class java.lang.IllegalStateException>, but <class java.lang.IllegalAccessError>"));
		}
	}
}
