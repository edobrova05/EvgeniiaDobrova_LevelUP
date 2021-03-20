package homework_5;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DivisionTest extends CalculatorTest{

    @Test
    public void longDivisionTest(){
        long actualDiv = calculator.div(9L, 3L);
        assertEquals(actualDiv, 3L, 0.0001);
    }

    @Test
    public void doubleDivisionTest(){
        double actualDiv = calculator.div(10.0, 2.5);
        assertEquals(actualDiv, 4.0, 0.0001);
    }

}
