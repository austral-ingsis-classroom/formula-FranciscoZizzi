package edu.austral.ingsis.math;

public class Parenthesis implements UnaryOperator {
  private final Function operand;

  public Parenthesis(Function operand) {
    this.operand = operand;
  }

  @Override
  public Function getOperand() {
    return operand;
  }

  @Override
  public String getLeftSymbol() {
    return "(";
  }

  @Override
  public String getRightSymbol() {
    return ")";
  }

  @Override
  public Double solve() {
    return operand.solve();
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
