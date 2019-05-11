package project.euler.task3;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143?
 */
public class TaskThree {
  public static void main(String[] args) {
    System.out.println(new PrimeFactor().getFullScan(600_851_475_143L));
  }
}
