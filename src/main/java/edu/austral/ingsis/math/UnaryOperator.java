package edu.austral.ingsis.math;

public interface UnaryOperator extends Function {
  Function getOperand();
  String getLeftSymbol();
  String getRightSymbol();
}
