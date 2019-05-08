package project.euler.task1;

import java.util.stream.LongStream;

/**
 * Class for adding all natural integer multiples of 3 or 5 up to specified max value.
 */
class Adder {

  /**
   * Method for evaluating sum of all natural integer multiples of 3 or 5 up to
   * specified max value using arithmetic progression sum formula.
   *
   * @param max   max value.
   *
   * @return  Sum.
   */
  long getSum(long max) {
    return (getSum(max, 3) + getSum(max, 5)) - getSum(max, 15);
  }

  private long getSum(long max, int multiplier) {
    long last = (max - 1) / multiplier;
    return (multiplier * (last * (last + 1))) / 2;
  }

  /**
   * Method for evaluating sum of all natural integer multiples of 3 or 5 up to specified max value procedural style.
   *
   * @param max   max value.
   *
   * @return  Sum.
   */
  long getSumIter(long max) {
    long sum = 0;
    for (long i = 0; i < max; i++) {
      if (isGoodLong(i)) {
        sum += i;
      }
    }

    return sum;
  }

  /**
   * Method for evaluating sum of all natural integer multiples of 3 or 5 up to
   * specified max value functional style using filter + sum.
   *
   * @param max   max value.
   *
   * @return  Sum.
   */
  long getSumFunctionalFilter(long max) {
    return LongStream.range(0, max)
      .filter(this::isGoodLong)
      .sum();
  }

  /**
   * Method for evaluating sum of all natural integer multiples of 3 or 5 up to
   * specified max value functional style using reduce.
   *
   * @param max   max value.
   *
   * @return  Sum.
   */
  long getSumFunctionalReduce(long max) {
    return LongStream.range(0, max)
      .reduce(0, (i, i1) -> isGoodLong(i1) ? i + i1 : i);
  }

  /**
   * Helper method for evaluating if specified number is multiple of 3 or 5.
   *
   * @param num   Long.
   *
   * @return  true - if Long is multiple of 3 or 5.
   *          false - otherwise
   */
  private boolean isGoodLong(long num) {
    return num % 3 == 0 || num % 5 == 0;
  }
}
