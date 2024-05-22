package edu.austral.ingsis.math;

public class Exponentiation implements Operator {
  private final Function child;
  private final Double exponent;

  public Exponentiation(Function child, Double exponent) {
    this.child = child;
    this.exponent = exponent;
  }

  @Override
  public Double solve() {
    return Math.pow(child.solve(), exponent);
  }

  @Override
  public void accept(Visitor v) {

  }
}
