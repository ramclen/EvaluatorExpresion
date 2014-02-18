package evaluator.Operators.Division;

import evaluator.Operators.Operator;

public class IntegerIntegerDivision implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left / (Integer)right;
    }

}
