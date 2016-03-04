package neiljmcl.euler.problem4;

import java.util.HashSet;
import java.util.Set;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit
 * numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class LargestPalindrome {
    public static void main(String[] args) {
        String s = new LargestPalindrome().find();
        System.out.printf("Largest palindrome: %s%n", s);
    }
    public Stream<Long> products() {
        Set<Long> productSet = new HashSet<>();
        LongStream.rangeClosed(100, 999).forEach(new LongConsumer() {
            @Override
            public void accept(long i) {
                LongStream.rangeClosed(100, 999).forEach(new LongConsumer() {
                    @Override
                    public void accept(long j) {
                        productSet.add(i * j);
                    }
                });
            }
        });
        Stream<Long> stream = productSet.stream();
        Stream<Long> longStream = productSet.stream().map(Long::longValue);

        return productSet.stream().map(Long::longValue);
    }


    public String find() {
        return String.valueOf(
                products()
                        .filter(this::isPalindrome)
                        .reduce(Long::max)
                        .get());
    }
    private boolean isPalindrome(long number) {
      return this.isPalindrome(String.valueOf(number));
    }
    private boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}