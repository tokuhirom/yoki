package me.geso.yoki.expects;

import static me.geso.yoki.Yoki.expect;
import static me.geso.yoki.Yoki.expectBlock;
import static me.geso.yoki.Yoki.scenario;

import org.junit.ComparisonFailure;
import org.junit.Test;

public class ThrowableExpectTest {

	@Test
	public void testHasMessage() throws Exception {
		scenario("success", () -> expect(new Exception("Heh"))
				.hasMessage("Heh"));

		scenario("fail", () -> expectBlock(() -> expect(new Exception("Heh"))
				.hasMessage("Yay")).toThrow()
				.isInstanceOf(ComparisonFailure.class)
				.hasMessage("expected:<[Yay]> but was:<[Heh]>"));
	}

}
