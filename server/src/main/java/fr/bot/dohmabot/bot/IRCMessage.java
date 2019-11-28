package fr.bot.dohmabot.bot;

/**
 * Class use to transfert a IRC message and his informations
 */
public class IRCMessage {

    private String channel;
    private String sender;
    private String login;
    private String hostname;
    private String message;

    /**
     * Constructor of IRCMessage
     * @param channel Channel where are send the message
     * @param sender Sender who send the message
     * @param login Login of the sender
     * @param hostname Hostname of the sender
     * @param message Message
     */
    public IRCMessage(final String channel,
                      final String sender,
                      final String login,
                      final String hostname,
                      final String message) {

        this.channel = channel;
        this.sender = sender;
        this.login = login;
        this.hostname = hostname;
        this.message = message;
    }


    public String getChannel() {
        return channel;
    }

    public String getSender() {
        return sender;
    }

    public String getLogin() {
        return login;
    }

    public String getHostname() {
        return hostname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
