package evaluator;

class ExpressionEvaluator {

    public Operation getOperation(String string) {
        return (Operation) new ExpressionParse().toExpresion(string);
    }

}
