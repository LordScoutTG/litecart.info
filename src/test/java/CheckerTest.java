import org.testng.Assert;
import org.testng.annotations.Test;
import unit.Checker;

public class CheckerTest {

    @Test
    public void isNumberNegativeTesting() {
        Assert.assertFalse(Checker.isNumber("sdsfsd"));
    }

    @Test
    public void isNumberTesting() {
        Assert.assertTrue(Checker.isNumber("3242342"));
    }

    @Test
    void isEmptyPositiveTesting() {
        Assert.assertTrue(Checker.isEmpty(""));
    }

    @Test
    void isEmptyTesting() {
        Assert.assertFalse(Checker.isEmpty("343dsfdsfs"));
    }

    @Test
    void isLengthCorrect() {
        Assert.assertTrue(Checker.isLengthCorrect("12", 2));

    }

    @Test
    void isSymbol() {
        Assert.assertTrue(Checker.isSymbol("+"));
    }


//    @Test
//    @Parameters({"asd", "2"})
//    void isLengthCorrectNegativeTesting(@Optional("asd") String testString,@Optional("2") Integer limit) {
//        Assert.assertFalse(Checker.isLengthCorrect(testString, limit));
//    }
}