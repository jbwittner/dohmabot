package fr.bot.dohmabot.tools.Stub;

import fr.bot.dohmabot.bot.IRCBotImpl;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StubIRCBot extends IRCBotImpl {

    public static final Integer TEST_PORT = 8080;
    public static final String TEST_TOKEN = "test_token";
    public static final String TEST_URI_OK = "http://uriok.com";
    public static final String TEST_URI_NOT_CONNECT = "http://notconnect.com";
    public static final String TEST_URI_IMPOSSIBLE_CONNECT = "http://impossibleconnect.com";
    public static final String TEST_URI_NOT_LET_JOIN = "http://urinotletjoin.com";
    public static final String TEST_URI_NICK_ALREADY_USE = "http://urinickalreadyuse.com";

    private List<String> listOfChannels = new ArrayList<>();

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

        boolean isConnected = false;

        if (!TEST_TOKEN.equals(token)){
            throw new IOException(TEST_URI_IMPOSSIBLE_CONNECT);
        }

        if (!TEST_PORT.equals(port)){
            throw new IOException(TEST_URI_IMPOSSIBLE_CONNECT);
        }

        switch (uri) {
            case TEST_URI_OK:
                isConnected = true;
                break;

            case TEST_URI_NOT_CONNECT:
                break;

            case TEST_URI_IMPOSSIBLE_CONNECT:
                throw new IOException(TEST_URI_IMPOSSIBLE_CONNECT);

            case TEST_URI_NOT_LET_JOIN:
                throw new IrcException(TEST_URI_NOT_LET_JOIN);

            case TEST_URI_NICK_ALREADY_USE:
                throw new NickAlreadyInUseException(TEST_URI_NICK_ALREADY_USE);

            default:
                // do Nothing
        }

        return isConnected;
    }

    /**
     * Joins a channel
     * @param channel The name of the channel to join
     */
    public void joinIRCChannel(final String channel){
        this.listOfChannels.add(channel);
    }

    /**
     * Returns an array of all channels that we are in.
     * Note that if you call this method immediately after joining a new channel,
     * the new channel may not appear in this array as it is not possible
     * to tell if the join was successful until a response is received from the IRC server.
     * @return
     */
    public String[] getChannel(){

        String[] channels;

        channels = this.listOfChannels.toArray(new String[0]);

        return channels;
    }

    /**
     * Sends a message to a channel.
     * @param channel The name of the channel to send to.
     * @param message The message to send
     */
    public void sendIRCMessage(final String channel, final String message){
        // do nothing
    }

    /**
     * This method disconnects from the server
     */
    public void disconnectToServer(){
        // do nothing
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
        // do nothing
    }

}
