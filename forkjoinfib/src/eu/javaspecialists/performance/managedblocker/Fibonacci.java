package eu.javaspecialists.performance.managedblocker;

import java.math.*;
import java.util.concurrent.*;

// demo1: test100_000_000() time = 46547
// demo2: test100_000_000() time = 22470

// TODO: Would you like to subscribe to my free advanced Java newsletter?
// TODO: Or are you subscribed already and would like to say "hi"?
// TODO: Do both here: tinyurl.com/devoxxuk17
public class Fibonacci {
    public BigInteger f(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        int half = (n + 1) / 2;

        RecursiveTask<BigInteger> f0_task = new RecursiveTask<BigInteger>() {
            protected BigInteger compute() {
                return f(half-1);
            }
        };
        f0_task.fork();
        BigInteger f1 = f(half);
        BigInteger f0 = f0_task.join();

        if (n % 2 == 1) {
            return f0.multiply(f0).add(f1.multiply(f1));
        } else {
            return f0.shiftLeft(1).add(f1).multiply(f1);
        }
    }
}
