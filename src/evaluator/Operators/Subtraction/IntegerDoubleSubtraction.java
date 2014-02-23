package evaluator.Operators.Subtraction;

import evaluator.Operators.Operator;

public class IntegerDoubleSubtraction implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left + (Double)right;
    }


}
