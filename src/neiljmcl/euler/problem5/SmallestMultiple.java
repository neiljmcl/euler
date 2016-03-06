package neiljmcl.euler.problem5;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 2520 is the smallest number that is divisible by each int from 1 - 10
 * Want smallest positive number divisible by each no from 1 - 20.
 */
public class SmallestMultiple {
    public static void main(String[] args) {
        int n = IntStream.iterate(1, i -> i + 1)
                .filter(divisibleByAll())
                .findFirst()
                .getAsInt();
        System.out.printf("Found %d%n", n);
    }

    private static IntPredicate divisibleByAll() {
        return IntStream.rangeClosed(2,10)
                .boxed()
                .map(i -> divisibleBy(i))
                .reduce((a,b) -> a.and(b))
                .get();
    }

    private static IntPredicate divisibleBy(final int potentialDivisor) {
        return new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % potentialDivisor == 0;
            }
        };
    }
}
