package herokuapp;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static pageObject.helpers.WebDriverContainer.setDriver;

public class WeatherSevastopol {
    private static By weatherAugustTemp = By.cssSelector("[class=\"first\"] + [class=\"first_in_group positive\"]");

    public static List<Integer> getWeather(){
        return setDriver().findElements(weatherAugustTemp).stream().map(x->x.getText().substring(1)).map(Integer::valueOf)
                .collect(Collectors.toList());
    }
    public static Double averageTemp(){
        return getWeather().stream().mapToDouble(Integer::intValue)
                .average()
                .orElse(Double.NaN);
    }
}
