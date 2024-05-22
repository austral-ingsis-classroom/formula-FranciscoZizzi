package edu.austral.ingsis.math;

public class Variable implements Function {
  private Double value;
  private final String name;

  public Variable(Double value, String name) {
    this.value = value;
    this.name = name;
  }

  public Variable(String name) {
    this.value = 1d;
    this.name = name;
  }

  @Override
  public Double solve() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
