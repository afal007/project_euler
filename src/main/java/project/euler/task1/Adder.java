package project.euler.task1;

import java.util.stream.IntStream;

/**
 * Class for adding all natural integer multiples of 3 or 5 up to specified max value.
 */
class Adder {

  /**
   * Method for evaluating sum of all natural integer multiples of 3 or 5 up to specified max value procedural style.
   *
   * @param max   max value.
   *
   * @return  Sum.
   */
  int getSum(int max) {
    int sum = 0;
    for (int i = 0; i < max; i++) {
      if (isGoodInt(i)) {
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
  int getSumFunctionalFilter(int max) {
    return IntStream.range(0, max)
      .filter(this::isGoodInt)
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
  int getSumFunctionalReduce(int max) {
    return IntStream.range(0, max)
      .reduce(0, (i, i1) -> isGoodInt(i1) ? i + i1 : i);
  }

  /**
   * Helper method for evaluating if specified number is multiple of 3 or 5.
   *
   * @param num   Integer.
   *
   * @return  true - if Integer is multiple of 3 or 5.
   *          false
   */
  private boolean isGoodInt(int num) {
    return num % 3 == 0 || num % 5 == 0;
  }
}
