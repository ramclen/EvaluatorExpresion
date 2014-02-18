package evaluator.Operators.Multiplication;

import evaluator.Operators.Operator;

public class DoubleIntegerMultiplication implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left * (Integer)right;
    }

}
