package project.euler.task2;

/**
 * Helper class for actions with Fibonacci sequence
 */
class Fibonacci {

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

  /**
   * Method to find sum of all even Fibonacci numbers up to max.
   * Check for even avoided using formula, that gives only even Fibonacci numbers:
   * E(n)=4*E(n-1)+E(n-2).
   *
   * @param max  max Fibonacci number to consider.
   *
   * @return  Sum of all even Fibonacci numbers p to max.
   */
  int getEvenSumOptimize(int max) {
    int sum = 0;
    int prev = 2;
    int cur = 8;
    while(prev < max) {
      sum += prev;

      int tmp = cur;
      cur = 4 * cur + prev;
      prev = tmp;
    }

    return sum;
  }
}
