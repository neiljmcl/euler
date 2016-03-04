package neiljmcl.euler.problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;
import java.util.stream.Collectors;
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
                factorize(600851475143L)
                        .stream().map((i) -> String.valueOf(i))
                        .collect(Collectors.joining(", ")));

    }

    public static LongStream possibleFactors(long min, long residual) {
        return LongStream.rangeClosed(min, residual)
                .filter((n) -> n % 2 != 0);
    }

    public static List<Long> factorize(long toBeFactorized) {
        return factorize(2l, toBeFactorized);
    }

    private static List<Long> factorize(long startingPoint, long residual) {
        OptionalLong optionalFactor = possibleFactors(startingPoint, residual)
                .filter((i) -> residual % i == 0)
                .findFirst();
        if (optionalFactor.isPresent()) {
            long factor = optionalFactor.getAsLong();
            List<Long> factors = factorize(factor, residual / factor);
            factors.add(factor);
            return factors;
        } else {
            return new ArrayList<Long>();
        }
    }
}
