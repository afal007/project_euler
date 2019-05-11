package project.euler.task4;

/**
 * Class for finding the largest palindrome made from the product of two 3-digit numbers.
 */
class Palindrome {

  /**
   * Method for finding the largest palindrome made from the product
   * of two 3-digit numbers with some optimizations for loops lengths.
   *
   * @return  The largest palindrome made from the product of two 3-digit numbers
   */
  int get() {
    int max = 0;
    for (int i = 999; i >= 100 ; i--) {
      for (int j = 999; j >= i; j--) {
        int mult = i * j;
        if(mult <= max) {
          break;
        }

        if(isPalindrome(mult)) {
          max = mult;
        }
      }
    }

    return max;
  }

  /**
   * Method for finding the largest palindrome made from the product of two 3-digit numbers.
   *
   * @return  The largest palindrome made from the product of two 3-digit numbers
   */

  int getFullScan() {
    int max = 0;
    for (int i = 100; i < 1000 ; i++) {
      for (int j = 100; j < 1000; j++) {
        int mult = i * j;
        if(isPalindrome(mult) && mult > max) {
          max = mult;
        }
      }
    }

    return max;
  }

  private boolean isPalindrome(int mult) {
    String s = String.valueOf(mult);
    return s.equals(new StringBuilder(s).reverse().toString());
  }
}
