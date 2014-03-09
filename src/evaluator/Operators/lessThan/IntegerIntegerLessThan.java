package evaluator.operators.LessThan;

import evaluator.operators.Operator;

public class IntegerIntegerLessThan implements Operator{

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer) left < (Integer) right;
    }

}
