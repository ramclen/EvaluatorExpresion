package evaluator;

import java.util.HashMap;

public class OperatorDictionary extends HashMap<String, String>{

    {
            put("+", "Sum");
            put("-", "Subtraction");
            put("*", "Multiplication");
            put(":", "Division");
            put("<", "LessThan");
    }
}
