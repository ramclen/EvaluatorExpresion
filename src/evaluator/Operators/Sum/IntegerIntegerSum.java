package evaluator.Operators.Sum;

import evaluator.Expression;
import evaluator.Operators.Operator;

public class IntegerIntegerSum implements Operator{

    @Override
    public Object calculate(Object left, Object right) {
        return (Integer) left + (Integer) right;
    }
    
}
