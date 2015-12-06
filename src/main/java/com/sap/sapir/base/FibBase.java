package com.sap.sapir.base;

import java.math.BigInteger;

/**
 * Created by I062070 on 06/12/2015.
 */
public class FibBase {
    public BigInteger fib(int number){

        if (number == 1) {
            return new BigInteger("1");
        }
        if (number == 0) {
            return new BigInteger("0");
        }

        return this.fib(number-1).add(this.fib(number-2));

    }
}
