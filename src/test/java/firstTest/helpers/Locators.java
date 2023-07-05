package firstTest.helpers;

import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Locators {
    private static Properties locators;

    static {
        locators = new Properties();

        InputStream is = Locators.class.getResourceAsStream("locators.properties");     // Принимаем локатор

        try {
            locators.load(is);                                                              // Ловим ошибку
        } catch (IOException e) {
            throw new RuntimeException("Couldn`t read from properties\n" + e.getMessage()); // При ошибке бросаем ошибку
        }
    }

    public static By getLocator(String element) throws Exception {
        String locator = locators.getProperty(element);                         // Получаем строку из пропертей

        String[] substrings = locator.split("=", 2);                 // Делителем получаем массив из локатора и значения

        LocatorTypes locatorType = LocatorTypes.valueOf(substrings[0]);         // Получаем 1 элемент массива - локатор
        String selector = substrings[1];                                        // Для упрощения кода заводим переменную

        switch (locatorType) {                                                  // Свичём возвращаем содержимое локатора
            case id: return By.id(selector);
            case name: return By.name(selector);
            case className: return By.className(selector);
            case tag: return By.linkText(selector);
            case partialLink: return By.partialLinkText(selector);
            case css: return By.cssSelector(selector);
            case xpath: return By.xpath(selector);
            default: throw new Exception("No locator found!");
        }
    }
}
