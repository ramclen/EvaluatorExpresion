package evaluator;


import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionParse {
    private final Character[] operators = {'*',':','+','-'};
    
    public Expression toExpresion(String expresionString){
        ArrayList <Character> operatorList = new ArrayList<>();
        ArrayList<Expression> expresionList = new ArrayList<>();
        for(Character character : expresionString.toCharArray()) {
            if (isConstant(character)) {
                expresionList.add(new Constant(Integer.valueOf(character)));
                if(haveLowerPriority(operatorList.get(operatorList.size() - 1), operatorList.get(operatorList.size() - 2))) {
                    Expression expresion = getExpresion(expresionList, operatorList);
                    expresionList.clear();
                    operatorList.clear();
                    expresionList.add(expresion);
                }
            }else{
                operatorList.add(character);
            }
        }
        return getExpresion(expresionList, operatorList);
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

    private Expression getExpresion(List<Expression> expresionList, List<Character> operatorList) {
        if (operatorList.size()!=0) {
            return new Operation(operatorList.get(operatorList.size() - 1).toString(),
                    expresionList.get(expresionList.size() - 1),
                    getExpresion(expresionList.subList(0,expresionList.size() - 1), operatorList.subList(0, operatorList.size() - 1)));

        }
        return expresionList.get(0);



    }


}
