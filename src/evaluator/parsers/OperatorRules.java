package evaluator.parsers;

import evaluator.parsers.tokenizer.tokens.OperatorToken;

import java.util.LinkedHashMap;

public class OperatorRules extends LinkedHashMap<String, Integer>{
    {
        put("+", 1);
        put("*", 0);
    }

    public boolean minnorPriority(String minnor, String major) {
        return !(minnor == null || major == null) && get(minnor) > get(major);
    }

    public boolean minnorPriority(OperatorToken minnor, OperatorToken major) {
        return !(minnor == null || major == null) && get(minnor.getValue()) > get(major.getValue());
    }


}
