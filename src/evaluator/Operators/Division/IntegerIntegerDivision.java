package evaluator.operators.division;

import evaluator.operators.Operator;

public class IntegerIntegerDivision implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left / (Integer)right;
    }

}
