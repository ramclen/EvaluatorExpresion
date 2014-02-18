package evaluator.Operators.Substraction;

import evaluator.Operators.Operator;

public class IntegerDoubleSubstraction implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left + (Double)right;
    }


}
