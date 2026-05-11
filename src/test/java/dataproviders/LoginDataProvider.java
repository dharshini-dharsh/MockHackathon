package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getData() {

        return new Object[][]{
                {"dharshinidharshu623@gmail.com", "Dharshu@2005", "valid"},
                {"dharshinidharshu623@gmail.com", "dharshu@2005", "invalid"}
        };
    }
}