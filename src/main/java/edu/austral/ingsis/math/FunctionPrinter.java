package edu.austral.ingsis.math;

public class FunctionPrinter implements Visitor {
  private StringBuilder string = new StringBuilder();

  @Override
  public void visit(BinaryOperator binaryOperator) {
    binaryOperator.getLeftOperand().accept(this);
    string.append(" ");
    string.append(binaryOperator.getSymbol());
    string.append(" ");
    binaryOperator.getRightOperand().accept(this);
  }

  @Override
  public void visit(UnaryOperator unaryOperator) {
    string.append(unaryOperator.getLeftSymbol());
    unaryOperator.accept(this);
    string.append(unaryOperator.getRightSymbol());
  }

  @Override
  public void visit(Variable variable) {
    string.append(variable.getName());
  }

  @Override
  public void visit(Value value) {
    string.append(value.getValue());
  }
}
