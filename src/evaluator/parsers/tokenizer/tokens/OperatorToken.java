package evaluator.parsers.tokenizer.tokens;

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
