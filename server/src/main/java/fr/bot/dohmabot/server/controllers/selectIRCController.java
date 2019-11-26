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

    /**
     * Methode to check if the IRC message is a command (!command)
     * @param ircMessage Message to check
     * @return True if the message is a command else False
     */
    private Boolean isCommand(final IRCMessage ircMessage){
        boolean result = false;
        final String message = ircMessage.getMessage();

        result = Pattern.compile(this.pattern).matcher(message).find();

        return result;
    }

    /**
     * Methode to extract the command on the message
     * @param ircMessage Input message
     * @return Command extracted
     */
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

    /**
     * Methode to select the IRC controller
     * @param command Command extract of the message
     * @param ircMessage Input message
     */
    private void switchCommand(final String command,final IRCMessage ircMessage){

        ircMessage.getChannel();

        switch (command){
            default:
                // Do nothing
        }

    }

}
