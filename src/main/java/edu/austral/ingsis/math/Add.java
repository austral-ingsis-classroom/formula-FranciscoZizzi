package edu.austral.ingsis.math;

public class Add implements BinaryOperator {
  private final Function leftOperand;
  private final Function rightOperand;

  public Add(Function leftOperand, Function rightOperand) {
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
  }

  @Override
  public Double solve() {
    return leftOperand.solve() + rightOperand.solve();
  }

  @Override
  public Function getLeftOperand() {
    return leftOperand;
  }

  @Override
  public Function getRightOperand() {
    return rightOperand;
  }

  @Override
  public String getSymbol() {
    return "+";
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
