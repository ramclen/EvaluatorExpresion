package evaluator.Operators.LessThan;

import evaluator.Operators.Operator;

public class DoubleIntegerLessThan implements Operator{

    @Override
    public Object calculate(Object left, Object right) {
        return (Double) left < (Integer) right;
    }

}
