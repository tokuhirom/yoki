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

	/**
	 * Expect the <I>actual value</I> is instance of <I>expectedClass</I>.
	 * @param expectedClass expected exception class.
	 */
	public Expect<T> isInstanceOf(Class<?> expectedClass) {
		if (!expectedClass.isInstance(this.getActual())) {
			fail("expect <" + expectedClass + ">, but <" + this.getActual().getClass() + ">");
		}
		return this;
	}
}
