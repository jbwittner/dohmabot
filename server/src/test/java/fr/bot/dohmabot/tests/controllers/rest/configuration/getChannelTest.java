package fr.bot.dohmabot.tests.controllers.rest.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * A JUnit test case testing the getChannel method of configurationController.
 */
public class getChannelTest extends configurationTest{

    /**
     * Test to check if the values of getChannel are the same of the values
     * set by joinChannel
     */
    @Test
    public void returnListChannelOk() {

        final String[] inputChannels = {"channel1","channel2", "channel3", "channel4"};

        boolean result;
        String[] resultChannels;
        Integer index;
        String[] expectedResult = new String[inputChannels.length];

        for(index = 0; index < inputChannels.length; index++){
            this.controller.joinChannel(inputChannels[index]);
            expectedResult[index] = "#" + inputChannels[index];
        }

        resultChannels = this.controller.getChannel();

        result = Arrays.equals(resultChannels, expectedResult);

        Assertions.assertTrue(result);
    }
}
