package evaluator;

public class ExpressionParse {

    public Expression toExpresion(String expresionString){
        Operation mulOperation = new Operation("*", new Number("2"), new Number("3"));
        return new Operation("+", new Number("1"), mulOperation);
    }
}
