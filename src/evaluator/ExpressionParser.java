package evaluator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionParser {
    private final String[] operators = {"*", ":","+", "-"};
    
    public Expression toExpression(String expressionString){
        ArrayList<String> operatorList = new ArrayList<>();
        ArrayList<Expression> expressionList = new ArrayList<>();

        for (String value : toStringArray(expressionString)) {
            if(isConstant(value)) {
                expressionList.add(new Constant(Integer.valueOf(value)));
                if(haveOperatorConflict(operatorList)) {
                    Expression expression = getExpression(expressionList, operatorList);
                    expressionList.clear();
                    operatorList.clear();
                    expressionList.add(expression);
                }
            }
            else
                operatorList.add(value);
        }
        return getExpression(expressionList,operatorList);
    }

    private boolean haveOperatorConflict(List<String> operatorList) {
        if (operatorList.size()>1)
            return !haveLowerPriority(operatorList.get(operatorList.size()-1), operatorList.get(operatorList.size()-2));
        return false;
    }


    private String[] toStringArray(String string) {
        return Arrays.copyOfRange(string.split(""), 1, string.split("").length);
    }

    private boolean isConstant(String character) {
        for (String symbol : operators)
            if (character.equals(symbol.toString())) return false;
        return true;
    }

    private boolean haveLowerPriority(String lower, String higher) {
        return getPriority(lower) > getPriority(higher);
    }

    private int getPriority(String operator) {
        for (int index = 0; index<operators.length; index++)
            if (operators[index].equals(operator)) return index;
        return 999999;
    }

    public Expression getExpression(List<Expression> expressionList, List<String> operatorList) {
        while(operatorList.size()!=0){
            if (haveOperatorConflict(operatorList)) {
                Operation operation = new Operation(operatorList.get(operatorList.size() - 1), expressionList.get(expressionList.size() - 1), expressionList.get(expressionList.size() - 2));
                expressionList.remove(expressionList.size() - 1);
                expressionList.remove(expressionList.size() - 1);
                operatorList.remove(operatorList.size()-1);
                expressionList.add(operation);
            }
            Operation operation = new Operation(operatorList.get(0), expressionList.get(0), expressionList.get(1));
            expressionList.remove(0);
            expressionList.remove(0);
            operatorList.remove(0);
            expressionList.add(operation);

        }
        return expressionList.get(0);

    }


}
