package evaluator.Operators;

import evaluator.Expression;

public interface Operator {
    public <Type> Type calculate(Expression left, Expression right);
}
