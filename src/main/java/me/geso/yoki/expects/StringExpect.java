package me.geso.yoki.expects;

import static org.junit.Assert.fail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExpect extends ComparableExpect<String> {

	public StringExpect(final String actual) {
		super(actual);
	}

	public void toMatch(final String regexp) {
		final Pattern pattern = Pattern.compile(regexp);
		final Matcher matcher = pattern.matcher(getActual());
		if (!matcher.matches()) {
			fail(String.format("expected /%s/ matches <%s>", regexp, "" + getActual()));
		}
	}

	public void startsWith(final String prefix) {
		if (!getActual().startsWith(prefix)) {
			fail("expectBlock starts with <" + prefix + ">, but <" + getActual() + ">");
		}
	}

}
