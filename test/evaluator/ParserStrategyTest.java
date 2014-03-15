package evaluator;

import evaluator.parsers.ParserStrategy;
import evaluator.parsers.ShuntingYardStrategy;
import evaluator.parsers.tokenizer.tokens.OperatorToken;
import junit.framework.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ParserStrategyTest {

    @Test
    public void shuntingYardTest() {
        ParserStrategy strategy = new ShuntingYardStrategy();
        Queue<Expression> expressions = new LinkedList<>();
        Queue<OperatorToken> operators = new LinkedList<>();
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

        Assert.assertEquals(16, strategy.parse(expressions,operators).getResult());

    }

}
