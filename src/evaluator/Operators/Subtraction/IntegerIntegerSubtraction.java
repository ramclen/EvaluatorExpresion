package evaluator.Operators.Subtraction;

import evaluator.Operators.Operator;

public class IntegerIntegerSubtraction implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left - (Integer)right;
    }

}
