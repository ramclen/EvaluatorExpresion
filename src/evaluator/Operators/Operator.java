package evaluator.Operators;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.Value;

public interface Operator {
    public Value calculate(Expression left, Expression right);
}
