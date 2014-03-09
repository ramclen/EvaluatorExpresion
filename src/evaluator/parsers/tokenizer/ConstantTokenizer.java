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
        int lastIndex=0;
        for (int index = 0; index < string.length(); index++)
            if (isOperator(string, index)) {
                constants.add(string.substring(lastIndex, index));
                lastIndex = index+1;
            }
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
