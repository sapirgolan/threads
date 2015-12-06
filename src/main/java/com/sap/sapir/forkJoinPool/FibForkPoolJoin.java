package com.sap.sapir.forkJoinPool;

import com.sap.sapir.base.FibBase;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

/**
 * Created by I062070 on 06/12/2015.
 */
public class FibForkPoolJoin extends RecursiveTask<BigInteger>{

    private final int seed;

    public FibForkPoolJoin(int number) {
        seed = number;
    }

    @Override
    protected BigInteger compute() {
        if (seed <=1) {
            return new BigInteger(String.valueOf(seed));
        }
        if (seed <=5) {
            return new FibBase().fib(seed);
        }
        FibForkPoolJoin f1 = new FibForkPoolJoin(seed - 1);
        f1.fork();
        FibForkPoolJoin f2 = new FibForkPoolJoin(seed - 2);
        return f2.compute().add(f1.join());
    }
}
