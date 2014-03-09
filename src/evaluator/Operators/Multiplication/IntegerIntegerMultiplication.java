package evaluator.operators.multiplication;

import evaluator.operators.Operator;

public class IntegerIntegerMultiplication implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left * (Integer)right;
    }

}
