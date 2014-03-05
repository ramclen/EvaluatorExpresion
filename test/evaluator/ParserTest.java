package evaluator;

import evaluator.parsers.ConstantToken;
import evaluator.parsers.ExpressionToken;
import evaluator.parsers.OperatorToken;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import java.util.Stack;

public class ParserTest {

    public void tokenParserTest() {


    }

    @Test
    public void StringsParserTest() {
        Stack<ExpressionToken> stackResult = new StringsParser().parse("3+2");
        Stack<ExpressionToken> stackExpected = new Stack<>();
        stackExpected.push(new ConstantToken(3));
        stackExpected.push(new OperatorToken(+));
        stackExpected.push(new ConstantToken(2));
        assertEquals(stackExpected, stackResult);
    }
}
