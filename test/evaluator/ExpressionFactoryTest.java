package evaluator;

import evaluator.parsers.ExpressionFactory;
import evaluator.parsers.tokenizer.tokens.OperatorToken;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Stack;

public class ExpressionFactoryTest {

    @Test
    public void expressionFactoryTest() {
        Stack<Expression> expressions = new Stack<>();
        Stack<OperatorToken> operators = new Stack<>();
        expressions.add(new Constant<>(1));
        expressions.add(new Constant<>(2));
        expressions.add(new Constant<>(3));
        expressions.add(new Constant<>(3));
        operators.add(new OperatorToken("+"));
        operators.add(new OperatorToken("*"));
        operators.add(new OperatorToken("*"));
        Assert.assertEquals(19, new ExpressionFactory().buildExpression(expressions,operators).getResult());
    }
}
