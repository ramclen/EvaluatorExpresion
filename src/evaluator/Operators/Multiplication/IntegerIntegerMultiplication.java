package evaluator.Operators.Multiplication;

import evaluator.Operators.Operator;

public class IntegerIntegerMultiplication implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left * (Integer)right;
    }

}
