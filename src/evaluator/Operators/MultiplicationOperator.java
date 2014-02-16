package evaluator.Operators;

import evaluator.Expression;

public class MultiplicationOperator implements Operator{
    
    @Override
    public <Type> Type calculate(Expression left, Expression right) {
        Integer result = (int) left.getResult() * (int) right.getResult();
        return (Type) result;
    }
    
}
