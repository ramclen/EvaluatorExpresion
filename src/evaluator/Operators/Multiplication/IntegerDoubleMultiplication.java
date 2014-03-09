package evaluator.operators.multiplication;

import evaluator.operators.Operator;

public class IntegerDoubleMultiplication implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left * (Double)right;
    }

}
