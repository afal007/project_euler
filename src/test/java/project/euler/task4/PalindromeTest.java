package project.euler.task4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeTest {

  private static Palindrome palindrome;

  @BeforeAll
  static void setUp() {
    palindrome = new Palindrome();
  }

  @Test
  void test_get() {
    assertEquals(906609, palindrome.get());
  }

  @Test
  void test_getFullScan() {
    assertEquals(906609, palindrome.getFullScan());
  }
}
