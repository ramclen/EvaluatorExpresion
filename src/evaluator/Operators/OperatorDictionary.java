package evaluator;

import java.util.HashMap;

public class OperatorDictionary extends HashMap<String, Operator>{
    

    public OperatorDictionary() {
        super();
        put("*", new multiplicationOperator());
        put(":", new multiplicationOperator());
        put("+", new multiplicationOperator());
        put("-", new SumOperator());
    }
}
