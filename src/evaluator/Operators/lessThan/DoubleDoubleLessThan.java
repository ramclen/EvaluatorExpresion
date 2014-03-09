package evaluator.operators.lessThan;

import evaluator.operators.Operator;

public class DoubleDoubleLessThan implements Operator{

    @Override
    public Object calculate(Object left, Object right) {
        return (Double) left < (Double) right;
    }

}
