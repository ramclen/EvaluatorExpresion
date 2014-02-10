package evaluator;

import evaluator.Number;
import evaluator.Number;

public class Operation implements Expresion{
    private Number left;
    private Number right;

    public Operation(String symbol, Number left, Number right) {
        this.left = left;
        this.right = right;
    }

    public int getResult() {
        return left.getResult() + right.getResult();
    }
    
    
    
}
