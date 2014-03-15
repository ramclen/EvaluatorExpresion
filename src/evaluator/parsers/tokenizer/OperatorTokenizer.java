package evaluator.parsers.tokenizer;

import evaluator.OperatorDictionary;
import evaluator.parsers.tokenizer.tokens.OperatorToken;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OperatorTokenizer implements ExpressionTokenizer<OperatorToken> {
    private Queue<String> operators;

    public OperatorTokenizer(String string) {
        operators = new ConcurrentLinkedQueue<>();
        extractOperators(string);
    }

    private void extractOperators(String string) {
        OperatorDictionary dictionary = new OperatorDictionary();
        for (String slice : string.split(""))
            if (dictionary.containsKey(slice))
                operators.add(slice);
    }

    @Override
    public boolean hasMoreElements() {
        return !operators.isEmpty();
    }

    @Override
    public OperatorToken nextElement() {
        return new OperatorToken(operators.poll());
    }
}
