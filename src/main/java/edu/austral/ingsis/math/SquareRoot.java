package edu.austral.ingsis.math;

public class SquareRoot implements UnaryOperator {
  private final Function child;

  public SquareRoot(Function child) {
    this.child = child;
  }

  @Override
  public Double solve() {
    return Math.sqrt(child.solve());
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
