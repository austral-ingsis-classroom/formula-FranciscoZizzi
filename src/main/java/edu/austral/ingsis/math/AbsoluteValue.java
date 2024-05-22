package edu.austral.ingsis.math;

import static java.lang.Math.abs;

public class AbsoluteValue implements UnaryOperator {
  private final Function operand;

  public AbsoluteValue(Function operand) {
    this.operand = operand;
  }

  @Override
  public Double solve() {
    return abs(operand.solve());
  }

  @Override
  public Function getOperand() {
    return operand;
  }

  @Override
  public String getLeftSymbol() {
    return "|";
  }

  @Override
  public String getRightSymbol() {
    return "|";
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
