package project.euler.task3;

/**
 * Class for evaluating max prime factor of a number
 */
class PrimeFactor {

  /**
   * Method for calculating max prime factor of a number.
   *
   * @param num  Number.
   *
   * @return  Maximum prime factor.
   */
  long getFullScan(long num) {
    long factor = 1;
    while (num > 1) {
      for (factor = 2; factor <= num; factor++) {
        if (num % factor == 0) {
          num = num / factor;
          break;
        }
      }
    }

    return factor;
  }

  /**
   * Method for calculating max prime factor of a number.
   *
   * Optimize number of iterations by using the fact that:
   * 1) Of all even factors only 2 should be considered - now we can increase factor by 2 on each step.
   * 2) Every number n can at most have one prime factor greater than sqrt(n).
   *
   * @param num  Number.
   *
   * @return  Maximum prime factor.
   */
  long getLessIterations(long num) {
    if (num < 1) {
      return 1L;
    }

    long factor = 1;
    while (num % 2 == 0) {
      factor = 2;
      num /= 2;
    }

    for (int i = 3; i <= Math.sqrt(num); i += 2) {
      while (num % i == 0) {
        factor = i;
        num /= i;
      }
    }

    if (num > 2) {
      factor = num;
    }

    return factor;
  }
}
