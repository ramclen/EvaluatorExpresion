package evaluator.Operators.Subtraction;

import evaluator.Operators.Operator;

public class DoubleDoubleSubtraction implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left + (Double)right;
    }

}
