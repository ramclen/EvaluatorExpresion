package evaluator;

import org.junit.Assert;
import org.junit.Test;

public class ExpresionEvaluatorTest {
    @Test
    public void constantTest(){
        Assert.assertEquals(1, new Number("1").getResult()); 
        Assert.assertEquals(2, new Number("2").getResult()); 
    }
    
    @Test
    public void sumTest(){
        Operation operation = new Operation("+", new Number("1"), new Number("2"));
        Assert.assertEquals(3, operation.getResult());
        
        operation = new Operation("+", new Number("5"), new Number("2"));
        Assert.assertEquals(7, operation.getResult());
    }
    
    @Test
    public void multiplicationAndSumTest(){
        Operation mulOperation = new Operation("*", new Number("2"), new Number("3"));
        Operation sumOperation = new Operation("+", new Number("1"), mulOperation);
        Assert.assertEquals(7, sumOperation.getResult());
    }
    @Test
    public void sympleEvaluatorExpressionTest(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        Assert.assertEquals(7, evaluator.getOperation("1+2*3").getResult());
    }
    
    @Test
    public void complexExpressionTest(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        Assert.assertEquals(6, evaluator.getOperation("1+2*3-3:4").getResult());
    }
    
}
