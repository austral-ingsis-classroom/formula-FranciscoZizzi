package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function function = new Addition(new Value(1d), new Value(6d));
    final List<String> result = listVariables(function);

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function function = new Division(new Value(12d), new Variable("div"));
    final List<String> result = listVariables(function);

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function function =
        new Multiplication(new Division(new Value(9d), new Variable("x")), new Variable("y"));
    final List<String> result = listVariables(function);

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function function =
        new Exponentiation(new Division(new Value(27d), new Variable("a")), new Variable("b"));
    final List<String> result = listVariables(function);

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function function =
        new Exponentiation(new Variable("z"), new Division(new Value(1d), new Value(2d)));
    final List<String> result = listVariables(function);

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function function = new Subtraction(new AbsoluteValue(new Variable("value")), new Value(8d));
    final List<String> result = listVariables(function);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function function = new Subtraction(new AbsoluteValue(new Variable("value")), new Value(8d));
    final List<String> result = listVariables(function);

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function function =
        new Multiplication(new Subtraction(new Value(5d), new Variable("i")), new Value(8d));
    final List<String> result = listVariables(function);

    assertThat(result, containsInAnyOrder("i"));
  }

  public List<String> listVariables(Function function) {
    VariableLister variableLister = new VariableLister();
    function.accept(variableLister);
    return variableLister.getVariables();
  }
}
