package evaluator;


class ExpressionEvaluator {

    public <Type> Type evaluate(String string) {
        return  new ExpressionParser().toExpression(string).getResult();
    }

}
