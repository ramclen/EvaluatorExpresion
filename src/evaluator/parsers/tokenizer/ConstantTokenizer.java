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
        List<Integer> positionList = getOperatorsPosition(string);
        int firstIndex = 0;
        for (Integer lastIndex : positionList) {
            constants.add(string.substring(firstIndex, lastIndex));
            firstIndex = lastIndex+1;
        }
    }

    private List<Integer> getOperatorsPosition(String string) {
        List<Integer> positions = new LinkedList<>();
        findAndGetSymbolsPosition(string, positions);
        return positions;
    }

    private void findAndGetSymbolsPosition(String string, List<Integer> positions) {
        for (String symbol : new OperatorDictionary().keySet())
            if (string.contains(symbol))
                positions.addAll(getSymbolPositions(string, symbol));
        Collections.sort(positions);
    }

    private List<Integer> getSymbolPositions(String string, String symbol) {
        Stack<Integer> positions = new Stack<>();
        for (String slice : string.split("\\" + symbol))
            putNewPosition(positions, slice);
        return positions.subList(0,positions.size()-2);
    }

    private void putNewPosition(Stack<Integer> positions, String slice) {
        if (positions.isEmpty())
            positions.push(slice.length());
        else
            positions.push(positions.peek() + slice.length()+1);
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
