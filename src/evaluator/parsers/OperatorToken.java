package evaluator.parsers;

public class OperatorToken implements ExpressionToken {

    private final String symbol;

    public OperatorToken(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public Object getValue() {
        return symbol;
    }
}
