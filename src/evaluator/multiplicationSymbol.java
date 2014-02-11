package evaluator;

public class multiplicationSymbol implements Symbol{
    
    @Override
    public int calculate(Expression left, Expression right) {
        return left.getResult() * right.getResult();
    }
}
