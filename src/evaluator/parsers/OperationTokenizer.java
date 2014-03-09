package evaluator.parsers;

import evaluator.OperatorDictionary;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OperationTokenizer implements ExpressionTokenizer<OperatorToken> {
    private Queue<String> operators;

    public OperationTokenizer(String string) {
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
