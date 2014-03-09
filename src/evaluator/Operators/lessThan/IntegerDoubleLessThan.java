package evaluator.operators.LessThan;

import evaluator.operators.Operator;

public class IntegerDoubleLessThan implements Operator{

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer) left < (Double) right;
    }

}
