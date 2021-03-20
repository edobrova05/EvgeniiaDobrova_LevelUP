package homework_5;


import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class SumTest extends CalculatorTest{

    @Test
    public void sumLongTest(){
        long actualSum = calculator.sum(2L,3L);
        assertEquals(actualSum, 5L, 0.0001);
    }

    @Test
    public void sumDoubleTest(){
        double actualSum = calculator.sum(5.5, 2.2);
        assertEquals(actualSum,7.7,0.0001);

    }
}
