package project.euler.task2;

import java.util.stream.Stream;

/**
 * Helper class for actions with Fibonacci sequence
 */
public class Fibonacci {

  /**
   * Method to find sum of all even Fibonacci numbers up to max.
   *
   * @param max  max Fibonacci number to consider.
   *
   * @return  Sum of all even Fibonacci numbers p to max.
   */
  int getEvenSum(int max) {
    int sum = 0;
    int cur = 1;
    int prev = 1;
    while(cur < max) {
      if(cur % 2 == 0) {
        sum += cur;
      }

      cur = cur + prev;
      prev = cur - prev;
    }

    return sum;
  }

  public int getEvenSumStream(int max) {
    return Stream.iterate(new int[] {1, 1, 0}, a -> new int[] {a[1], a[0] + a[1], a[1] % 2 == 0 ? a[2] + a[1] : a[2]})
      .limit(40)
      .filter(a -> a[1] <= max)
      .reduce((l, r) -> r)
      .orElse(new int[] {1, 1, 0})[2];
  }
}
