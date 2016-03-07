package neiljmcl.euler.problem7;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

 What is the 10 001st prime number?

 */
public class NthPrime {
    public static void main(String[] args) {
        final List<Long> primes = new ArrayList<>();
        primes.add(2L);
        LongPredicate predicate = isFactoredBy(2L);

        while (primes.size() <= 10000) {
            final long lastPrime = primes.get(primes.size() - 1);
            final long prime = LongStream.rangeClosed(lastPrime +1, Long.MAX_VALUE)
                    .filter(predicate.negate())
                    .findFirst()
                    .getAsLong();
            predicate = predicate.or(isFactoredBy(prime));
            primes.add(prime);
            System.out.printf("prime[%s]: %d%n", primes.size(), prime);
        }
    }

    private static LongPredicate isFactoredBy(long prime) {
        return new LongPredicate() {
            @Override
            public boolean test(long value) {
                return value != prime && value % prime == 0;
            }
        };
    }
}
