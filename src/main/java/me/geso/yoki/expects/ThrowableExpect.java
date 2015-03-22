package me.geso.yoki.expects;

import static org.junit.Assert.*;

/**
 * Test case for callbacks.
 */
public class ThrowableExpect extends Expect<Throwable> {
	public ThrowableExpect(final Throwable actual) {
		super(actual);
	}

	/**
	 * Expect the exception has the message.
	 */
	public ThrowableExpect hasMessage(String expectedMessage) {
		assertEquals("", expectedMessage, this.getActual().getMessage());
		return this;
	}

	/**
	 * Expect the code throws an exception, the class should be expectedException.
	 * @param expectedExceptionClass expected exception class.
	 */
	public ThrowableExpect isInstanceOf(Class<?> expectedExceptionClass) {
		if (!expectedExceptionClass.isInstance(this.getActual())) {
			this.getActual().printStackTrace();
			fail("expect <" + expectedExceptionClass + ">, but <" + this.getActual().getClass() + ">");
		}
		return this;
	}

}
