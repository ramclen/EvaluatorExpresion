package evaluator.Operators.Subtraction;

import evaluator.Operators.Operator;

public class DoubleIntegerSubtraction implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left - (Integer)right;
    }


}
