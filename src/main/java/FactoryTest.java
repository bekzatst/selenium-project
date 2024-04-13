import org.testng.annotations.Factory;

public class FactoryTest {
    @Factory
    public Object[] factoryMethod(){
        return new Object[] {new LoginTest("chrome"), new LoginTest("edge")};
    }
}
