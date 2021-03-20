package homework_5;

import org.testng.annotations.Test;

public class ExceptionTest extends CalculatorTest{

    @Test(expectedExceptions = ArithmeticException.class)
    public void longExceptionTest(){
        calculator.div(5L, 0L);
    }
}
