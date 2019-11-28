package fr.bot.dohmabot.tests.controllers.selectirccontroller.selectcontroller;

import fr.bot.dohmabot.bot.IRCMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import fr.bot.dohmabot.server.controllers.selectIRCController;

public class isCommandTest extends selectControllerTest{

    private final String commandName = "isCommand";

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void isCommandOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.commandOk);

        result = (boolean) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertTrue(result);

    }

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void isCommandFail() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.commandFail);

        result = (boolean) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertFalse(result);

    }

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void isCommandMultipleCommand() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.multipleCommand);

        result = (boolean) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertTrue(result);

    }

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void isCommandArguments() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.commandAndArgument);

        result = (boolean) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertTrue(result);

    }

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void isCommandStringAndCommand() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.stringAndCommand);

        result = (boolean) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertFalse(result);

    }
}
