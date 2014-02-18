package evaluator;

import evaluator.Operators.Operator;

public class Operation implements Expression{
    private Expression left;
    private Expression right;
    private Operator operator;
    
    public Operation(String symbol, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        this.operator = new OperatorFactory().create(symbol, left.getResult(), right.getResult());
    }
    
    @Override
    public <Type>Type getResult() {
        return (Type) operator.calculate(left.getResult(), right.getResult());
    }
    
}
