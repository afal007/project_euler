package project.euler.task4;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.All)
@Warmup(iterations = 5)
@Measurement(iterations = 5, batchSize = 5)
public class TaskFourBenchmarks {

  @Benchmark
  public void getFullScan(Blackhole blackhole) {
    blackhole.consume(new Palindrome().getFullScan());
  }

  @Benchmark
  public void get(Blackhole blackhole) {
    blackhole.consume(new Palindrome().get());
  }

}
