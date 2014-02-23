package evaluator.Operators.LessThan;

import evaluator.Operators.Operator;

public class DoubleDoubleLessThan implements Operator{

    @Override
    public Object calculate(Object left, Object right) {
        return (Double) left < (Double) right;
    }

}
