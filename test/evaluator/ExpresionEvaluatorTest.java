package evaluator;

import org.junit.Assert;
import org.junit.Test;

public class ExpresionEvaluatorTest {
    
    @Test
    public void constantTest(){
        Assert.assertEquals(1, new Constant(1).getResult().getValue()); 
        Assert.assertEquals(2, new Constant(2).getResult().getValue()); 
    }
    
    @Test
    public void sumTest(){
        Operation operation = new Operation("+", new Constant(1), new Constant(2));
        Assert.assertEquals(3, operation.getResult().getValue());
        
        operation = new Operation("+", new Constant(5), new Constant(2));
        Assert.assertEquals(7, operation.getResult().getValue());
    }
    
    @Test
    public void multiplicationAndSumTest(){
        Operation mulOperation = new Operation("*", new Constant(2), new Constant(3));
        Operation sumOperation = new Operation("+", new Constant(1), mulOperation);
        Assert.assertEquals(7, sumOperation.getResult().getValue());
    }
    
    @Test
    public void lessThanTest(){
        Operation lessThantOperation = new Operation("<", new Constant(1), new Constant(3));
        Assert.assertEquals(true, lessThantOperation.getResult().getValue());
    }
    
    
    public void complexExpressionTest(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        Assert.assertEquals(7, evaluator.getOperation("1+2*3").getResult());
        Assert.assertEquals(6, evaluator.getOperation("1+2*3-3:4").getResult());
    }
    
}
