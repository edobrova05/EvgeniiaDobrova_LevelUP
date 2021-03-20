package homework_5;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class PowersTest extends CalculatorTest{

    @Test
    public void doublePowTest(){
        double actualPow = calculator.pow(2.0, 3.0);
        assertEquals(actualPow, 8.0, 0.0001);

    }

    @Test
    public void doubleSqrtTest(){
        double actualSqrt = calculator.sqrt(25);
        assertEquals(actualSqrt, 5.0, 0.0001);
    }

}
