package evaluator;

public class Constant <Type> implements  Expression{
    private Type value;

    public Constant(Type value) {
        this.value =  value;
    }
    
    @Override
    public Type getResult() {
        return value;
    }
}
