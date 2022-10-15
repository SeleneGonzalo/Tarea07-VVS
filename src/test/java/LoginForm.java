import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject {

    private final String USERNAME = "dumbridge";
    private final String PASSWORD = "tomriddle";

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button")
    private WebElement login_button;

    @FindBy(xpath = "//span[contains(text(),'Atención: Debe ingresar un nombre de usuario')]")
    private WebElement incorrect_username_label;

    @FindBy(xpath = "//span[contains(text(),'Atención: El password no puede estar vacío')]")
    private WebElement empty_password_label;

    @FindBy(xpath = "//span[contains(text(),'Atención: El password ingresado no es válido')]")
    private WebElement invalid_password_label;

    public String getIncorrectUser(){
        return this.incorrect_username_label.getText();
    }

    public String getInvalidPassword(){
        return this.invalid_password_label.getText();
    }

    public String getEmptyPassword(){
        return this.empty_password_label.getText();
    }

    public LoginForm(WebDriver driver){
        super(driver);
    }

    public void enterEmptyUserName(){
        this.username.sendKeys("");
    }

    public void enterEmptyPassword(){
        this.password.sendKeys("");
    }

    public void enterUserName(){
        this.username.sendKeys(USERNAME);
    }

    public void enterPassword(){
        this.password.sendKeys(PASSWORD);
    }

    public void pressLoginButton() { this.login_button.click(); }

    public void enterWrongPassword() { this.password.sendKeys("contraseñaIncorrecta");}
}

