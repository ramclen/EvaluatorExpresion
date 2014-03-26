package evaluator.parsers;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.parsers.tokenizer.tokens.OperatorToken;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Stack;

public class ShuntingYardStrategyTest {

    @Test
    public void shuntingYardTest() {
        ParserStrategy strategy = new ShuntingYardStrategy(new ExpressionFactory());
        Stack<Expression> expressions = new Stack<>();
        Stack<OperatorToken> operators = new Stack<>();
        expressions.add(new Constant<>(1));
        expressions.add(new Constant<>(2));
        expressions.add(new Constant<>(3));
        expressions.add(new Constant<>(1));
        expressions.add(new Constant<>(3));
        expressions.add(new Constant<>(3));
        operators.add(new OperatorToken("+"));
        operators.add(new OperatorToken("*"));
        operators.add(new OperatorToken("+"));
        operators.add(new OperatorToken("*"));
        operators.add(new OperatorToken("*"));

        Assert.assertEquals(16, strategy.run(expressions, operators).getResult());
    }

    @Test
    public void oneOperationParenthesisTest() {
        ParserStrategy strategy = new ShuntingYardStrategy(new ExpressionFactory());
        Stack<Expression> expressions = new Stack<>();
        Stack<OperatorToken> operators = new Stack<>();
        expressions.add(new Constant<>(1));
        expressions.add(new Constant<>(2));
        operators.add(new OperatorToken(")"));
        operators.add(new OperatorToken("+"));
        operators.add(new OperatorToken("("));

        Assert.assertEquals(3, strategy.run(expressions, operators).getResult());
    }

    @Test
    public void twoOperationsWithParenthesisTest() {
        ParserStrategy strategy = new ShuntingYardStrategy(new ExpressionFactory());
        Stack<Expression> expressions = new Stack<>();
        Stack<OperatorToken> operators = new Stack<>();
        expressions.add(new Constant<>(1));
        expressions.add(new Constant<>(2));
        expressions.add(new Constant<>(3));
        operators.add(new OperatorToken(")"));
        operators.add(new OperatorToken("+"));
        operators.add(new OperatorToken("("));
        operators.add(new OperatorToken("-"));

        Assert.assertEquals(0, strategy.run(expressions, operators).getResult());
    }

}
