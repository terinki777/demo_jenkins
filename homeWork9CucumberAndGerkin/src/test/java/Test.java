import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


import java.time.Duration;


@CucumberOptions(
        features = "src/test/java/features",//путь до feature файлов
        glue = "stepDef",//название пакета с шагами
        tags = "@1" //Теги по которым будет запускаться сценарий
)

public class Test extends AbstractTestNGCucumberTests {

}
