package evaluator.parsers;

import evaluator.Expression;
import evaluator.Operation;
import evaluator.parsers.tokenizer.tokens.OperatorToken;

import java.util.Stack;

public class ExpressionFactory {

    public Expression buildExpression(Stack<Expression> expressions, Stack<OperatorToken> operators) {
        while (!operators.isEmpty())
            createNextExpression(expressions, operators);
        return expressions.pop();
    }

    private void createNextExpression(Stack<Expression> expressions, Stack<OperatorToken> operators) {
        OperatorToken nextOperator = operators.pop();
        if(haveOperatorConflict(operators, nextOperator))
            resolveOperatorConflict(expressions, operators);
        addNewOperation(expressions,nextOperator);
    }

    private boolean haveOperatorConflict(Stack<OperatorToken> operators, OperatorToken nextOperator) {
        if(!operators.isEmpty())
            return new OperatorRules().minnorPriority((String) nextOperator.getValue(), (String)operators.peek().getValue());
        return false;

    }

    private void resolveOperatorConflict(Stack<Expression> expressions, Stack<OperatorToken> operators) {
        Expression expression = expressions.pop();
        expressions.add(new Operation((String) operators.pop().getValue(), expressions.pop(), expressions.pop()));
        expressions.add(expression);
    }

    private void addNewOperation(Stack<Expression> expressions, OperatorToken operator) {
        expressions.add(new Operation((String) operator.getValue(), expressions.pop(), expressions.pop()));
    }
}