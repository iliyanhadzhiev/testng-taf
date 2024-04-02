package calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcMultiplication {

    @DataProvider(name = "numProvider")
    public Object[][] numProvider() {
        return new Object[][] {
                {5, 6, 30},
                {-2, 2, -4},
                {3, 0, 0}
        };
    }

    @Test(dataProvider = "numProvider", groups = "multiplication", suiteName = "CalculatorOperations")
    public void validateNumMultiplication(double num1, double num2, double result) {

        double firstProvidedNum = num1;
        double secondProvidedNum = num2;
        double expectedResult = result;
        double actualResult = firstProvidedNum * secondProvidedNum;

        System.out.println("The multiplication of " + firstProvidedNum + " and " + secondProvidedNum + " is equal: " + actualResult);

        Assert.assertEquals(expectedResult, actualResult);
    }
}
