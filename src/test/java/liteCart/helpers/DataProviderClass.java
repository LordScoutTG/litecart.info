package liteCart.helpers;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "duckDataProvider")
    public static Object[][] dataProviderMethod(){
        return new Object[][]{
                new Object[]{"Yellow Duck"},
                new Object[]{"Red Duck"},
                new Object[]{"Blue Duck"},
                new Object[]{"Green Duck"},
                new Object[]{"Purple Duck"}
        };
    }
}
