package evaluator;

public class multiplicationOperator implements Operator{
    
    @Override
    public int calculate(Expression left, Expression right) {
        return left.getResult() * right.getResult();
    }
}
