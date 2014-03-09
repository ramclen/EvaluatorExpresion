package evaluator.operators.Division;

import evaluator.operators.Operator;

public class IntegerDoubleDivision implements Operator {
    @Override
    public Object calculate(Object left, Object right) {
        return (Integer)left / (Double)right;
    }

}
