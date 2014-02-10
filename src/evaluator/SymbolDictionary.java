package evaluator;

import java.util.HashMap;

public class SymbolDictionary extends HashMap<String, Symbol>{
    

    public SymbolDictionary() {
        super();
        put("*", new multiplicationSymbol());
        put("+", new SumSymbol());
    }
}
