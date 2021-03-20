package homework_5;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SubtractionTest extends CalculatorTest {

    @Test
    public void subLongTest(){
        long actualSub = calculator.sub(5L,4L);
        assertEquals(actualSub, 1L, 0.0001);
    }

    @Test
    public void subDoubleTest(){
        double actualSub = calculator.sub(9.9, 7.7);
        assertEquals(actualSub, 2.2, 0.0001);
    }

}
