package evaluator.Operators;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.Value;

class DivisionOperator implements Operator{

    @Override
    public Value calculate(Expression left, Expression right) {
        int result = (int) left.getResult() / (int) right.getResult();
        return new Value(result);
    }

}
