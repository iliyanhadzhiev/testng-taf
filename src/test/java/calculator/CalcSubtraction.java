package calculator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalcSubtraction {

    @DataProvider(name = "numProvider")
    public Object[][] numProvider() {
        return new Object[][] {
                {5, 1, 4},
                {-2, 2, -4},
                {19, -41, 60}
        };
    }

    @Test(dataProvider = "numProvider", groups = "subtraction", suiteName = "CalculatorOperations")
    public void validateNumSubtraction(double num1, double num2, double result) {

        double firstProvidedNum = num1;
        double secondProvidedNum = num2;
        double expectedResult = result;
        double actualResult = firstProvidedNum - secondProvidedNum;

        System.out.println("The subtraction of " + firstProvidedNum + " and " + secondProvidedNum + " is equal: " + actualResult);

        Assert.assertEquals(expectedResult, actualResult);
    }

}
