package evaluator.parsers.tokenizer;

import evaluator.OperatorDictionary;
import evaluator.parsers.tokenizer.tokens.ConstantToken;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConstantTokenizer implements ExpressionTokenizer<ConstantToken>{

    private Queue<String> constants;

    public ConstantTokenizer(String string) {
        constants = new ConcurrentLinkedQueue<>();
        extractConstants(string);
    }

    private void extractConstants(String string) {
        for (int index = 0; index < string.length(); index++) {
            int nextPosition = getNextOperatorPosition(string, index);
            constants.add(string.substring(index, nextPosition));
            index=nextPosition;
        }
    }

    private int getNextOperatorPosition(String string, int index) {
        for (int nextIndex = index; nextIndex < string.length(); nextIndex++)
            if (isOperator(string, nextIndex))
                return nextIndex;
        return string.length();
    }

    private boolean isOperator(String string, int index) {
        return new OperatorDictionary().containsKey(String.valueOf(string.charAt(index)));
    }


    @Override
    public boolean hasMoreElements() {
        return !constants.isEmpty();
    }

    @Override
    public ConstantToken nextElement() {
        return new ConstantToken(constants.poll());
    }
}
