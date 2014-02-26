package evaluator;


import java.util.List;

public class ExpressionParser {
    private final Character[] operators = {'*',':','+','-'};
    
    public Expression toExpression(String expressionString){

    }

    private boolean isConstant(Character character) {
        for (Character symbol : operators)
            if (symbol.equals(character)) return false;
        return true;
    }

    private boolean haveLowerPriority(Character lower, Character higher) {
        return getPriority(lower) > getPriority(higher);
    }

    private int getPriority(Character operator) {
        for (int index = 0; index<operators.length; index++)
            if (operators[index].equals(operator)) return index;
        return 999999;
        
    }

    public Expression getExpression(List<Expression> expressionList, List<Character> operatorList) {
        if (operatorList.size()!=0) {
            return new Operation(operatorList.get(0).toString(),
                    expressionList.get(0),
                    getExpression(expressionList.subList(1, expressionList.size()), operatorList.subList(1, operatorList.size())));

        }

        return expressionList.get(0);



    }


}
