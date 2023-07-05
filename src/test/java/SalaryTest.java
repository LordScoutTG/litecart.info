import org.testng.annotations.*;

public class SalaryTest {

    @BeforeTest
    public void setup() {

    }

    @AfterTest
    public void teardown() {

    }
    @BeforeGroups("someTestGroup")                              // До группы
    @AfterGroups("someTestGroup")                               // После группы

    @Test
    public void salaryCalculationTest() {
    }

    @Test(expectedExceptions = NumberFormatException.class, enabled = false)             // Тест эксепшена
    public void salaryCalculationTest5(){

    }
    @Test(timeOut = 5000)                                               // Время на тест. Защита от зависания
    public void timeOutTest() {

    }


    @Test(groups = "someTestGroup", enabled = false)                     // Тест в тестовой группе, выключен
    public void salaryCalculationTest4() {

    }

    @Test(groups = "someTestGroup")                     // Тест в тестовой группе
    public void salaryCalculationTest2() {

    }

    @Test(groups = {"someTestGroup", "oneMoreTestGroup"})   // Тест принадлежит нескольким тестовым группам
    public void salaryCalculationTest3() {

    }
}
