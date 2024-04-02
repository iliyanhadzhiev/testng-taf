package calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcDivision {

    @DataProvider(name = "numProvider")
    public Object[][] numProvider() {
        return new Object[][] {
                {15, 3, 5},
                {-2, 2, -1},
                {20, -4, -5}
        };
    }

    @Test(dataProvider = "numProvider", groups = "multiplication", suiteName = "CalculatorOperations")
    public void validateNumDivision(double num1, double num2, double result) {

        double firstProvidedNum = num1;
        double secondProvidedNum = num2;
        double expectedResult = result;
        double actualResult = firstProvidedNum / secondProvidedNum;

        System.out.println("The division of " + firstProvidedNum + " and " + secondProvidedNum + " is equal: " + actualResult);

        Assert.assertEquals(expectedResult, actualResult);
    }
}
