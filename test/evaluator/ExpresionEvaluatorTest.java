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
        Assert.assertEquals(3, operation);
    }
    
}
