package me.geso.yoki.expects;

import static me.geso.yoki.Yoki.expect;
import static me.geso.yoki.Yoki.expectBlock;
import static org.junit.Assert.*;

import org.junit.ComparisonFailure;
import org.junit.Test;

import lombok.Value;

public class ExpectTest {

	@Test
	public void testToBeNull() throws Exception {
		expect((String)null).toBeNull();

		expectBlock(() -> expect("hoge").toBeNull())
			.toThrow()
			.hasMessage("expected null, but was <hoge>");
	}

	@Test
	public void testNotToBeNull() throws Exception {
		expect("hoge").notToBeNull();

		expectBlock(() -> expect((String)null).notToBeNull())
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

		// OK(Member)
		expect(new Member("John")).toBe(new Member("John"));
		// FAIL(member)
		expectBlock(() -> expect(new Member("John")).toBe(new Member("Nick"))).toThrow()
			.isInstanceOf(AssertionError.class)
			.hasMessage("expected:<ExpectTest.Member(name=Nick)> but was:<ExpectTest.Member(name=John)>");
	}

	@Value
	public static class Member {
		private String name;
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

	@Test
	public void testIsInstanceOf() throws Exception {
		// OK
		expect("hige").isInstanceOf(String.class);

		// FAIL
		{
			boolean thrown = false;
			try {
				expect("hige").isInstanceOf(Integer.class);
			} catch (AssertionError e) {
				assertEquals(e.getMessage(), "expectBlock <class java.lang.Integer>, but <class java.lang.String>");
				thrown = true;
			}
			assertTrue(thrown);
		}
	}
}
