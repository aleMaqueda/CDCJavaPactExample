import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import producer.UserServiceApplication;
import au.com.dius.pact.provider.junit.IgnoreNoPactsToVerify;

@RunWith(SpringRestPactRunner.class)
@Provider("Provider")
//@PactFolder("src/pacts")
@PactBroker(host = "localhost", port="8000",
authentication =  @PactBrokerAuth(username = "pact_workshop", password = "pact_workshop")
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = UserServiceApplication.class)
public class ContractTest {

    @TestTarget
    public final Target target = new SpringBootHttpTarget();

    @State("User 1 exists")
    public void user1Exists() {

    }
}
