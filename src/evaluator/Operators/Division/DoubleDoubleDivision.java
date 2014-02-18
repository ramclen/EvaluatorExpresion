package evaluator.Operators.Division;

import evaluator.Operators.Operator;

public class DoubleDoubleDivision implements Operator {

    @Override
    public Object calculate(Object left, Object right) {
        return (Double)left / (Double)right;
    }

}
