package fr.bot.dohmabot.tests.controllers.rest.configuration;

import fr.bot.dohmabot.tools.stub.stubIRCBot;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * A JUnit test case testing the connect method of configurationController.
 */
public class connectTest extends configurationTest{

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void connectOk() throws IOException, IrcException, NickAlreadyInUseException {
        boolean result;
        result = this.controller.connect(stubIRCBot.TEST_URI_OK, stubIRCBot.TEST_PORT, stubIRCBot.TEST_TOKEN);
        Assertions.assertTrue(result);
    }

    /**
     * Test to check if the method throw a IOException
     */
    @Test
    public void connectImpossible() {
        Assertions.assertThrows(IOException.class, () -> {
            this.controller.connect(stubIRCBot.TEST_URI_IMPOSSIBLE_CONNECT, stubIRCBot.TEST_PORT, stubIRCBot.TEST_TOKEN);
        });
    }

    /**
     * Test to check if the method throw a NickAlreadyInUseException
     */
    @Test
    public void connectNickAlreadyUse() {
        Assertions.assertThrows(NickAlreadyInUseException.class, () -> {
            this.controller.connect(stubIRCBot.TEST_URI_NICK_ALREADY_USE, stubIRCBot.TEST_PORT, stubIRCBot.TEST_TOKEN);
        });
    }

    /**
     * Test to check if the method throw a IrcException
     */
    @Test
    public void connectNotLetJoin() {
        Assertions.assertThrows(IrcException.class, () -> {
            this.controller.connect(stubIRCBot.TEST_URI_NOT_LET_JOIN, stubIRCBot.TEST_PORT, stubIRCBot.TEST_TOKEN);
        });
    }
}
