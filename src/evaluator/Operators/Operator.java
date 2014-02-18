package evaluator.Operators;

import evaluator.Expression;

public interface Operator {
    public Object calculate(Object left, Object right);
}
