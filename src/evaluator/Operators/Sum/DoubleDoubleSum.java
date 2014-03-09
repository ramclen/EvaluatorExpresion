package evaluator.operators.sum;

import evaluator.operators.Operator;

public class DoubleDoubleSum implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left + (Double)right;
    }

}
