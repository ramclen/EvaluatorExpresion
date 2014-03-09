package evaluator.operators.subtraction;

import evaluator.operators.Operator;

public class DoubleIntegerSubtraction implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left - (Integer)right;
    }


}
