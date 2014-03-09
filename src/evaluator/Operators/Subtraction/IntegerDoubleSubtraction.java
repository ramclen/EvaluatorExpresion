package evaluator.operators.subtraction;

import evaluator.operators.Operator;

public class IntegerDoubleSubtraction implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left - (Double)right;
    }


}
