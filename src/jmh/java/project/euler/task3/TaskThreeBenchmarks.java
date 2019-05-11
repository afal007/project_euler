package project.euler.task3;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.All)
@Warmup(iterations = 5)
@Measurement(iterations = 5, batchSize = 5)
public class TaskThreeBenchmarks {

  @Benchmark
  public void fullScan(Blackhole blackhole) {
    blackhole.consume(new PrimeFactor().getFullScan(600_851_475_143L));
  }

  @Benchmark
  public void lessIterations(Blackhole blackhole) {
    blackhole.consume(new PrimeFactor().getLessIterations(600_851_475_143L));
  }

}
