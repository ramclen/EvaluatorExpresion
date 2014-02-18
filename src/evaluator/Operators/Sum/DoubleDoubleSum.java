package evaluator.Operators.Sum;

import evaluator.Operators.Operator;

public class DoubleDoubleSum implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left + (Double)right;
    }

}
