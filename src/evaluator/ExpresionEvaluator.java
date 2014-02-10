package evaluator;


class ExpresionEvaluator {

    public ExpresionEvaluator() {
    }
    
    public int execute(String expression) {
        return new Number(expression).getResult();
    }
    
}
