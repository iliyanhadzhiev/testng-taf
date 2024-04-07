package registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest {
    public static final String BASE_URL = "http://training.skillo-bg.com:4300/";
    public static final String HOME_PAGE = BASE_URL + "/posts/all";
    public static final String LOGIN_PAGE = BASE_URL + "users/login";
    public static final String REGISTER_PAGE = BASE_URL + "users/register";

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

    @BeforeClass
    public void startBrowser() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test (priority = 0)
    public void validateRegisterNavigation() throws InterruptedException {
        driver.get(BASE_URL);
        System.out.println("1. Validating navigation to Register page:");

        String baseUrlPageTitle = driver.getTitle();
        System.out.println("1.1. The BASE_URL page title is \"" + baseUrlPageTitle + "\"");
        String currentUrlWhenLoadingPage = driver.getCurrentUrl();
        System.out.println("1.1.1. The current URL is: " + currentUrlWhenLoadingPage);

        WebElement loginButton = driver.findElement(By.cssSelector("#nav-link-login"));
        boolean isLoginButtonDisplayed = loginButton.isDisplayed();
        Assert.assertTrue(isLoginButtonDisplayed);
        System.out.println("1.1.2. Login header button is displayed.");

        System.out.println("1.1.3. Clicking Login header button");
        System.out.println();
        loginButton.click();
        WebElement signInButton = driver.findElement(By.cssSelector("#sign-in-button"));
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        String currentUrlAfterClickingLoginButton = driver.getCurrentUrl();
        System.out.println("1.2. Comparing current URL (" + currentUrlAfterClickingLoginButton + ") and LOGIN_PAGE (" + LOGIN_PAGE + ")");
        Assert.assertEquals(currentUrlAfterClickingLoginButton, LOGIN_PAGE);

        WebElement loginPageHeader = driver.findElement(By.xpath("//p[contains(@class,'h4 mb-4')]"));
        String loginPageHeaderText = loginPageHeader.getText();
        System.out.println("1.2.1. Current page header is \"" + loginPageHeaderText + "\"");

        WebElement registerLink = driver.findElement(By.xpath("//a[contains(@href,'/users/register')]"));
        boolean isRegisterLinkDisplayed = registerLink.isDisplayed();
        Assert.assertTrue(isRegisterLinkDisplayed);
        System.out.println("1.2.2. Register link is present.");
        System.out.println("1.2.3. Clicking on the Register link");
        System.out.println();
        registerLink.click();

        String currentUrlAfterClickingRegisterLink = driver.getCurrentUrl();
        System.out.println("1.3. Comparing current URL (" + currentUrlAfterClickingRegisterLink + ") and BASE_URL + REGISTER_PAGE (" + REGISTER_PAGE + ")");
        Assert.assertEquals(currentUrlAfterClickingRegisterLink, REGISTER_PAGE);
        WebElement registerHeader = driver.findElement(By.xpath("//h4[contains(@class,'text-center mb-4')]"));
        String registerPageHeader = registerHeader.getText();
        System.out.println("1.3.1 Current page header is \"" + registerPageHeader + "\"");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println();
    }

    @Test (dependsOnMethods = "validateRegisterNavigation", priority = 1)
    public void validateRegisterFields() throws InterruptedException {
        System.out.println("2. Validating presence of register fields:");

        WebElement usernameField = driver.findElement(By.xpath("//input[contains(@formcontrolname,'username')]"));
        boolean isUsernameFieldDisplayed = usernameField.isDisplayed();
        Assert.assertTrue(isUsernameFieldDisplayed);
        System.out.println("2.1. The \"Username\" field is present");

        WebElement emailField = driver.findElement(By.xpath("//input[contains(@formcontrolname,'email')]"));
        boolean isEmailFieldDisplayed = emailField.isDisplayed();
        Assert.assertTrue(isEmailFieldDisplayed);
        System.out.println("2.2. The \"email\" field is present");

        WebElement birthDateField = driver.findElement(By.xpath("//input[contains(@formcontrolname,'birthDate')]"));
        boolean isBirthDateFieldDisplayed = birthDateField.isDisplayed();
        Assert.assertTrue(isBirthDateFieldDisplayed);
        System.out.println("2.3. The \"Birth Date\" field is present");

        WebElement passwordField = driver.findElement(By.cssSelector("#defaultRegisterFormPassword"));
        boolean isPasswordFieldDisplayed = passwordField.isDisplayed();
        Assert.assertTrue(isPasswordFieldDisplayed);
        System.out.println("2.4. The \"Password\" field is present");

        WebElement confirmPasswordField = driver.findElement(By.cssSelector("#defaultRegisterPhonePassword"));
        boolean isConfirmPasswordFieldDisplayed = confirmPasswordField.isDisplayed();
        Assert.assertTrue(isConfirmPasswordFieldDisplayed);
        System.out.println("2.5. The \"Confirm Password\" field is present");

        WebElement publicInfoField = driver.findElement(By.xpath("//textarea[contains(@formcontrolname,'publicInfo')]"));
        boolean isPublicInfoFieldDisplayed = publicInfoField.isDisplayed();
        Assert.assertTrue(isPublicInfoFieldDisplayed);
        System.out.println("2.6. The \"Public info\" field is present");

        WebElement signInButton = driver.findElement(By.cssSelector("#sign-in-button"));
        boolean isSignInButtonDisplayed = signInButton.isDisplayed();
        Assert.assertTrue(isSignInButtonDisplayed);
        System.out.println("2.7. The \"Sign in\" button is present");
        System.out.println();


        System.out.println("3. Validating register fields' placeholders:");

        String usernameFieldPlaceholder = usernameField.getAttribute("placeholder");
        Assert.assertEquals(usernameFieldPlaceholder, "Username");
        System.out.println("3.1. \"Username\" field has placeholder: " + usernameFieldPlaceholder);

        String emailFieldPlaceholder = emailField.getAttribute("placeholder");
        Assert.assertEquals(emailFieldPlaceholder, "email");
        System.out.println("3.2. \"Email\" field has placeholder: " + emailFieldPlaceholder);

        String birthdateFieldPlaceholder = birthDateField.getAttribute("placeholder");
        Assert.assertEquals(birthdateFieldPlaceholder, "Birth date");
        System.out.println("3.3. \"Birthdate\" field has placeholder: " + birthdateFieldPlaceholder);
        //Placeholder: Birth date
        //Displayed: mm/dd/yyyy

        String passwordFieldPlaceholder = passwordField.getAttribute("placeholder");
        Assert.assertEquals(passwordFieldPlaceholder, "Password");
        System.out.println("3.4. \"Password\" field has placeholder: " + passwordFieldPlaceholder);

        String confirmPasswordFieldPlaceholder = confirmPasswordField.getAttribute("placeholder");
        Assert.assertEquals(confirmPasswordFieldPlaceholder, "Confirm Password");
        System.out.println("3.5. \"Confirm Password\" field has placeholder: " + confirmPasswordFieldPlaceholder);

        String publicInfoFieldPlaceholder = publicInfoField.getAttribute("placeholder");
        Assert.assertEquals(publicInfoFieldPlaceholder, "Public info");
        System.out.println("3.6. \"Public info\" field has placeholder: " + publicInfoFieldPlaceholder);

        String signInButtonText = signInButton.getText();
        Assert.assertEquals(signInButtonText, "Sign in");
        System.out.println("3.7. \"Sign in\" button has text: " + signInButtonText);

    }


    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}