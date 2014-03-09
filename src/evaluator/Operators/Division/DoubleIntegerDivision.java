package evaluator.operators.division;

import evaluator.operators.Operator;

public class DoubleIntegerDivision implements Operator {
    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left / (Integer)right;
    }

}
