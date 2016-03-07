package neiljmcl.euler.problem9;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc
 */
public class PythagoreanTriplet {

    private static class Triple {
        private final int a;
        private final int b;
        private final int c;

        public Triple(int a, int b, int c) {

            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return String.format("%d %d %d; sum: %d", a, b, c, a + b + c);
        }

        public boolean isPythagorean() {
            return a * a + b * b == c * c;
        }

        public int sum() {
            return a + b + c;
        }
        public int product() {
            return a * b * c;
        }
    }

    public static void main(String[] args) {
        Optional<Integer> integer = IntStream.range(1, 1000)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, 1000)
                        .boxed()
                        .flatMap(j -> IntStream.range(j + 1, 1000)
                                .boxed()
                                .map(k -> new Triple(i, j, k)))
                        .filter(t -> t.isPythagorean())
                        .filter(t -> t.sum() == 1000))
                .findFirst()
                .map(Triple::product);
        System.out.printf("%s%n", integer.get());
    }
}
