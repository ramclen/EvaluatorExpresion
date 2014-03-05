package evaluator.parsers;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.Operation;
import evaluator.OperatorDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionParser {
    private ArrayList<String> operatorList;
    private ArrayList<Expression> expressionList;
    private final String[] operators = {"*", ":","+", "-"};
    private OperatorDictionary operatorDictionary = new OperatorDictionary();

    public ExpressionParser() {
        operatorList = new ArrayList<>();
        expressionList = new ArrayList<>();
    }

    public Expression toExpression(String expressionString){
        clearLists();
        for (String value : toStringArray(expressionString))
            addNewValue(operatorList, expressionList, value);
        return buildExpression(expressionList, operatorList);
    }

    private void clearLists() {
        operatorList.clear();
        expressionList.clear();
    }

    private String[] toStringArray(String string) {
        return Arrays.copyOfRange(string.split(""), 1, string.split("").length);
    }

    private void addNewValue(ArrayList<String> operatorList, ArrayList<Expression> expressionList, String value) {
        if(isConstant(value)) {
            expressionList.add(new Constant(Integer.valueOf(value)));
            if(haveOperatorConflict(operatorList))
                buildExpression(expressionList, operatorList);
        }else
            operatorList.add(value);
    }

    private boolean isConstant(String symbol) {
        return !operatorDictionary.containsKey(symbol);
    }

    private boolean haveOperatorConflict(List<String> operatorList) {
        if (operatorList.size()>1)
            return !haveLowerPriority(getLastOne(operatorList), getSecondLastOne(operatorList));
        return false;
    }

    public Expression buildExpression(List<Expression> expressionList, List<String> operatorList) {
        while(operatorList.size()!=0)
            updateList(expressionList, operatorList, getNextOperation(operatorList,expressionList));
        return expressionList.get(0);
    }


    private boolean haveLowerPriority(String lower, String higher) {
        return getPriority(lower) > getPriority(higher);
    }

    private void updateList(List<Expression> expressionList, List<String> operatorList, Operation operation) {
        removeUsed(expressionList, operatorList, operation);
        expressionList.add(operation);
    }

    private Operation getNextOperation(List<String> operatorList, List<Expression> expressionList){
        if (haveOperatorConflict(operatorList))
            return new Operation(getLastOne(operatorList), getLastOne(expressionList), getSecondLastOne(expressionList));
        return new Operation(operatorList.get(0), expressionList.get(0), expressionList.get(1));
    }

    private int getPriority(String symbol) {
        for (int index = 0; index<operators.length; index++)
            if (operators[index].equals(symbol)) return index;
        return 999999;
    }

    private void removeUsed(List<Expression> expressionList, List<String> operatorList, Operation operation) {
        expressionList.remove(operation.getLeft());
        expressionList.remove(operation.getRight());
        operatorList.remove(operation.getSymbol());
    }

    private <Type> Type getLastOne(List<Type> list){
        return list.get(list.size()-1);
    }

    private <Type> Type getSecondLastOne(List<Type> list){
        return list.get(list.size()-2);
    }

}
