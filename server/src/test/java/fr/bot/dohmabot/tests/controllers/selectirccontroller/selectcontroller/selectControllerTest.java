package fr.bot.dohmabot.tests.controllers.selectirccontroller.selectcontroller;

import fr.bot.dohmabot.bot.IRCMessage;
import fr.bot.dohmabot.server.controllers.selectIRCController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A JUnit test case testing the selectController of selectIRCController.
 */
public class selectControllerTest extends selectIRCControllerTest {

    private final String commandName = "selectController";

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void selectControllerOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.commandOk);

        result = (boolean) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertTrue(result);

    }

    /**
     * Test to check the answer when the inputs are not ok
     */
    @Test
    public void selectControllerFail() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.commandFail);

        result = (boolean) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertFalse(result);

    }

    /**
     * Test to check the answer when the inputs have many commands
     */
    @Test
    public void selectControllerMultipleCommand() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.multipleCommand);

        result = (boolean) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertTrue(result);

    }

    /**
     * Test to check the answer when the inputs have arguments with the command
     */
    @Test
    public void selectControllerArguments() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.commandAndArgument);

        result = (boolean) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertTrue(result);

    }

    /**
     * Test to check the answer when the inputs have a string before the command
     */
    @Test
    public void selectControllerStringAndCommand() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        final Method method = selectIRCController.class.getDeclaredMethod(this.commandName, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.stringAndCommand);

        result = (boolean) method.invoke(this.selectController, this.inputIRCMessage);

        Assertions.assertFalse(result);

    }
}
