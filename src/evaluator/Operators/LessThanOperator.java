package evaluator.Operators;

import evaluator.Expression;

public class LessThanOperator <Type> implements Operator{

    @Override
    public <Type> Type calculate(Expression left, Expression right) {
        Boolean result = (int) left.getResult() < (int) right.getResult();
        return (Type) result;
    }

}
