package me.geso.yoki.expects;

import static org.junit.Assert.*;

/**
 * Test case for callbacks.
 */
public class ExpectBlock {
	private final Throwable actual;

	ExpectBlock(final Throwable actual) {
		this.actual = actual;
	}

	/**
	 * Expect the exception has the message.
	 */
	public ExpectBlock hasMessage(String expectedMessage) {
		assertEquals("", expectedMessage, this.actual.getMessage());
		return this;
	}

	/**
	 * Expect the code throws an exception, the class should be expectedException.
	 * @param expectedExceptionClass expected exception class.
	 */
	public ExpectBlock isInstanceOf(Class<?> expectedExceptionClass) {
		if (!expectedExceptionClass.isInstance(this.actual)) {
			this.actual.printStackTrace();
			fail("expect <" + expectedExceptionClass + ">, but <" + this.actual.getClass() + ">");
		}
		return this;
	}

}
