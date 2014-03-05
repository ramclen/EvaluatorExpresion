package evaluator;

import evaluator.parsers.ExpressionParser;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;


public class ExpresionEvaluatorTest {
    
    @Test
    public void constantTest(){
        Assert.assertEquals(1, new Constant(1).getResult()); 
        Assert.assertEquals(2, new Constant(2).getResult()); 
    }

    @Test
    public void multiplicationAndSumTest(){
        Operation mulOperation = new Operation("*", new Constant(2), new Constant(3));
        Operation sumOperation = new Operation("+", new Constant(1), mulOperation);
        Assert.assertEquals(7, sumOperation.getResult());
    }

    @Test
    public void parserExpressionGetExpresionTest(){
        ExpressionParser parser = new ExpressionParser();
        ArrayList<String> operatorList = new ArrayList();
        ArrayList<Expression> expressionList = new ArrayList();
        expressionList.add(new Constant(1));
        expressionList.add(new Constant(2));
        expressionList.add(new Constant(3));
        operatorList.add("+");
        operatorList.add("*");
        Assert.assertEquals(7, parser.buildExpression(expressionList, operatorList).getResult());
    }

    @Test
    public void parserExpressionTest() {
        ExpressionParser parser = new ExpressionParser();
        Assert.assertEquals(7, parser.toExpression("1+2*3").getResult());
        Assert.assertEquals(5, parser.toExpression("1*2+3").getResult());
        Assert.assertEquals(4, parser.toExpression("6:3+2*1").getResult());
    }

    @Test
    public void expressionEvaluatorTest() {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        Assert.assertEquals(7, evaluator.evaluate("1+2*3"));
    }
}
