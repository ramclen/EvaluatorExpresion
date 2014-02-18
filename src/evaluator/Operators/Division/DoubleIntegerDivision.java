package evaluator.Operators.Division;

import evaluator.Operators.Operator;

public class DoubleIntegerDivision implements Operator {
    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left / (Integer)right;
    }

}
