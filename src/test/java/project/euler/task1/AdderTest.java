package project.euler.task1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.IntFunction;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdderTest {

  private static final String DISPLAY_NAME = "[{index}] {1}";

  private static Adder adder;

  @BeforeAll
  static void setUp() {
    adder = new Adder();
  }

  @ParameterizedTest(name = DISPLAY_NAME)
  @MethodSource
  void test_GreaterThanZero(IntFunction<Integer> func, String message) {
    assertEquals(23, func.apply(10).intValue(), message);
  }

  @ParameterizedTest(name = DISPLAY_NAME)
  @MethodSource
  void test_LessThanZero(IntFunction<Integer> func, String message) {
    assertEquals(0, func.apply(-1).intValue(), message);
  }

  @ParameterizedTest(name = DISPLAY_NAME)
  @MethodSource
  void test_EqualsZero(IntFunction<Integer> func, String message) {
    assertEquals(0, func.apply(0).intValue(), message);
  }

  @ParameterizedTest
  @CsvSource({
    "10, 23",
    "0, 0",
    "-1, 0"
  })
  void test_AllMethodsEquals(int arg, int expected) {
    int getSum = adder.getSum(arg);
    int sumFunctionalFilter = adder.getSumFunctionalFilter(arg);
    int sumFunctionalReduce = adder.getSumFunctionalReduce(arg);

    assertEquals(getSum, sumFunctionalFilter, "getSum equals sumFunctionalFilter");
    assertEquals(sumFunctionalFilter, sumFunctionalReduce, "sumFunctionalFilter equals sumFunctionalReduce");
    assertEquals(sumFunctionalReduce, getSum, "sumFunctionalReduce equals getSum");

    assertEquals(getSum, expected, "Actual output of all methods equals expected");
  }

  private static final IntFunction<Integer> GET_SUM = i -> adder.getSum(i);
  private static final IntFunction<Integer> GET_SUM_FILTER = i -> adder.getSumFunctionalFilter(i);
  private static final IntFunction<Integer> GET_SUM_REDUCE = i -> adder.getSumFunctionalReduce(i);

  private static Stream<Arguments> test_GreaterThanZero() {
    return Stream.of(
      Arguments.arguments(GET_SUM, "Procedural sum up to 10 is 23"),
      Arguments.arguments(GET_SUM_FILTER, "Functional filter sum up to 10 is 23"),
      Arguments.arguments(GET_SUM_REDUCE, "Functional reduce sum up to 10 is 23")
    );
  }

  private static Stream<Arguments> test_LessThanZero() {
    return Stream.of(
      Arguments.arguments(GET_SUM, "Procedural sum up to -1 is 0"),
      Arguments.arguments(GET_SUM_FILTER, "Functional filter sum up to -1 is 0"),
      Arguments.arguments(GET_SUM_REDUCE, "Functional reduce sum up to -1 is 0")
    );
  }

  private static Stream<Arguments> test_EqualsZero() {
    return Stream.of(
      Arguments.arguments(GET_SUM, "Procedural sum up to 0 is 0"),
      Arguments.arguments(GET_SUM_FILTER, "Functional filter sum up to 0 is 0"),
      Arguments.arguments(GET_SUM_REDUCE, "Functional reduce sum up to 0 is 0")
    );
  }
}
