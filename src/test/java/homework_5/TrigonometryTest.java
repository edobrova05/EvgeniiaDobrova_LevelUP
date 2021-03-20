package homework_5;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TrigonometryTest extends CalculatorTest{

    @Test
    public void doubleSinTest(){
        double actualSin = calculator.sin(0.5235);
        assertEquals(actualSin, 0.5, 0.0001);

    }

    @Test
    public void doubleCosTest(){
        double actualCos = calculator.cos(0.5235);
        assertEquals(actualCos, 0.8660, 0.0001);

    }

    @Test
    public void doubleTgTest(){
        double actualTg = calculator.tg(0.5235);
        assertEquals(actualTg, 0.5773, 0.0001);

    }

    @Test
    public void doubleCtgTest(){
        double actualCtg = calculator.ctg(0.5235);
        assertEquals(actualCtg, 1.7320, 0.0001);

    }


}
