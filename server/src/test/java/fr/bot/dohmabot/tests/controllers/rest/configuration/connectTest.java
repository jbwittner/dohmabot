package fr.bot.dohmabot.tests.controllers.rest.configuration;

import fr.bot.dohmabot.tools.Stub.StubIRCBot;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * A JUnit test case testing the connect method of configurationController.
 */
public class connectTest extends configurationTest{

    @Test
    public void connectOk() throws IOException, IrcException, NickAlreadyInUseException {
        boolean result;
        result = this.controller.connect(StubIRCBot.TEST_URI_OK,StubIRCBot.TEST_PORT,StubIRCBot.TEST_TOKEN);
        Assertions.assertTrue(result);
    }

    @Test
    public void connectImpossible() {
        Assertions.assertThrows(IOException.class, () -> {
            this.controller.connect(StubIRCBot.TEST_URI_IMPOSSIBLE_CONNECT,StubIRCBot.TEST_PORT,StubIRCBot.TEST_TOKEN);
        });
    }

    @Test
    public void connectNickAlreadyUse() {
        Assertions.assertThrows(NickAlreadyInUseException.class, () -> {
            this.controller.connect(StubIRCBot.TEST_URI_NICK_ALREADY_USE,StubIRCBot.TEST_PORT,StubIRCBot.TEST_TOKEN);
        });
    }

    @Test
    public void connectNotLetJoin() {
        Assertions.assertThrows(IrcException.class, () -> {
            this.controller.connect(StubIRCBot.TEST_URI_NOT_LET_JOIN,StubIRCBot.TEST_PORT,StubIRCBot.TEST_TOKEN);
        });
    }
}
