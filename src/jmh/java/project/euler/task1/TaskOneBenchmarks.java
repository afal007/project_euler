package project.euler.task1;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.All)
@Warmup(iterations = 5)
@Measurement(iterations = 5, batchSize = 5)
public class TaskOneBenchmarks {

  @Benchmark
  public void iter(Blackhole blackhole) {
    blackhole.consume(new Adder().getSumIter(1_000_000_000));
  }

  @Benchmark
  public void constant(Blackhole blackhole) {
    blackhole.consume(new Adder().getSum(1_000_000_000));
  }

  @Benchmark
  public void filter(Blackhole blackhole) {
    blackhole.consume(new Adder().getSumFunctionalFilter(1_000_000_000));
  }

  @Benchmark
  public void reduce(Blackhole blackhole) {
    blackhole.consume(new Adder().getSumFunctionalReduce(1_000_000_000));
  }

}
