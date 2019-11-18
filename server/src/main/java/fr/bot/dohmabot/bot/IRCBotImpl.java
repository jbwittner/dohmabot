package fr.bot.dohmabot.bot;

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

    /**
     * Constructor of IRCBotImpl
     */
    public IRCBotImpl(){
        super();
        this.setName("Dohmabot");
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
}
