package evaluator.Operators.LessThan;

import evaluator.Operators.Operator;

public class IntegerIntegerLessThan implements Operator{

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer) left < (Integer) right;
    }

}
