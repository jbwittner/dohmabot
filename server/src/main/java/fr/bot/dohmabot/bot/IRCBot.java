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
     * Returns an array of all channels that we are in.
     * Note that if you call this method immediately after joining a new channel,
     * the new channel may not appear in this array as it is not possible
     * to tell if the join was successful until a response
     * is received from the IRC server.
     * @return Array of String of channels
     */
    String[] getChannel();

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

    /**
     * This method is called whenever a message is sent to a channel
     * @param channel The channel to which the message was sent
     * @param sender The nick of the person who sent the message
     * @param login The login of the person who sent the message
     * @param hostname The hostname of the person who sent the message
     * @param message The actual message sent to the channel
     */
    void onMessage(final String channel,
                   final String sender,
                   final String login,
                   final String hostname,
                   final String message);
}
