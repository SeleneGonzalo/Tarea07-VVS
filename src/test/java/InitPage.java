import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitPage extends PageObject{

    @FindBy(xpath = "//h3[contains(text(),'Bienvenido a OSTH On-Line')]")
    private WebElement products_label;

    public InitPage(WebDriver driver){
        super(driver);
    }

    public String getTitle(){
        return this.products_label.getText();
    }
}
