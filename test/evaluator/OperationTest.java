package evaluator;

import org.junit.Assert;
import org.junit.Test;

public class OperationTest {
    @Test
    public void sumTest(){
        Operation operation = new Operation("+", new Constant(1), new Constant(2));
        Assert.assertEquals(3, operation.getResult());

        operation = new Operation("+", new Constant(5), new Constant(2));
        Assert.assertEquals(7, operation.getResult());
    }

    @Test
    public void subtractionTest(){
        Operation operation = new Operation("-", new Constant(1), new Constant(2));
        Assert.assertEquals(-1, operation.getResult());

        operation = new Operation("-", new Constant(5), new Constant(2));
        Assert.assertEquals(3, operation.getResult());
    }

    @Test
    public void divisionTest(){
        Operation operation = new Operation("/", new Constant(1.0), new Constant(2));
        Assert.assertEquals(0.5, operation.getResult());

        operation = new Operation("/", new Constant(6), new Constant(2));
        Assert.assertEquals(3, operation.getResult());
    }

    @Test
    public void multiplicationTest(){
        Operation operation = new Operation("*", new Constant(1.5), new Constant(2));
        Assert.assertEquals(3.0, operation.getResult());

        operation = new Operation("*", new Constant(6), new Constant(2));
        Assert.assertEquals(12, operation.getResult());
    }

    @Test
    public void lessThanTest(){
        Operation lessThantOperation = new Operation("<", new Constant(1), new Constant(3));
        Assert.assertEquals(true, lessThantOperation.getResult());
    }
}
