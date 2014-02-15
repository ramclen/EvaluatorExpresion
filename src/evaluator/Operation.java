package evaluator;

import evaluator.Number;
import evaluator.Number;

public class Operation implements Expression{
    private Expression left;
    private Expression right;
    private Operator symbol;
    
    public Operation(String symbol, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        this.symbol = new OperatorDictionary().get(symbol);
    }

    public int getResult() {
        return symbol.calculate(left, right);
    }
    
}
