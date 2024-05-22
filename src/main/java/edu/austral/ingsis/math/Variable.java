package edu.austral.ingsis.math;

public class Variable implements Function {
  private Double value;
  private final String name;

  public Variable(Double value, String name) {
    this.value = value;
    this.name = name;
  }

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public Double solve() {
    return value;
  }

  @Override
  public void accept(Visitor v) {

  }
}
