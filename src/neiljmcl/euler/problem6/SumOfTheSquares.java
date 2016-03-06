package neiljmcl.euler.problem6;

import java.util.stream.LongStream;

/**
 * The sum of the squares of the first ten natural numbers is,

 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
 * 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class SumOfTheSquares {
    public static void main(String[] args) {
        final long N = 100;
        long sumOfSquares = LongStream.rangeClosed(1, N)
                .map(i -> i*i)
                .reduce(0, Long::sum);
        long sum = LongStream.rangeClosed(1,N).sum();
        System.out.printf("SumOfSquares: %d; SquareOfSum: %d; difference: %d%n", sumOfSquares, sum * sum,
                (sum * sum) - sumOfSquares);
    }
}
