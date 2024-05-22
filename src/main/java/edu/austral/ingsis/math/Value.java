package edu.austral.ingsis.math;

public class Value implements Function {
  private final Double value;

  public Value(Double value) {
    this.value = value;
  }

  @Override
  public Double solve() {
    return value;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
