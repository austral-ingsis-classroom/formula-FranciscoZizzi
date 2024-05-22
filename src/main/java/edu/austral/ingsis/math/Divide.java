package edu.austral.ingsis.math;

public class Divide implements Operator {
  private final Function leftChild;
  private final Function rightChild;

  public Divide(Function leftChild, Function rightChild) {
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  @Override
  public Double solve() {
    return leftChild.solve() / rightChild.solve();
  }

  @Override
  public void accept(Visitor v) {

  }
}
