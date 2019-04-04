package project.euler.task1;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.All)
@Warmup(iterations = 5)
@Measurement(iterations = 10, batchSize = 5)
public class TaskOneBenchmarks {

  @Benchmark
  public void imperative(Blackhole blackhole) {
    blackhole.consume(new Adder().getSum(10000));
  }

  @Benchmark
  public void filter(Blackhole blackhole) {
    blackhole.consume(new Adder().getSumFunctionalFilter(10000));
  }

  @Benchmark
  public void reduce(Blackhole blackhole) {
    blackhole.consume(new Adder().getSumFunctionalReduce(10000));
  }

}
