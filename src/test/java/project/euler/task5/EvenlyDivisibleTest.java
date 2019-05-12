package project.euler.task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenlyDivisibleTest {

  @Test
  void test_get() {
    assertEquals(232792560L, new EvenlyDivisible().get());
  }
}
