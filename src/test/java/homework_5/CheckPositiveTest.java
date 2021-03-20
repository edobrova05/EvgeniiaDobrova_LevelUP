package homework_5;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CheckPositiveTest extends CalculatorTest {

    @DataProvider
    public Object[][] checkIsPositive(){
        return new Object[][]{
                {5L, true},
                {95L, true},
                {-7L, false},
                {-3L, false}
        };
    }

    @Test(dataProvider = "checkIsPositive")
    public void booleanPositiveTest(long a, boolean b) {
        boolean actualCheck = calculator.isPositive(a);
        assertEquals(actualCheck, b);
    }
}
