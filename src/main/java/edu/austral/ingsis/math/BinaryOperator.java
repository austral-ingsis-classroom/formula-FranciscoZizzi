package edu.austral.ingsis.math;

public interface BinaryOperator extends Function {
  Function getLeftOperand();
  Function getRightOperand();
  String getSymbol();
}
