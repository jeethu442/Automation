import org.testng.annotations.Test;

public class Automation {
    AutomationConstants automationConstants = new AutomationConstants();

    @Test
    public void statusUpdate() throws InterruptedException {

        LoginUtils.performLoginAndPostStatus(automationConstants.EmailID, automationConstants.Password, automationConstants.statusMessage);
    }
}
