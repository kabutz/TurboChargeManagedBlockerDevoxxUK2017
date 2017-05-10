package eu.javaspecialists.performance.managedblocker;

import java.math.*;

// TODO: Would you like to subscribe to my free advanced Java newsletter?
// TODO: Or are you subscribed already and would like to say "hi"?
// TODO: Do both here: tinyurl.com/devoxxuk17
public class Fibonacci {
    public BigInteger f(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;
        return f(n - 1).add(f(n - 2));
    }
}
