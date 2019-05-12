package project.euler.task5;

import java.util.HashSet;
import java.util.Set;

class EvenlyDivisible {
  long get() {
    for (long i = 2521;; i++) {
      if(isDivisible(i)) {
        return i;
      }
    }
  }

  private static Set<Integer> divisors = new HashSet<Integer>(){{
    add(20);
    add(19);
    add(18);
    add(17);
    add(16);
    add(15);
    add(14);
    add(13);
    add(12);
    add(11);
  }};

  private boolean isDivisible(long i) {
    for (Integer divisor : divisors) {
      if(i % divisor != 0) {
        return false;
      }
    }

    return true;
  }
}
