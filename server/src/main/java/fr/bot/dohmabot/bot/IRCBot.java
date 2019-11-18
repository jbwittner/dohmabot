package fr.bot.dohmabot.bot;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import java.io.IOException;

/**
 * Interface to configure the IRC Bot
 * @author Jean-Baptiste WITTNER
 */
public interface IRCBot {

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
    boolean connectToServer(final String uri, final Integer port, final String token)
            throws IOException, IrcException, NickAlreadyInUseException;

    /**
     * Joins a channel
     * @param channel The name of the channel to join
     */
    void joinIRCChannel(final String channel);

    /**
     * Sends a message to a channel.
     * @param channel The name of the channel to send to.
     * @param message The message to send
     */
    void sendIRCMessage(final String channel, final String message);

    /**
     * This method disconnects from the server
     */
    void disconnectToServer();
}
