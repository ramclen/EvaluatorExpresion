package evaluator;

import evaluator.parsers.*;
import org.junit.Test;
import java.util.Stack;
import org.junit.Assert;

public class ParserTest {

    @Test
    public void tokenizerTest() {
        Assert.assertEquals(1, 0);
        ExpressionTokenizer tokenizer = new ExpressionTokenizer("3+2");
        Stack<ExpressionToken> stackResult= new Stack<>();
        Stack<ExpressionToken> stackExpected = new Stack<>();
        stackExpected.push(new ConstantToken<>("3"));
        stackExpected.push(new OperatorToken("+"));
        stackExpected.push(new ConstantToken<>("2"));
        for (ExpressionToken token: tokenizer) {
            stackResult.push(token);
        }
        Assert.assertEquals(stackExpected, stackResult);
    }

    @Test
    public void parserTest() {
        Expression expressionResult = new Parser().parse("3+2");
        Expression expressionExpected = new Operation("+", new Constant<>(3), new Constant<>(2));
        Assert.assertEquals(expressionExpected, expressionResult);
    }
}
