package evaluator;

import evaluator.parsers.*;
import evaluator.parsers.tokenizer.tokens.ConstantToken;
import evaluator.parsers.tokenizer.ConstantTokenizer;
import evaluator.parsers.tokenizer.OperationTokenizer;
import evaluator.parsers.tokenizer.tokens.OperatorToken;
import org.junit.Test;
import java.util.Stack;
import org.junit.Assert;

public class ParserTest {

    @Test
    public void constantTokenizerTest() {
        ConstantTokenizer tokenizer = new ConstantTokenizer("3+2-4+5*6");
        Stack<ConstantToken> stackExpected = new Stack();
        stackExpected.push(new ConstantToken<>("6"));
        stackExpected.push(new ConstantToken<>("5"));
        stackExpected.push(new ConstantToken<>("4"));
        stackExpected.push(new ConstantToken<>("2"));
        stackExpected.push(new ConstantToken<>("3"));

        Assert.assertEquals(true, tokenizer.hasMoreElements());
        while (tokenizer.hasMoreElements())
            Assert.assertEquals(stackExpected.pop().getValue(), tokenizer.nextElement().getValue());
    }

    @Test
    public void operatorTokenizerTest() {
        OperationTokenizer tokenizer = new OperationTokenizer("3+2-3*5");
        Stack<OperatorToken> stackExpected = new Stack();
        stackExpected.push(new OperatorToken("*"));
        stackExpected.push(new OperatorToken("-"));
        stackExpected.push(new OperatorToken("+"));
        Assert.assertEquals(true, tokenizer.hasMoreElements());
        while (tokenizer.hasMoreElements())
            Assert.assertEquals(stackExpected.pop().getValue(), tokenizer.nextElement().getValue());

    }

    public void parserTest() {
        Expression expressionResult = new Parser().parse("3+2");
        Expression expressionExpected = new Operation("+", new Constant<>(3), new Constant<>(2));
        Assert.assertEquals(expressionExpected, expressionResult);
    }
}
