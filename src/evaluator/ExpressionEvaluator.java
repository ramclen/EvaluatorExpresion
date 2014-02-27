package evaluator;

import java.lang.reflect.Type;

class ExpressionEvaluator {

    public Type evaluate(String string) {
        return  new ExpressionParser().toExpression(string).getResult();
    }

}
