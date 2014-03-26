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
    public Expression run(Stack<Expression> externalExpressions, Stack<OperatorToken> externalOperators) {
        while (!externalOperators.isEmpty() && !isCloseParenthesis(externalOperators.peek()))
            if (isOpenParenthesis(externalOperators.peek())) {
                expressions.add(extractExpressionInParenthesis(externalExpressions, externalOperators));
            }else if (!successfulShunting(externalExpressions, externalOperators))
                expressions.add(expressionFactory.buildExpression(getProblematicExpressions(), getProblematicOperators()));
        return expressionFactory.buildExpression(expressions, operators);
    }

    private Expression extractExpressionInParenthesis(Stack<Expression> externalExpressions, Stack<OperatorToken> externalOperators) {
        externalOperators.pop();
        Expression expression = new ShuntingYardStrategy(expressionFactory).run(externalExpressions, externalOperators);
        externalOperators.pop();
        return expression;
    }

    private boolean isOpenParenthesis(OperatorToken operatorToken) {
        return operatorToken.getValue() =="(";
    }

    private boolean successfulShunting(Stack<Expression> expressionsQueue, Stack<OperatorToken> operatorsQueue) {
        OperatorToken operatorToken = operatorsQueue.pop();
        if(!operatorsQueue.isEmpty()){
        if(!isOpenParenthesis(operatorsQueue.peek()) )
            shuntingExpressions(expressionsQueue, expressions);
        else{
            if(expressions.isEmpty())
                expressions.add(expressionsQueue.pop());
            expressions.add(extractExpressionInParenthesis(expressionsQueue, operatorsQueue));
        }
        }else
            shuntingExpressions(expressionsQueue, expressions);
        operatorsQueue.push(operatorToken);
        return shuntingOperator(operatorsQueue, operators);
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

    private void shuntingExpressions(Stack<Expression> targetStack, Stack<Expression> destinyStack ) {
        if(destinyStack.isEmpty())
            destinyStack.push(targetStack.pop());
        destinyStack.push(targetStack.pop());
    }

    private boolean shuntingOperator(Stack<OperatorToken> targetStack, Stack<OperatorToken> destinyStack) {
        boolean shuntingResult = !highPriorityOperator(targetStack.peek());
        destinyStack.push(targetStack.pop());
        return shuntingResult;
    }

    private boolean highPriorityOperator(OperatorToken operator) {
        return !operators.isEmpty() && new OperatorRules().minnorPriority(operators.peek(), operator);
    }

    public boolean isCloseParenthesis(OperatorToken operator){
        return operator.getValue() ==")";
    }
}
