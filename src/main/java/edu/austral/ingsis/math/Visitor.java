package edu.austral.ingsis.math;

public interface Visitor {
  void visit(BinaryOperator binaryOperator);
  void visit(UnaryOperator unaryOperator);
  void visit(Variable variable);
  void visit(Value value);
}
