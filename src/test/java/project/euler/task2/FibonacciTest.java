package project.euler.task2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciTest {

  private static Fibonacci fibonacci;

  @BeforeAll
  static void setUp() {
    fibonacci = new Fibonacci();
  }

  @Test
  void test_getEvenSum_GreaterThanZero() {
    execTestGreaterThanZero(fibonacci::getEvenSum);
  }

  @Test
  void test_getEvenSum_LessThanZero() {
    execTestLessThenZero(fibonacci::getEvenSum);
  }

  @Test
  void test_getEvenSum_EqualsZero() {
    assertEqualsZero(0, fibonacci::getEvenSum);
  }

  @Test
  void test_getEvenSumOptimize_GreaterThanZero() {
    execTestGreaterThanZero(fibonacci::getEvenSumOptimize);
  }

  @Test
  void test_getEvenSumOptimize_LessThanZero() {
    execTestLessThenZero(fibonacci::getEvenSumOptimize);
  }

  @Test
  void test_getEvenSumOptimize_EqualsZero() {
    assertEqualsZero(0, fibonacci::getEvenSumOptimize);
  }

  private void execTestGreaterThanZero(IntFunction<Integer> func) {
    assertAll(
      () -> assertEquals((Integer)2, func.apply(5), "Up to 5 is 2"),
      () -> assertEquals((Integer)10, func.apply(10), "Up to 10 is 10"),
      () -> assertEquals((Integer)44, func.apply(50), "Up to 50 is 44"),
      () -> assertEquals((Integer)44, func.apply(100), "Up to 100 is 44"),
      () -> assertEquals((Integer)4_613_732, func.apply(4_000_000), "Up to 4_000_000 is 4_613_732")
    );
  }

  private void execTestLessThenZero(IntFunction<Integer> func) {
    assertAll(
      () -> assertEqualsZero(-1, func),
      () -> assertEqualsZero(-5, func),
      () -> assertEqualsZero(-50, func),
      () -> assertEqualsZero(-1_000_000, func)
    );
  }

  void assertEqualsZero(int max, IntFunction<Integer> func) {
    assertEquals((Integer) 0, func.apply(max), "Up to " + max + " is 0");
  }
}
