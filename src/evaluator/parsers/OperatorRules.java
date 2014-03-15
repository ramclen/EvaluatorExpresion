package evaluator.parsers;

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
}
