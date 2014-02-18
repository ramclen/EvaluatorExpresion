package evaluator.Operators.Substraction;

import evaluator.Operators.Operator;

public class DoubleDoubleSubstraction implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left + (Double)right;
    }

}
