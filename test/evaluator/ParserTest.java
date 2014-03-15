package evaluator;

import evaluator.parsers.*;
import evaluator.parsers.tokenizer.OperatorTokenizer;
import evaluator.parsers.tokenizer.tokens.ConstantToken;
import evaluator.parsers.tokenizer.ConstantTokenizer;
import evaluator.parsers.tokenizer.tokens.OperatorToken;
import org.junit.Test;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

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
        OperatorTokenizer tokenizer = new OperatorTokenizer("3+2-3*5");
        Stack<OperatorToken> stackExpected = new Stack();
        stackExpected.push(new OperatorToken("*"));
        stackExpected.push(new OperatorToken("-"));
        stackExpected.push(new OperatorToken("+"));
        Assert.assertEquals(true, tokenizer.hasMoreElements());
        while (tokenizer.hasMoreElements())
            Assert.assertEquals(stackExpected.pop().getValue(), tokenizer.nextElement().getValue());

    }

    @Test
    public void parserTest() {
        Queue<Expression> expressions = new ConcurrentLinkedQueue<>();
        Queue<OperatorToken> operators = new ConcurrentLinkedQueue<>();
        expressions.add(new Constant<>(1));
        expressions.add(new Constant<>(2));
        expressions.add(new Constant<>(3));
        operators.add(new OperatorToken("+"));
        operators.add(new OperatorToken("*"));
        Expression expressionResult = new Parser(new ShuntingYardStrategy()).parse(expressions, operators);
        Assert.assertEquals(7, expressionResult.getResult());
    }
}
