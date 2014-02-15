package evaluator;

public class ExpressionParse {
    private final String[] operators = {"*",":","+","-"};
    
    public Expression toExpresion(String expresionString){
        OperatorDictionary dictionary = new OperatorDictionary();
        for (int i = 0; i < operators.length; i+=2) {
            while(expresionString.contains(operators[i]) || expresionString.contains(operators[i+1]))
                return null;
        }
        return null;
    }
}
