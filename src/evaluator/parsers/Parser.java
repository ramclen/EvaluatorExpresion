package evaluator.parsers;

import evaluator.Expression;
import evaluator.parsers.tokenizer.tokens.OperatorToken;

import java.util.Queue;
import java.util.Stack;

public class Parser {
    private final ParserStrategy strategy;
    
    public Parser(ParserStrategy strategy) {
        this.strategy = strategy;
    }

    public Expression parse(Stack<Expression> expressionsQueue, Stack<OperatorToken> operatorsQueue) {
        return strategy.run(expressionsQueue, operatorsQueue);
    }
}

