package fr.bot.dohmabot.bot;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import java.io.IOException;

public interface IRCBot {

    boolean toConnect(final String uri, final Integer port, final String token)
            throws IOException, IrcException, NickAlreadyInUseException;

    void joinIRCChannel(final String channel);

    void sendIRCMessage(final String channel, final String message);

    void disconnectToServer();
}
