package edu.austral.ingsis.math;

public class SquareRoot implements UnaryOperator {
  private final Function operand;

  public SquareRoot(Function operand) {
    this.operand = operand;
  }

  @Override
  public Double solve() {
    return Math.sqrt(operand.solve());
  }

  @Override
  public Function getOperand() {
    return operand;
  }

  @Override
  public String getLeftSymbol() {
    return "sqrt(";
  }

  @Override
  public String getRightSymbol() {
    return ")";
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

}
