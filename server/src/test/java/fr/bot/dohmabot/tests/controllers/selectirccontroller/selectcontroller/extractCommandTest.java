package fr.bot.dohmabot.tests.controllers.selectirccontroller.selectcontroller;

import fr.bot.dohmabot.bot.IRCMessage;
import fr.bot.dohmabot.server.controllers.selectIRCController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class extractCommandTest extends selectIRCControllerTest {

    private final String commandName = "extractCommand";

    private final String commandOkResult = "!testcommandOk";
    private final String commandFailResult = "";
    private final String multipleCommandResult = "!testcommand1";
    private final String commandAndArgumentResult = "!testcommand";
    private final String stringAndCommandResult = "";

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void extractCommandOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.commandOk);

        result = (String) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertEquals(this.commandOkResult, result);

    }

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void extractCommandFail() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.commandFail);

        result = (String) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertEquals(this.commandFailResult, result);

    }

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void extractCommandMultipleCommand() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.multipleCommand);

        result = (String) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertEquals(this.multipleCommandResult, result);

    }

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void extractCommandArguments() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.commandAndArgument);

        result = (String) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertEquals(this.commandAndArgumentResult, result);

    }

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void extractCommandStringAndCommand() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.stringAndCommand);

        result = (String) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertEquals(this.stringAndCommandResult, result);

    }
}
