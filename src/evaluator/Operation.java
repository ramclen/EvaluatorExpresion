package evaluator;

import evaluator.Operators.OperatorDictionary;
import evaluator.Operators.Operator;

public class Operation <Type>implements Expression{
    private Expression left;
    private Expression right;
    private Operator symbol;
    
    public Operation(String symbol, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        this.symbol = new OperatorDictionary().get(symbol);
    }

    public Value getResult() {
        return symbol.calculate(left, right);
    }
    
}
