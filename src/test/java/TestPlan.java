import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    //TEST Caso 1: Intentar ingresar sin escribir usuario ni contraseña.
    @Test(testName = "Caso 1")
    public static void withoutUserNameOrPassword(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterEmptyUserName();
        loginForm.enterEmptyPassword();
        loginForm.pressLoginButton();

        Assert.assertEquals(loginForm.getIncorrectUser(), "Atención: Debe ingresar un nombre de usuario");
    }

    //TEST Caso 2: Intentar ingresar sólo escribiendo usuario, dejando la contraseña vacía.
    @Test(testName = "Caso 2")
    public static void withUserName(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserName();
        loginForm.enterEmptyPassword();
        loginForm.pressLoginButton();

        Assert.assertEquals(loginForm.getEmptyPassword(), "Atención: El password no puede estar vacío");
    }

    //TEST Caso 3: Intentar ingresar con el usuario "dumbridge" y la contraseña "tomriddle".
    @Test(testName = "Caso 3")
    public static void loginSuccessfully(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserName();
        loginForm.enterPassword();
        loginForm.pressLoginButton();

        InitPage productsPage = new InitPage(driver);
        Assert.assertEquals(productsPage.getTitle(), "Bienvenido a OSTH On-Line");
    }

    //TEST Caso 4: Intentar ingresar con el usuario "dumbridge" y una contraseña incorrecta.
    @Test(testName = "Caso 4")
    public static void loginUnsuccessfully(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserName();
        loginForm.enterWrongPassword();
        loginForm.pressLoginButton();

        Assert.assertEquals(loginForm.getInvalidPassword(), "Atención: El password ingresado no es válido");
    }
}
