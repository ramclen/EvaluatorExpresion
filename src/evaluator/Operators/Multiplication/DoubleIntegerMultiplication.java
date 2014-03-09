package evaluator.operators.multiplication;

import evaluator.operators.Operator;

public class DoubleIntegerMultiplication implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left * (Integer)right;
    }

}
