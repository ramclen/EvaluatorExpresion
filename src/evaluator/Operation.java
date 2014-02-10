package evaluator;

import evaluator.Number;
import evaluator.Number;

public class Operation implements Expresion{
    private Expresion left;
    private Expresion right;
    private Symbol symbol;
    
    public Operation(String symbol, Expresion left, Expresion right) {
        this.left = left;
        this.right = right;
        this.symbol = new SymbolDictionary().get(symbol);
    }

    public int getResult() {
        return symbol.calculate(left, right);
    }
    
    
    
}
