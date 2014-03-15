package evaluator.parsers;

import evaluator.Expression;
import evaluator.parsers.tokenizer.tokens.OperatorToken;

import java.util.Queue;

public class Parser {
    private final ParserStrategy strategy;
    
    public Parser(ParserStrategy strategy) {
        this.strategy = strategy;
    }

    public Expression parse(Queue<Expression> expressionsQueue, Queue<OperatorToken> operatorsQueue) {
        return strategy.parse(expressionsQueue,operatorsQueue);
    }
}

