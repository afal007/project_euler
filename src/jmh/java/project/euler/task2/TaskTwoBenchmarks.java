package project.euler.task2;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.All)
@Warmup(iterations = 5)
@Measurement(iterations = 5, batchSize = 5)
public class TaskTwoBenchmarks {

  @Benchmark
  public void getEvenSum(Blackhole blackhole) {
    blackhole.consume(new Fibonacci().getEvenSum(4_000_000));
  }

  @Benchmark
  public void getEvenSumOptimize(Blackhole blackhole) {
    blackhole.consume(new Fibonacci().getEvenSumOptimize(4_000_000));
  }

}
