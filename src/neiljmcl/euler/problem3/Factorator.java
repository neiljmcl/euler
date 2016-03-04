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
                factorize(13195L)
                        .stream().map((i) -> String.valueOf(i))
                        .collect(Collectors.joining(", ")));

    }

    public static LongStream possibleFactors(long min, long residual) {
        return LongStream.rangeClosed(min, residual)
                .filter((n) -> n % 2 != 0);
    }

    public static List<Long> factorize(long toBeFactorized) {
        ArrayList<Long> factors = new ArrayList<>();
        factorize(2l, toBeFactorized, factors);
        return factors;
    }

    private static void factorize(long startingPoint, long residual, ArrayList<Long> factors) {
        OptionalLong optionalFactor = possibleFactors(startingPoint, residual)
                .filter((i) -> residual % i == 0)
                .findFirst();
        if (optionalFactor.isPresent()) {
            long factor = optionalFactor.getAsLong();
            factors.add(factor);
            factorize(factor, residual/factor, factors);
        }
    }
}
