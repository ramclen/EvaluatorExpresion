package evaluator.parsers;

import evaluator.OperatorDictionary;

import java.util.Enumeration;
import java.util.StringTokenizer;

public class ExpressionTokenizer implements Enumeration {

    private final StringTokenizer stringTokenizer;
    private final OperatorDictionary dictionary;

    public ExpressionTokenizer(String string) {
        this.stringTokenizer = new StringTokenizer(string);
        this.dictionary = new OperatorDictionary();
    }

    @Override
    public boolean hasMoreElements() {
        return stringTokenizer.hasMoreElements();
    }

    @Override
    public Object nextElement() {
        String string = stringTokenizer.nextToken();
        if (dictionary.containsKey(string))
            return new OperatorToken(string);
        return new ConstantToken<>(string);
    }
}
