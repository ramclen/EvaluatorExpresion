package evaluator.parsers;

import evaluator.parsers.tokenizer.tokens.OperatorToken;

import java.util.LinkedHashMap;

public class OperatorRules extends LinkedHashMap<String, Integer>{
    {
        put("+", 1);
        put("*", 0);
    }

    public boolean minnorPriority(String minnor, String major) {
        if(minnor == null || major == null)
            return false;
        return get(minnor) > get(major);
    }

    public boolean minnorPriority(OperatorToken minnor, OperatorToken major) {
        if(minnor == null || major == null)
            return false;
        return get(minnor.getValue()) > get(major.getValue());
    }


}
