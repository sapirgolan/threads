package com.sap.sapir.base;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FibBaseTest {

    private FibBase classUnderTest;

    static final Logger logger = Logger.getLogger(FibBaseTest.class);
    private long startTime;

    @Before
    public void setUp() throws Exception {
        classUnderTest = new FibBase();
        startTime = System.nanoTime();
    }

    private void calcTime(String fibNumber) {
        long endTime = System.nanoTime();
        logger.info("Fibonacci of '" + fibNumber + "' took " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " Millis");
    }

    @Test
    public void testFib_2() throws Exception {
        BigInteger fib = classUnderTest.fib(2);
        calcTime("2");
        assertThat(fib, is(new BigInteger("1")));
    }

    @Test
    public void testFib_4() throws Exception {
        BigInteger fib = classUnderTest.fib(4);
        calcTime("4");
        assertThat(fib, is(new BigInteger("3")));
    }

    @Test
    public void testFib_10() throws Exception {
        BigInteger fib = classUnderTest.fib(10);
        calcTime("10");
        assertThat(fib, is(new BigInteger("55")));
    }

    @Test
    public void testFib_30() throws Exception {
        BigInteger fib = classUnderTest.fib(30);
        calcTime("30");
        assertThat(fib, is(new BigInteger("832040")));
    }

    @Test
    public void testFib_39() throws Exception {
        BigInteger fib = classUnderTest.fib(39);
        calcTime("39");
        assertThat(fib, is(new BigInteger("63245986")));
    }

    @Test
    public void testFib_40() throws Exception {
        BigInteger fib = classUnderTest.fib(40);
        calcTime("40");
        assertThat(fib, is(new BigInteger("102334155")));
    }

    @Test
    public void testFib_41() throws Exception {
        BigInteger fib = classUnderTest.fib(41);
        calcTime("41");
        assertThat(fib, is(new BigInteger("165580141")));
    }

    @Test
    @Ignore
    public void testFib_50() throws Exception {
        BigInteger fib = classUnderTest.fib(50);
        calcTime("50");
        assertThat(fib, is(new BigInteger("12586269025")));
    }

    @Test
    @Ignore
    public void testFib_100() throws Exception {
        BigInteger fib = classUnderTest.fib(100);
        calcTime("100");
        assertThat(fib, is(new BigInteger("354224848179261915075")));
    }

}