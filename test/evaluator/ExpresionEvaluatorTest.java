package evaluator;


import junit.framework.Assert;
import org.junit.Test;


public class ExpresionEvaluatorTest {
    
    @Test
    public void arithmeticExpressionTest(){
        ExpresionEvaluator evaluator = new ExpresionEvaluator();
        Assert.assertEquals(7, evaluator.execute("1+2*3")); 
    }
    
    @Test
    public void constantTest(){
        ExpresionEvaluator evaluator = new ExpresionEvaluator();
        Assert.assertEquals(1, evaluator.execute("1")); 
        Assert.assertEquals(1, evaluator.execute("2")); 
    }
    

}
