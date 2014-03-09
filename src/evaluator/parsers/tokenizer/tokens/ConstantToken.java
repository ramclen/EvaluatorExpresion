package evaluator.parsers.tokenizer.tokens;

public class ConstantToken <Type> implements ExpressionToken{

    private final Type value;

    public ConstantToken(Type constant) {
        this.value = constant;
    }

    @Override
    public Object getValue() {
        return value;
    }
}
