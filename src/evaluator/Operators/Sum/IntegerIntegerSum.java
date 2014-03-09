package evaluator.operators.sum;

import evaluator.operators.Operator;

public class IntegerIntegerSum implements Operator{

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer) left + (Integer) right;
    }
    
}
