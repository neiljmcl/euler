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
                .filter(i -> i % 2 == 0 && i % 3 == 0 && i % 4 == 0 && i % 5 == 0
                        && i % 6 == 0 && i % 7 == 0 && i % 8 == 0 && i % 9 == 0 && i % 10 == 0 )
                .findFirst()
                .getAsInt();
        System.out.printf("Found %d%n", n);

        // How to build an IntPredicate by and-ing together a set of IntPredicates
    }

    private class DivisibleBy implements IntPredicate {
        private final int potentialDivisor;

        public DivisibleBy(int potentialDivisor) {
            this.potentialDivisor = potentialDivisor;
        }

        @Override
        public boolean test(int value) {
            return value % potentialDivisor == 0;
        }
    }

//    private class DivisibleByUpTo implements IntPredicate {
//        private final int max;
//        public DivisibleByUpTo(int max) {
//            this.max = max;
//            Stream<DivisibleBy> stream = IntStream.rangeClosed(2, max).boxed()
//                    .map(i -> new DivisibleBy(i));
//            stream.reduce(DivisibleBy::and);
//            // .reduce((a,b) -> a.and(b));
//        }
//
//        @Override
//        public boolean test(int value) {
//            return false;
//        }
//
//
//    }
//    private IntPredicate compose(IntPredicate... predicates) {
//
//    }
}
