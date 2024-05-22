package edu.austral.ingsis.math;

public interface Visitor {
  void visit(Operator operator);
  void visit(Variable variable);
  void visit(Value value);
}
