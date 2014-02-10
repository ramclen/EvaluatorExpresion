package evaluator;

public class SumSymbol implements Symbol{

    @Override
    public int calculate(Expresion left, Expresion right) {
        return left.getResult() + right.getResult();
    }
    
}
