package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    Function function = new Addition(new Value(1d), new Value(6d));

    final String expected = "1 + 6";
    final String result = printFunction(function);

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    Function function = new Division(new Value(12d), new Value(2d));

    final String expected = "12 / 2";
    final String result = printFunction(function);

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    Function function =
        new Multiplication(
            new Parenthesis(new Division(new Value(9d), new Value(2d))), new Value(3d));

    final String expected = "(9 / 2) * 3";
    final String result = printFunction(function);

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    Function function =
        new Exponentiation(
            new Parenthesis(new Division(new Value(27d), new Value(6d))), new Value(2d));

    final String expected = "(27 / 6) ^ 2";
    final String result = printFunction(function);

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    Function function = new Subtraction(new AbsoluteValue(new Variable("value")), new Value(8d));

    final String expected = "|value| - 8";
    final String result = printFunction(function);

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    Function function = new Subtraction(new AbsoluteValue(new Variable("value")), new Value(8d));

    final String expected = "|value| - 8";
    final String result = printFunction(function);

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    Function function =
        new Multiplication(
            new Parenthesis(new Subtraction(new Value(5d), new Variable("i"))), new Value(8d));

    final String expected = "(5 - i) * 8";
    final String result = printFunction(function);

    assertThat(result, equalTo(expected));
  }

  private String printFunction(Function function) {
    FunctionPrinter printer = new FunctionPrinter();
    function.accept(printer);
    return printer.getString();
  }
}
