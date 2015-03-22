package me.geso.yoki.expects;

import me.geso.yoki.ThrowableRunnable;

public class ThrowableRunnableExpect extends Expect<ThrowableRunnable> {
	public ThrowableRunnableExpect(final ThrowableRunnable callback) {
		super(callback);
	}

	public ThrowableExpect toThrow() {
		try {
			getActual().run();
		} catch (Throwable throwable) {
			return new ThrowableExpect(throwable);
		}
		throw new AssertionError("expected exception, but not thrown.");
	}
}
