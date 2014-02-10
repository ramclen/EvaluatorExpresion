package evaluator;

import org.junit.Assert;
import org.junit.Test;

public class ExpresionEvaluatorTest {
    @Test
    public void constantTest(){
        Assert.assertEquals(1, new Number("1").getResult()); 
    }
    
}
