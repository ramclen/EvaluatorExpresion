package evaluator;

import evaluator.parsers.*;
import org.junit.Test;
import java.util.Stack;
import org.junit.Assert;

public class ParserTest {

    @Test
    public void constantTokenizerTest() {
        ConstantTokenizer tokenizer = new ConstantTokenizer("3+2");
        Stack stackResult = new Stack();
        Stack stackExpected = new Stack();
        stackExpected.push(new ConstantToken<>("3"));
        stackExpected.push(new ConstantToken<>("2"));
        while (tokenizer.hasMoreElements())
            stackResult.push(tokenizer.nextElement());
        Assert.assertEquals(stackExpected, stackResult);
        Assert.assertEquals(stackExpected, stackResult);
    }

    @Test
    public void operatorTokenizerTest() {
        OperationTokenizer tokenizer = new OperationTokenizer("3+2-3");
        Stack<OperatorToken> stackResult = new Stack();
        Stack<OperatorToken> stackExpected = new Stack();
        stackExpected.push(new OperatorToken("-"));
        stackExpected.push(new OperatorToken("+"));
        while (tokenizer.hasMoreElements())
            Assert.assertEquals(stackExpected.pop().getValue(), tokenizer.nextElement().getValue());

    }

    public void parserTest() {
        Expression expressionResult = new Parser().parse("3+2");
        Expression expressionExpected = new Operation("+", new Constant<>(3), new Constant<>(2));
        Assert.assertEquals(expressionExpected, expressionResult);
    }
}
