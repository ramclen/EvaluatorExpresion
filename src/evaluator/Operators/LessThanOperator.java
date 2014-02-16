package evaluator.Operators;

import evaluator.Expression;
import evaluator.Value;

public class LessThanOperator <Type> implements Operator{

    @Override
    public Value calculate(Expression left, Expression right) {
        Boolean result = (int) left.getResult() < (int) right.getResult();
        return new Value(result);
    }

}
