package homework_5;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class MultiplicationTest extends CalculatorTest{

    @Test
    public void multLongTest(){
        long actualMult = calculator.mult(5L,10L);
        assertEquals(actualMult, 50L, 0.0001);
    }

    @Test
    public void multDoubleTest(){
        double actualMult = calculator.mult(4.4, 2);
        assertEquals(actualMult, 8.8, 0.0001);
    }
}
