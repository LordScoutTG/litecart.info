package firstTest.selenide;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    public void selenideTest() {
        open("https://litecart.stqa.ru/en/");
        $("[name=email]").sendKeys("1123@123.com");
        $(By.name("password")).sendKeys("adDA12341");
        $(By.name("login")).click();
        $(".notice.success").shouldBe(visible).shouldHave(text("You are now logged in as 12345A A232222."));
    }
}
