public class DucksTest {
//    private WebDriver driver;
//
//
//
//    @BeforeMethod
//    public void init() {
//        driver = new ChromeDriver();
//
//    }
//
//    @Test
//    public void registration() {
//        driver.get("https://litecart.stqa.ru/en/");
//        driver.findElement(By.linkText("New customers click here")).click();
//        WebElement searchInputName = driver.findElement(By.name("firstname"));
//        searchInputName.sendKeys("12345A");
//        WebElement searchInputLastName = driver.findElement(By.name("lastname"));
//        searchInputLastName.sendKeys("A232222");
//        WebElement searchInputAddress = driver.findElement(By.name("address1"));
//        searchInputAddress.sendKeys("ABBC str, 123");
//        WebElement searchInputPostCode = driver.findElement(By.name("postcode"));
//        searchInputPostCode.sendKeys("999777");
//        WebElement searchInputCity = driver.findElement(By.name("city"));
//        searchInputCity.sendKeys("Sevas");
//        WebElement searchInputCountry = driver.findElement(By.xpath("//span[@class='select2-selection__rendered']"));
//        searchInputCountry.click();
//        WebElement inputCountry = driver.findElement(By.className("select2-search__field"));
//        inputCountry.sendKeys("Russi");
//        Actions builder = new Actions(driver);
//        builder.sendKeys(Keys.ENTER).perform();
//        WebElement searchInputEmail = driver.findElement(By.name("email"));
//        searchInputEmail.sendKeys("1123@123.com");
//        WebElement searchInputPhone = driver.findElement(By.name("phone"));
//        searchInputPhone.sendKeys("+79977777777");
//        WebElement searchCheckBox = driver.findElement(By.name("newsletter"));
//        searchCheckBox.click();
//        WebElement searchPassword = driver.findElement(By.name("password"));
//        searchPassword.sendKeys("adDA12341");
//        WebElement searchPasswordConfirmation = driver.findElement(By.name("confirmed_password"));
//        searchPasswordConfirmation.sendKeys("adDA12341");
//        WebElement searchRegistrationButton = driver.findElement(By.name("create_account"));
//        searchRegistrationButton.click();
//    }
//
//    @AfterMethod
//    public void quit() {
//        driver.quit();
//    }
}
