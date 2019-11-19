package fr.bot.dohmabot.server.controllers;

import fr.bot.dohmabot.bot.IRCBot;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Controller to configure the bot
 * @author Jean-Baptiste WITTNER
 */
@RestController
public class ConfigurationController {

    @Resource
    private IRCBot ircBot;

    /**
     * Request to set the Bot connection
     * @param uri Address of the IRC Server
     * @param port Port of the IRC Server
     * @param token Token used to authenticate the bot
     * @return Return code 200 if ok
     * @throws IOException if it was not possible to connect to the server
     * @throws IrcException if the server would not let us join it
     * @throws NickAlreadyInUseException if our nick is already in use on the server.
     */
    @RequestMapping("/connect")
    public boolean connect(final String uri, final Integer port, final String token)
            throws IOException, IrcException, NickAlreadyInUseException {
        boolean isConnected;
        isConnected = this.ircBot.connectToServer(uri, port, token);
        return isConnected;
    }

    /**
     * Request to connect the bot on a channel
     * @param channel The name of the channel to join
     */
    @RequestMapping("/joinChannel")
    public void joinChannel(final String channel){
        final String channelToConnect = "#" + channel;
        this.ircBot.joinIRCChannel(channelToConnect);
    }

    /**
     * Request for send a message with the bot on a channel
     * @param channel The name of the channel to send a message
     * @param message Message to send
     */
    @RequestMapping("/sendMessage")
    public void sendMessage(final String channel, final String message){
        final String channelToSendMessage = "#" + channel;
        this.ircBot.sendIRCMessage(channelToSendMessage, message);
    }
}
