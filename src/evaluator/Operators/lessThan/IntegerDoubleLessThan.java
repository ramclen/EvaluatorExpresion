package evaluator.Operators.lessThan;

import evaluator.Operators.Operator;

public class IntegerDoubleLessThan implements Operator{

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer) left < (Double) right;
    }

}
