package evaluator.operators.sum;

import evaluator.operators.Operator;

public class DoubleIntegerSum implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left + (Integer)right;
    }


}
