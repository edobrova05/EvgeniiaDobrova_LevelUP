package homework_5;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CheckNegativeTest extends CalculatorTest {

    @DataProvider
    public Object[][] checkIsNegative(){
        return new Object[][]{
                {5L, false},
                {95L, false},
                {-7L, true},
                {-3L, true}
        };
    }

    @Test(dataProvider = "checkIsNegative")
    public void booleanNegativeTest(long a, boolean b) {
        boolean actualCheck = calculator.isNegative(a);
        assertEquals(actualCheck, b);
    }

}
