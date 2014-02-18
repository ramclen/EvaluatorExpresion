package evaluator.Operators.Sum;

import evaluator.Operators.Operator;

public class IntegerDoubleSum implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left + (Double)right;
    }


}
