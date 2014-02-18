package evaluator.Operators.Substraction;

import evaluator.Operators.Operator;

public class DoubleIntegerSubstraction implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left + (Integer)right;
    }


}
