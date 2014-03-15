package evaluator.parsers;

import evaluator.Expression;
import evaluator.parsers.tokenizer.tokens.OperatorToken;

import java.util.Queue;
import java.util.Stack;

public class ShuntingYardStrategy implements ParserStrategy{

    private ExpressionFactory expressionFactory;
    private Stack<Expression> expressions;
    private Stack<OperatorToken> operators;

    public ShuntingYardStrategy() {
        expressions = new Stack<>();
        operators = new Stack<>();
        expressionFactory = new ExpressionFactory();
    }

    @Override
    public Expression parse(Queue<Expression> expressionsQueue, Queue<OperatorToken> operatorsQueue) {
        while (!operatorsQueue.isEmpty())
            if(!successfulShunting(expressionsQueue, operatorsQueue))
                expressions.add(expressionFactory.buildExpression(getProblematicExpressions(), getProblematicOperators()));
        return expressionFactory.buildExpression(expressions, operators);
    }

    private boolean successfulShunting(Queue<Expression> expressionsQueue, Queue<OperatorToken> operatorsQueue) {
        shuntingExpressions(expressionsQueue);
        return shuntingOperator(operatorsQueue);
    }

    private Stack<Expression> getProblematicExpressions() {
        Stack<Expression> expressions = new Stack<>();
        expressions.add(this.expressions.pop());
        expressions.add(this.expressions.pop());
        return expressions;
    }

    private Stack<OperatorToken> getProblematicOperators() {
        Stack<OperatorToken> operators = new Stack<>();
        operators.add(this.operators.pop());
        return operators;
    }

    private void shuntingExpressions(Queue<Expression> expressionsQueue) {
        if(expressions.isEmpty())
            expressions.push(expressionsQueue.poll());
        expressions.push(expressionsQueue.poll());
    }

    private boolean shuntingOperator(Queue<OperatorToken> operatorsQueue) {
        boolean shuntingResult = !highPriorityOperator(operatorsQueue.peek());
        operators.push(operatorsQueue.poll());
        return shuntingResult;
    }

    private boolean highPriorityOperator(OperatorToken operator) {
        if(!operators.isEmpty())
            return new OperatorRules().minnorPriority(operators.peek(), operator);
        return false;
    }

}
