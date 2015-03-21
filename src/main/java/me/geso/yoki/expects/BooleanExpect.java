package me.geso.yoki.expects;

import static org.junit.Assert.fail;

public class BooleanExpect extends Expect<Boolean> {

	public BooleanExpect(final Boolean actual) {
		super(actual);
	}

	public void toBeTrue() {
		if (getActual() == null || !getActual()) {
			fail("expected true, but was <" + getActual() + ">");
		}
	}

	public void toBeFalse() {
		if (getActual() == null || getActual()) {
			fail("expected false, but was <" + getActual() + ">");
		}
	}
}
