package fr.bot.dohmabot.server.controllers;

import fr.bot.dohmabot.bot.IRCMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to select the controller in function of command use in the chat
 */
public class selectIRCController {

    private final String pattern = "[!][a-z]+";

    /**
     * Methode to check and select the controller in function of the command
     * @param ircMessage Input message
     */
    public void selectController(final IRCMessage ircMessage){
        boolean isCommand;
        String command;

        isCommand = this.isCommand(ircMessage);

        if(isCommand == true){
            command = this.extractCommand(ircMessage);
            this.switchCommand(command, ircMessage);
        }

    }

    private boolean isCommand(final IRCMessage ircMessage){
        boolean result = false;
        final String message = ircMessage.getMessage();

        result = Pattern.matches(this.pattern, message);

        return result;
    }

    private String extractCommand(final IRCMessage ircMessage){
        final String message = ircMessage.getMessage();
        final Pattern pattern = Pattern.compile(this.pattern);
        final Matcher matcher = pattern.matcher(message);
        String command = "";

        if (matcher.find())
        {
            command = matcher.group();
        }

        return command;

    }

    private void switchCommand(final String command,final IRCMessage ircMessage){

        ircMessage.getChannel();

        switch (command){
            default:
                // Do nothing
        }

    }

}
