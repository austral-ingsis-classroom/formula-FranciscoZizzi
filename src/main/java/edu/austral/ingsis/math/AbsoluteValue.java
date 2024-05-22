package edu.austral.ingsis.math;

import static java.lang.Math.abs;

public class AbsoluteValue implements UnaryOperator {
  private final Function child;

  public AbsoluteValue(Function child) {
    this.child = child;
  }

  @Override
  public Double solve() {
    return abs(child.solve());
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
