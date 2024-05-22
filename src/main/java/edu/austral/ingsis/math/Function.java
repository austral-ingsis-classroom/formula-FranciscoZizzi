package edu.austral.ingsis.math;

public interface Function<N extends Number> extends Visitable {
  N solve();
}
