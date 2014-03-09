package evaluator;

import java.util.HashMap;

public class OperatorDictionary extends HashMap<String, String>{

    {
            put("+", "sum");
            put("-", "subtraction");
            put("*", "multiplication");
            put(":", "Division");
            put("<", "LessThan");
    }


}
