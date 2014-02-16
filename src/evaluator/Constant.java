package evaluator;

public class Constant <Type> implements  Expression{
    private Value value;

    public Constant(Type value) {
        this.value = new Value(value);
    }
    
    @Override
    public Value getResult() {
        return value;
    }
}
