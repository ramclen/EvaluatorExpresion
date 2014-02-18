package evaluator.Operators.Multiplication;

import evaluator.Operators.Operator;

public class DoubleDoubleMultiplication implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left * (Double)right;
    }

}
