# yoki - testing library for java

## SYNOPSIS

    @Test
    public void test() {
        expect("hoge")
                .startsWith("h");
        expect(() -> throws Exception())
            .toThrow()
            .isInstanceOf(Exception.class);
    }

## DESCRIPTION

Testing utility library for Java 8, based on junit.

## WHY?

yoki provides cool interface for testing.

## Methods

Every testing is starts with `me.geso.yoki.Yoki.expect` static method.

### Object

    expect(actual).toBe(expected);

Expect _actual_ to be _expected_.

    expect(actual).notToBe(expected);

Expect _actual_ not to be _expected_.

    expect(actual).toBeNull();

Expect _actual_ to be null.

    expect(actual).notToBeNull();

Expect _actual_ not to be null.

    expect(actual).isInstanceOf(expectedClass);

Expect _actual_ is instance of _expectedClass_.

### String

    expect(actual).toMatch(expected : String);

Expect _actual_ to match _expected_. _expected_ is regexp in String.

    expect(actual).startsWith(expected : String);

Expect _actual_ starts with _expected_.

### Boolean

    expect(actual).toBeTrue();

Expect _actual_ to be true.

    expect(actual).toBeFalse();

Expect _actual_ to be false.

### Throwable

    expect(actual).hasMessage(expected);

Expect _actual_ has message _expected_. This is equivalent to `expect(actual.getMessage()).toBe(expected)`.

    expect(actual).isInstanceOf(expected).

Expect _actual_ is instance of _expected_.

### ThrowableRunnable

ThrowableRunnable is interface defined in `me.gso.yoki.ThrowableRunnable`.

    package me.geso.yoki;
    public interface ThrowableRunnable {
        public void run() throws Exception;
    }

You can use this for testing code, that throws an exception.

    expect(code).toThrow();

Expect _code_ to throw an exception... And then, you can call the ThrowableExpect methods.

e.g.

    expect(code).toThrow().hasMessage("Hoge");

## SEE ALSO

 * [catch-exception](https://code.google.com/p/catch-exception/) is a DSL for
 * [assertj](http://joel-costigliola.github.io/assertj/) is similar project.
   * But, i guess assertThat is too

