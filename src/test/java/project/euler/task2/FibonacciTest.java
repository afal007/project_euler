package project.euler.task2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

  private static Fibonacci fibonacci;

  @BeforeAll
  static void setUp() {
    fibonacci = new Fibonacci();
  }

  @Test
  void test_GreaterThanZero() {
    assertAll(
      () -> assertEquals(2, fibonacci.getEvenSum(5), "Up to 5 is 2"),
      () -> assertEquals(10, fibonacci.getEvenSum(10), "Up to 10 is 10"),
      () -> assertEquals(44, fibonacci.getEvenSum(50), "Up to 50 is 44"),
      () -> assertEquals(44, fibonacci.getEvenSum(100), "Up to 100 is 44"),
      () -> assertEquals(4_613_732, fibonacci.getEvenSum(4_000_000), "Up to 4_000_000 is 4_613_732")
    );
  }

  @Test
  void test_LessThanZero() {
    assertAll(
      () -> assertEqualsZero(-1),
      () -> assertEqualsZero(-5),
      () -> assertEqualsZero(-50),
      () -> assertEqualsZero(-1_000_000)
    );
  }

  @Test
  void test_EqualsZero() {
    assertEqualsZero(0);
  }

  void assertEqualsZero(int max) {
    assertEquals(0, fibonacci.getEvenSum(max), "Up to " + max + " is 0");
  }
}
