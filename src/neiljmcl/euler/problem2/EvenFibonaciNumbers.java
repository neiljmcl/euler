package neiljmcl.euler.problem2;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
public class EvenFibonaciNumbers {


    public static class FibonaciIterator implements Iterator<BigInteger> {
        private BigInteger secondLastElement;
        private BigInteger lastElement;
        private BigInteger threshold = BigInteger.valueOf(4000000L);
        public FibonaciIterator() {
            this(1,2);
        }

        public FibonaciIterator(int firstSeed, int secondSeed) {
            this.secondLastElement = BigInteger.valueOf(firstSeed);
            this.lastElement = BigInteger.valueOf(secondSeed);
        }

        @Override
        public boolean hasNext() {
            return peek().compareTo(threshold) < 0;
        }

        @Override
        public BigInteger next() {
            BigInteger nextElement = peek();
            secondLastElement = lastElement;
            lastElement = nextElement;
            return nextElement;
        }

        private BigInteger peek() {
            return lastElement.add(secondLastElement);
        }
    }
}
