package evaluator.Operators;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.Value;

class DivisionOperator implements Operator{

    @Override
    public Value calculate(Expression left, Expression right) {
        int result = (int) left.getResult().getValue() / (int) right.getResult().getValue();
        return new Value(result);
    }

}