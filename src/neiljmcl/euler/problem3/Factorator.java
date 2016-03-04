package neiljmcl.euler.problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Factorator {
    public static void main(String[] args) {
        System.out.printf(
                "Factors are: %s%n",
                factorate(3, 600851475143L)
                        .stream().map((i) -> String.valueOf(i))
                        .collect(Collectors.joining(", ")));

    }

    public static LongStream oddNumbers(long min) {
        if (min % 2 == 0) {
            throw new RuntimeException("Unable to seed oddNumbers with even number: " + min);
        }
        return LongStream.iterate(min, (n) -> n+2);
    }

    public static List<Long> factorate(long startingPoint, long toBeFactorized) {
        // System.out.printf("Starting point: %d; toBeFactorized: %d%n", startingPoint, toBeFactorized);
        if (startingPoint >= toBeFactorized) {
            return new ArrayList<Long>();
        }
        OptionalLong first = oddNumbers(startingPoint)
                .filter((i) -> toBeFactorized % i == 0)
                .findFirst();

        long factor = first.getAsLong();
        long otherFactor = toBeFactorized / factor;
        System.out.printf("Factors of %d: %d; other factor: %d%n", toBeFactorized, factor, otherFactor);

        List<Long> factors = factorate(factor, otherFactor);
        factors.add(0, factor);
        return factors;

    }
}
