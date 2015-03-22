package me.geso.yoki;

import me.geso.yoki.expects.BooleanExpect;
import me.geso.yoki.expects.ComparableExpect;
import me.geso.yoki.expects.Expect;
import me.geso.yoki.expects.StringExpect;
import me.geso.yoki.expects.ThrowableExpect;
import me.geso.yoki.expects.ThrowableRunnableExpect;

public class Yoki {
	public static ThrowableRunnableExpect expectBlock(final ThrowableRunnable value) {
		return new ThrowableRunnableExpect(value);
	}

	public static StringExpect expect(final String value) {
		return new StringExpect(value);
	}

	public static BooleanExpect expect(final Boolean value) {
		return new BooleanExpect(value);
	}

	public static ThrowableExpect expect(final Throwable value) {
		return new ThrowableExpect(value);
	}

	public static <T extends Comparable<T>> ComparableExpect<T> expect(final T value) {
		return new ComparableExpect<>(value);
	}

	public static <T> Expect<T> expect(final T value) {
		return new Expect<>(value);
	}

	public static void scenario(final String message, final ThrowableRunnable code) throws Exception {
		System.out.println("==> " + message + " <==");
		code.run();
	}
}
