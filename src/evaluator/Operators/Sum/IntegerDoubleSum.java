package evaluator.operators.sum;

import evaluator.operators.Operator;

public class IntegerDoubleSum implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left + (Double)right;
    }


}
