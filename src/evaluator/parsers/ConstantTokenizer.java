package evaluator.parsers;

import evaluator.OperatorDictionary;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConstantTokenizer implements ExpressionTokenizer<ConstantToken>{

    private Queue<String> constants;

    public ConstantTokenizer(String string) {
        constants = new ConcurrentLinkedQueue<>();
        extractConstants(string);
    }

    private void extractConstants(String string) {
        Integer[] vector = getOperatorsPosition(string);
        int firstIndex = 0;
        for (Integer lastIndex : vector) {
            constants.add(string.substring(firstIndex, lastIndex));
            firstIndex = lastIndex;
        }

    }

    private Integer[] getOperatorsPosition(String string) {
        Stack<Integer> positions = new Stack<>();
        for (String symbol : new OperatorDictionary().keySet()) {
            if (string.contains(symbol))
                getSymbolPositions(string, symbol, positions);
        }

        Integer[] positionsArray = new Integer[positions.size()];
        Arrays.sort(positions.toArray(positionsArray));
        return positionsArray;
    }

    private void getSymbolPositions(String string, String symbol, Stack<Integer> positions) {
        for (String slice : string.split("\\" + symbol)) {
            if (!positions.isEmpty())
                positions.push(positions.peek() + slice.length()+1);
            else
                positions.push(slice.length());
        }
        positions.pop();
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
