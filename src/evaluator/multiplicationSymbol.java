package evaluator;

public class multiplicationSymbol implements Symbol{
    
    @Override
    public int calculate(Expresion left, Expresion right) {
        return left.getResult() * right.getResult();
    }
}
