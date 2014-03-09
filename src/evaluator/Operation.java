package evaluator;

import evaluator.operators.Operator;

public class Operation implements Expression{
    private final String symbol;
    private Expression left;
    private Expression right;
    private Operator operator;

    public Operation(String symbol, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        this.symbol = symbol;
        this.operator = new OperatorFactory().create(symbol, left.getResult(), right.getResult());
    }

    public Operator getOperator() {
        return operator;
    }

    public Expression getRight() {
        return right;
    }

    public String getSymbol() {
        return symbol;
    }

    public Expression getLeft() {
        return left;
    }

    @Override
    public <Type>Type getResult() {
        return (Type) operator.calculate(left.getResult(), right.getResult());
    }
    
}
