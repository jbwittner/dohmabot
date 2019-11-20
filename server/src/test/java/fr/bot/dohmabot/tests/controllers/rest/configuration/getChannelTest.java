package fr.bot.dohmabot.tests.controllers.rest.configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class getChannelTest extends configurationTest{

    @Test
    public void getChannel() {
        boolean result;
        String[] resultChannels;
        Integer index;
        String[] inputChannels = {"channel1","channel2", "channel3", "channel4"};
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
