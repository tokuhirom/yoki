package me.geso.yoki.expects;

import static org.junit.Assert.*;

public class Expect<T> {
	protected T getActual() {
		return actual;
	}

	private final T actual;

	public Expect(T actual) {
		this.actual = actual;
	}

	public void toBeNull() {
		if (actual != null) {
			fail("expected null, but was <" + actual + ">");
		}
	}

	public void toBe(final T expected) {
		assertEquals(null, expected, actual);
	}

	public void notToBeNull() {
		assertNotNull("expected not null, but was <" + actual + ">", actual);
	}

	public void notToBe(final T expected) {
		assertNotEquals(null, expected, actual);
	}
}

