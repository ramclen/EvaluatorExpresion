package evaluator.parsers;

import evaluator.Expression;
import evaluator.OperatorDictionary;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;

public class ExpressionTokenizer implements Enumeration<ExpressionToken>, Iterable<ExpressionToken> {

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
    public ExpressionToken nextElement() {
        String string = stringTokenizer.nextToken();
        if (dictionary.containsKey(string))
            return new OperatorToken(string);
        return new ConstantToken<>(string);
    }

    @Override
    public Iterator<ExpressionToken> iterator() {
        return new Iterator<ExpressionToken>() {
            @Override
            public boolean hasNext() {
                return hasMoreElements();
            }

            @Override
            public ExpressionToken next() {
                return nextElement();
            }

            @Override
            public void remove() {

            }
        };
    }
}
