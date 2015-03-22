package me.geso.yoki.expects;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;

public class ComparableExpect<T extends Comparable<T>> extends Expect<T> {
	public ComparableExpect(final T actual) {
		super(actual);
	}

	public void toBeGreaterThan(final T expected) {
		assertThat(getActual(), Matchers.greaterThan(expected));
	}

	public void toBeLessThan(final T expected) {
		assertThat(getActual(), Matchers.lessThan(expected));
	}

}
