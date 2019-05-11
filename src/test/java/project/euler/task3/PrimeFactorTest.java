package project.euler.task3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrimeFactorTest {

  private static PrimeFactor primeFactor;

  @BeforeAll
  static void setUp() {
    primeFactor = new PrimeFactor();
  }

  @ParameterizedTest
  @MethodSource("getArgumentsStream")
  void test_GetFullScan(long input, long expected) {
    assertEquals(expected, primeFactor.getFullScan(input));
  }

  @ParameterizedTest
  @MethodSource("getArgumentsStream")
  void test_GetLessIterations(long input, long expected) {
    assertEquals(expected, primeFactor.getLessIterations(input));
  }

  private static Stream<Arguments> getArgumentsStream() {
    return Stream.of(
      Arguments.arguments(1L, 1L),
      Arguments.arguments(0L, 1L),
      Arguments.arguments(-1L, 1L),
      Arguments.arguments(10L, 5L),
      Arguments.arguments(15L, 5L),
      Arguments.arguments(9L, 3L),
      Arguments.arguments(13195L, 29L),
      Arguments.arguments(600_851_475_143L, 6857L)
    );
  }
}
