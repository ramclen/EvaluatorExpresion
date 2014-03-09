package evaluator.parsers;

import evaluator.Constant;
import evaluator.Expression;
import evaluator.parsers.tokenizer.tokens.ConstantToken;
import evaluator.parsers.tokenizer.tokens.ExpressionToken;
import evaluator.parsers.tokenizer.ExpressionTokenizer;
import evaluator.parsers.tokenizer.tokens.OperatorToken;

import java.util.Stack;

public class Parser {
    private Stack<Expression> expressions;
    private Stack<OperatorToken> operators;
    
    public Parser() {
        expressions = new Stack<>();
        operators = new Stack<>();
    }

    public Expression parse(String string) {
        return null;

    }

    //TODO estamos metiendo por el momento strings en las constantes
    private void addToSpecificStack(ExpressionToken token) {
        if(token instanceof ConstantToken)
            expressions.push(new Constant<>(token.getValue()));
        operators.push((OperatorToken) token);
    }
}

