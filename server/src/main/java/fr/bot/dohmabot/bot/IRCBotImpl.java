package fr.bot.dohmabot.bot;

import fr.bot.dohmabot.server.DTO.messageChannelDTO;
import fr.bot.dohmabot.server.controllers.irc.selectIRCController;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.PircBot;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Implementation of IRCBot.java
 * @author Jean-Baptiste WITTNER
 * @see fr.bot.dohmabot.bot.IRCBot
 */
@Service
public class IRCBotImpl extends PircBot implements IRCBot {

    public static final String BOT_NAME = "DohMaBot";
    private selectIRCController selectIRCController = new selectIRCController();

    /**
     * Constructor of IRCBotImpl
     */
    public IRCBotImpl(){
        super();
        this.setName(BOT_NAME);
        this.isConnected();
        this.setVerbose(true);
    }

    /**
     * Attempt to connect to the specified IRC server using the supplied password.
     * The onConnect method is called upon success.
     * @param uri Address of the IRC Server
     * @param port Port of the IRC Server
     * @param token Token used to authenticate the bot
     * @return true if connected, else false
     * @throws IOException if it was not possible to connect to the server
     * @throws IrcException if the server would not let us join it
     * @throws NickAlreadyInUseException if our nick is already in use on the server.
     */
    public boolean connectToServer(final String uri, final Integer port, final String token)
            throws IOException, IrcException, NickAlreadyInUseException {
        boolean isConnected;
        this.connect(uri, port, token);
        isConnected = this.isConnected();
        return isConnected;
    }

    /**
     * Joins a channel
     * @param channel The name of the channel to join
     */
    public void joinIRCChannel(final String channel){
        this.joinChannel(channel);
    }

    /**
     * Returns an array of all channels that we are in.
     * Note that if you call this method immediately after joining a new channel,
     * the new channel may not appear in this array as it is not possible
     * to tell if the join was successful until a response is received from the IRC server.
     * @return Array of String of channels
     */
    public String[] getChannel(){
        String[] channels;

        channels = super.getChannels();

        return channels;
    }

    /**
     * Sends a message to a channel.
     * @param channel The name of the channel to send to.
     * @param message The message to send
     */
    public void sendIRCMessage(final String channel, final String message){
        this.sendMessage(channel, message);
    }

    /**
     * This method disconnects from the server
     */
    public void disconnectToServer(){
        super.disconnect();
    }

    /**
     * This method is called whenever a message is sent to a channel
     * @param channel The channel to which the message was sent
     * @param sender The nick of the person who sent the message
     * @param login The login of the person who sent the message
     * @param hostname The hostname of the person who sent the message
     * @param message The actual message sent to the channel
     */
    public void onMessage(String channel, String sender, String login, String hostname, String message){
        messageChannelDTO messageChannel = new messageChannelDTO(channel, sender, login, hostname, message);
        this.selectIRCController.facingController(messageChannel);
    };
}
