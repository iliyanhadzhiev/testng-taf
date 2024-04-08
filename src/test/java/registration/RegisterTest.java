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
        System.out.println();

        System.out.println("4. Validating successful registration: ");

        System.out.println("4.1. Populating username: IliyanH");
        typeTextInInput(usernameField, "IliyanH");

        System.out.println("4.2. Populating email: i1-test@test.i1");
        typeTextInInput(emailField, "i1-test@test.i1");

        System.out.println("4.3. Populating date of birth: 11/22/1980");
//        birthDateField.click();
//        birthDateField.sendKeys("11/22/1980");
        typeTextInInput(birthDateField, "11/22/1980");

        System.out.println("4.4. Populating password: i1$qual!Ty");
        typeTextInInput(passwordField, "i1$qual!Ty");

        System.out.println("4.5. Populating confirm password: i1$qual!Ty");
        typeTextInInput(confirmPasswordField, "i1$qual!Ty");

        System.out.println("4.6. Populating public info: i1");
        typeTextInInput(publicInfoField, "i1");
        System.out.println();

        System.out.println("4.7. Clicking on the \"Sign in\" button.");
//        signInButton.click();
    }

    @Test (dependsOnMethods = "validateRegisterFields", priority = 2)
    public void validateUserIsCreated() throws InterruptedException {
        WebElement profileButton = driver.findElement(By.cssSelector("#nav-link-profile"));
        boolean isProfileButtonDisplayed = profileButton.isDisplayed();
        Assert.assertTrue(isProfileButtonDisplayed);
        System.out.println("5. Successful registration. User is created.");
        System.out.println();
    }

    @Test (priority = 3)
    public void validateHomeIcon() throws InterruptedException {
        driver.get(REGISTER_PAGE);
        WebElement homeIcon = driver.findElement(By.cssSelector("#homeIcon"));
        boolean isHomeIconDisplayed = homeIcon.isDisplayed();
        Assert.assertTrue(isHomeIconDisplayed);
        System.out.println("6. Home icon is present");
        String homeIconImage = homeIcon.getAttribute("src");
        String homeIconImageName = "Iskillo-logo.png";
        if (homeIconImage.contains(homeIconImageName)) {
            System.out.println("6.1. The home icon logo is displayed");
        } else {
            System.out.println("6.1. The home icon logo is NOT displayed");
        }
        System.out.println("6.2. Clicking on Home icon");
        homeIcon.click();
        String currentUrlAfterClickingHomeIcon = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlAfterClickingHomeIcon, HOME_PAGE);
        System.out.println("6.3. User is on Home page");
    }

    @Test (priority = 4)
    public void validateHomeButton() throws InterruptedException {
        driver.get(REGISTER_PAGE);
        WebElement homeButton = driver.findElement(By.cssSelector("#nav-link-home"));
        boolean isHomeButtonDisplayed = homeButton.isDisplayed();
        Assert.assertTrue(isHomeButtonDisplayed);
        System.out.println("7. Home button is displayed");
        System.out.println("7.1. Clicking on Home button");
        homeButton.click();
        String currentUrlAfterClickingHomeButton = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlAfterClickingHomeButton, HOME_PAGE);
        System.out.println("7.2. User is on Home page");
    }

    @Test (priority = 5)
    public void validateLoginButton() throws InterruptedException {
        driver.get(REGISTER_PAGE);
        WebElement loginButton = driver.findElement(By.cssSelector("#nav-link-login"));
        boolean isLoginButtonDisplayed = loginButton.isDisplayed();
        Assert.assertTrue(isLoginButtonDisplayed);
        System.out.println("8. Login button is displayed");
        System.out.println("8.1. Clicking on Login button");
        loginButton.click();
        String currentUrlAfterClickingLoginButton = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlAfterClickingLoginButton, LOGIN_PAGE);
        System.out.println("8.2. User is on the Login page");
    }

    @Test (priority = 6)
    public void validateMandatoryFieldWarning() throws InterruptedException {
        driver.get(REGISTER_PAGE);
        //h4[contains(@class,'text-center mb-4')]
        //
    }

    public void typeTextInInput(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}