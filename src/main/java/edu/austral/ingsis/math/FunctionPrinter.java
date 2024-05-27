package edu.austral.ingsis.math;

public class FunctionPrinter implements Visitor {
  private final StringBuilder stringBuilder = new StringBuilder();

  @Override
  public void visit(BinaryOperator binaryOperator) {
    stringBuilder.append("(");
    binaryOperator.getLeftOperand().accept(this);
    stringBuilder.append(" ");
    stringBuilder.append(binaryOperator.getSymbol());
    stringBuilder.append(" ");
    binaryOperator.getRightOperand().accept(this);
    stringBuilder.append(")");
  }

  @Override
  public void visit(UnaryOperator unaryOperator) {
    stringBuilder.append(unaryOperator.getLeftSymbol());
    unaryOperator.getOperand().accept(this);
    stringBuilder.append(unaryOperator.getRightSymbol());
  }

  @Override
  public void visit(Variable variable) {
    stringBuilder.append(variable.getName());
  }

  @Override
  public void visit(Value value) {
    String number = value.solve().toString();
    for (int i = number.length() - 1; i >= 0; i--) {
      if (number.charAt(i) != '0' && number.charAt(i) != '.') {
        break;
      }
      number = number.substring(0, i);
    }

    stringBuilder.append(number);
  }

  public String getString() {
    if (stringBuilder.charAt(0) == '(' && stringBuilder.charAt(stringBuilder.length() - 1) == ')') {
      stringBuilder.deleteCharAt(0);
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }
    return stringBuilder.toString();
  }
}
