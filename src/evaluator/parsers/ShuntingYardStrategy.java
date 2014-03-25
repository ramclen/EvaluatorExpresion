package evaluator.parsers;

import evaluator.Expression;
import evaluator.parsers.tokenizer.tokens.OperatorToken;

import java.util.Stack;

public class ShuntingYardStrategy implements ParserStrategy{

    private ExpressionFactory expressionFactory;
    private Stack<Expression> expressions;
    private Stack<OperatorToken> operators;

    public ShuntingYardStrategy(ExpressionFactory expressionFactory) {
        expressions = new Stack<>();
        operators = new Stack<>();
        this.expressionFactory = expressionFactory;
    }

    @Override
    public Expression run(Stack<Expression> expressionsQueue, Stack<OperatorToken> operatorsQueue) {
        while (!operatorsQueue.isEmpty()) {
            if (isOpenParenthesis(operatorsQueue.peek()))
                expressions.add(getOperationsInParenthesis(expressionsQueue, operatorsQueue));
            else if(!successfulShunting(expressionsQueue, operatorsQueue))
                expressions.add(expressionFactory.buildExpression(getProblematicExpressions(), getProblematicOperators()));
        }
        return expressionFactory.buildExpression(expressions, operators);
    }

    private Expression getOperationsInParenthesis(Stack<Expression> externalExpressions, Stack<OperatorToken> externalOperators) {
        Stack<Expression> expressions = new Stack<>();
        Stack<OperatorToken> operators = new Stack<>();
        externalOperators.pop();
        int openParenthesis = 1;
        while(openParenthesis != 0) {
            OperatorToken operator = externalOperators.pop();
            if (isOpenParenthesis(operator))
                openParenthesis++;
            else{
                if (isCloseParenthesis(operator))
                    openParenthesis--;

            }
            if(!externalOperators.isEmpty()){
                operators.add(operator);
                expressions.add(externalExpressions.pop());
                expressions.add(externalExpressions.pop());
            }
        }
        return new ShuntingYardStrategy(new ExpressionFactory()).run(expressions, operators);
    }

    private boolean isOpenParenthesis(OperatorToken operatorToken) {
        return (String)operatorToken.getValue() =="(";
    }

    private boolean successfulShunting(Stack<Expression> expressionsQueue, Stack<OperatorToken> operatorsQueue) {
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

    private void shuntingExpressions(Stack<Expression> expressionsQueue) {
        if(expressions.isEmpty())
            expressions.push(expressionsQueue.pop());
        expressions.push(expressionsQueue.pop());
    }

    private boolean shuntingOperator(Stack<OperatorToken> operatorsQueue) {
        boolean shuntingResult = !highPriorityOperator(operatorsQueue.peek());
        operators.push(operatorsQueue.pop());
        return shuntingResult;
    }

    private boolean highPriorityOperator(OperatorToken operator) {
        return !operators.isEmpty() && new OperatorRules().minnorPriority(operators.peek(), operator);
    }

    public boolean isCloseParenthesis(OperatorToken operator){
        return (String)operator.getValue() ==")";
    }
}
