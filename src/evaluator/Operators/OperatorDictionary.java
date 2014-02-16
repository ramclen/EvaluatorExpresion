package evaluator.Operators;

import java.util.HashMap;

public class OperatorDictionary extends HashMap<String, Operator>{
    

    public OperatorDictionary() {
        super();
        put("*", new MultiplicationOperator());
        put(":", new DivisionOperator());
        put("+", new SumOperator());
        put("-", new SubtractionOperator());
    }
}
