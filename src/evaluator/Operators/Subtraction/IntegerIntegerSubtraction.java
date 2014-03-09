package evaluator.operators.subtraction;

import evaluator.operators.Operator;

public class IntegerIntegerSubtraction implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left - (Integer)right;
    }

}
