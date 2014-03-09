package evaluator.operators.multiplication;

import evaluator.operators.Operator;

public class DoubleDoubleMultiplication implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left * (Double)right;
    }

}
