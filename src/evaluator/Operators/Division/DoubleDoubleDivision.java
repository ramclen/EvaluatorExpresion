package evaluator.operators.division;

import evaluator.operators.Operator;

public class DoubleDoubleDivision implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left / (Double)right;
    }

}
