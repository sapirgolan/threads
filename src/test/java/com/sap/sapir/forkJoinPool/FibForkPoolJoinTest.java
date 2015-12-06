package com.sap.sapir.forkJoinPool;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FibForkPoolJoinTest {

    static final Logger logger = Logger.getLogger(FibForkPoolJoinTest.class);
    int processors = Runtime.getRuntime().availableProcessors();


    private FibForkPoolJoin classUnderTest;
    private long startTime;
    private ForkJoinPool pool;

    @Before
    public void setUp() throws Exception {
        startTime = System.nanoTime();
        pool = new ForkJoinPool(processors);

    }

    private void calcTime(String fibNumber) {
        long endTime = System.nanoTime();
        logger.info("Fibonacci of '" + fibNumber + "' took " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + " Millis");
    }

    @Test
    public void testFib_2() throws Exception {
        classUnderTest = new FibForkPoolJoin(2);
        pool.invoke(classUnderTest);
        calcTime("2");
        assertThat(classUnderTest.get(), is(new BigInteger("1")));
    }
    @Test
    public void testFib_4() throws Exception {
        classUnderTest = new FibForkPoolJoin(4);
        pool.invoke(classUnderTest);
        calcTime("4");
        assertThat(classUnderTest.get(), is(new BigInteger("3")));
    }

    @Test
    public void testFib_10() throws Exception {
        classUnderTest = new FibForkPoolJoin(10);
        pool.invoke(classUnderTest);
        calcTime("10");
        assertThat(classUnderTest.get(), is(new BigInteger("55")));
    }

    @Test
    public void testFib_30() throws Exception {
        classUnderTest = new FibForkPoolJoin(30);
        pool.invoke(classUnderTest);
        calcTime("30");
        assertThat(classUnderTest.get(), is(new BigInteger("832040")));
    }

    @Test
    public void testFib_39() throws Exception {
        classUnderTest = new FibForkPoolJoin(39);
        pool.invoke(classUnderTest);
        calcTime("39");
        assertThat(classUnderTest.get(), is(new BigInteger("63245986")));
    }

    @Test
    public void testFib_40() throws Exception {
        classUnderTest = new FibForkPoolJoin(40);
        pool.invoke(classUnderTest);
        calcTime("40");
        assertThat(classUnderTest.get(), is(new BigInteger("102334155")));
    }

    @Test
    public void testFib_41() throws Exception {
        classUnderTest = new FibForkPoolJoin(41);
        pool.invoke(classUnderTest);
        calcTime("41");
        assertThat(classUnderTest.get(), is(new BigInteger("165580141")));
    }

}