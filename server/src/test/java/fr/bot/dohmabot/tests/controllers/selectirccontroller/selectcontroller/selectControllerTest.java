package fr.bot.dohmabot.tests.controllers.selectirccontroller.selectcontroller;

import fr.bot.dohmabot.bot.IRCMessage;
import fr.bot.dohmabot.server.controllers.selectIRCController;
import org.junit.jupiter.api.BeforeEach;

public class selectControllerTest {

    public selectIRCController selectController;
    public IRCMessage inputIRCMessage;

    private final String channel = "TestChannel";
    private final String sender = "TestSender";
    private final String login = "TestLogin";
    private final String hostname = "TestHostnmae";
    private final String message = "TestMessage";

    protected final String commandName = "isCommand";
    protected final String commandOk = "!testcommandOk";
    protected final String commandFail = "testcommandFail";
    protected final String multipleCommand = "!testcommand1 !testcommand2";
    protected final String commandAndArgument = "!testcommand argument";

    /**
     * Setup of each configuration tests
     */
    @BeforeEach
    public void setUp() {
        this.selectController = new selectIRCController();
        this.inputIRCMessage = new IRCMessage(this.channel, this.sender, this.login, this.hostname, this.message);
    }

}