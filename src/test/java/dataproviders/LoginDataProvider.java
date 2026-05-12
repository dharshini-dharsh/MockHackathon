package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getData() {

        return new Object[][]{
                {"dharshinidharshu623@gmail.com", "Dharshu@2005", "valid"},
                {
                        "dharshini@gmail.com",
                        "dharshini@123",
                        "invalid"
                }
        };
    }
}