package fr.bot.dohmabot.tests.controllers.selectirccontroller.selectcontroller;

import fr.bot.dohmabot.bot.IRCMessage;
import fr.bot.dohmabot.server.controllers.selectIRCController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class switchCommandTest extends selectIRCControllerTest {

    private final String commandName = "switchCommand";

    /**
     * Test to check the answer when the inputs are ok
     */
    @Test
    public void switchCommandOk() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean result;
        Method method;

        method = selectIRCController.class.getDeclaredMethod(this.commandName, String.class, IRCMessage.class);

        method.setAccessible(true);

        this.inputIRCMessage.setMessage(this.commandOk);

        result = (boolean) method.invoke(this.selectController, this.commandOk, this.inputIRCMessage);

        Assertions.assertTrue(result);

    }

}
