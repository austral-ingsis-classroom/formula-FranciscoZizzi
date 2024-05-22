package edu.austral.ingsis.math;

public class Multiply implements Operator {
  private final Function leftChild;
  private final Function rightChild;

  public Multiply(Function leftChild, Function rightChild) {
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  @Override
  public Double solve() {
    return leftChild.solve() * rightChild.solve();
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
