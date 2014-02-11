package evaluator;

import evaluator.Number;
import evaluator.Number;

public class Operation implements Expression{
    private Expression left;
    private Expression right;
    private Symbol symbol;
    
    public Operation(String symbol, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        this.symbol = new SymbolDictionary().get(symbol);
    }

    public int getResult() {
        return symbol.calculate(left, right);
    }
    
}
