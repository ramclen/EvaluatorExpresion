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
        ParserStrategy strategy = new ShuntingYardStrategy();
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

        Assert.assertEquals(16, strategy.run(expressions,
                                             operators).getResult());
    }

    private Stack<Expression> createTwoChangesOperatorExpressionStack() {
        return buildStack(Constant::new, 1,2,3,1,3,3);
    }

    private <Type, Value> Stack<Type> buildStack(Builder<Type, Value> builder, Value...values) {
        Stack<Type> stack = new Stack<>();
        for (Value value : values)
            stack.add(builder.build(value));
        return stack;
    }

    private interface  Builder <Type, Value>{
        public Type build(Value value);
    }

}
