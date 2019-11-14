package fr.bot.dohmabot.bot;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import java.io.IOException;

public interface IRCBot {

    boolean toConnect(String uri, Integer port, String token) throws IOException, IrcException, NickAlreadyInUseException;
    void joinIRCChannel(String channel);
    void sendIRCMessage(String channel, String message);
    void toDisconnect();
}
