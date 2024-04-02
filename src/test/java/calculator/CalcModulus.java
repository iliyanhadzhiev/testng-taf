package calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcModulus {

    @DataProvider(name = "numProvider")
    public Object[][] numProvider() {
        return new Object[][] {
                {15, 4, 1},
                {-2, 2, 0},
                {20, -3, 2}
        };
    }

    @Test(dataProvider = "numProvider", groups = "multiplication", suiteName = "CalculatorOperations")
    public void validateNumModulus(double num1, double num2, double result) {

        double firstProvidedNum = num1;
        double secondProvidedNum = num2;
        double expectedResult = result;
        double actualResult = firstProvidedNum % secondProvidedNum;

        System.out.println("The division of " + firstProvidedNum + " and " + secondProvidedNum + " is equal: " + actualResult);

        Assert.assertEquals(expectedResult, actualResult);
    }
}
