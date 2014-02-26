package evaluator;

import org.junit.Assert;
import org.junit.Test;

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
    public void complexExpressionTest(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        Assert.assertEquals(7, evaluator.getOperation("1+2*3").getResult());
    }
    
}
