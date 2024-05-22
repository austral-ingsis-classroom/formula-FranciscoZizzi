package edu.austral.ingsis.math;

import java.util.ArrayList;
import java.util.List;

public class VariableLister implements Visitor {
  private final List<String> variables = new ArrayList<>();

  @Override
  public void visit(BinaryOperator binaryOperator) {
    binaryOperator.getLeftOperand().accept(this);
    binaryOperator.getRightOperand().accept(this);
  }

  @Override
  public void visit(UnaryOperator unaryOperator) {
    unaryOperator.getOperand().accept(this);
  }

  @Override
  public void visit(Variable variable) {
    variables.add(variable.getName());
  }

  @Override
  public void visit(Value value) {}

  public List<String> getVariables() {
    return variables;
  }
}
