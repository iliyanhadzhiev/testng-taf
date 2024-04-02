package calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcAddition {

    @DataProvider(name = "numProvider")
    public Object[][] numProvider() {
        return new Object[][] {
                {1, 1, 2},
                {-2, 2, 0},
                {19, -41, 22}
        };
    }

    @Test(dataProvider = "numProvider", groups = "addition", suiteName = "CalculatorOperations")
    public void validateNumAddition(double num1, double num2, double result) {

        double firstProvidedNum = num1;
        double secondProvidedNum = num2;
        double expectedResult = result;
        double actualResult = firstProvidedNum + secondProvidedNum;

        System.out.println("The addition of " + firstProvidedNum + " and " + secondProvidedNum + " is equal: " + actualResult);

        Assert.assertEquals(expectedResult, actualResult);
    }
}
