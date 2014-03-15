package evaluator.parsers;

import evaluator.Expression;
import evaluator.parsers.tokenizer.tokens.OperatorToken;

import java.util.Queue;
import java.util.Stack;

public interface ParserStrategy {
    public Expression parse(Queue<Expression> expressions, Queue<OperatorToken> operators);
}
