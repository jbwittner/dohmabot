package fr.bot.dohmabot.bot;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.PircBot;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IRCBotImpl extends PircBot implements IRCBot {
    
    public IRCBotImpl(){
        super();
        this.setName("Dohmabot");
        this.isConnected();
        this.setVerbose(true);
    }

    public boolean toConnect(final String uri, final Integer port, final String token)
            throws IOException, IrcException, NickAlreadyInUseException {
        boolean isConnected;
        this.connect(uri, port, token);
        isConnected = this.isConnected();
        return isConnected;
    }

    public void joinIRCChannel(final String channel){
        this.joinChannel(channel);
    }

    public void sendIRCMessage(final String channel, final String message){
        this.sendMessage(channel, message);
    }

    public void disconnectToServer(){
        super.disconnect();
    }
}
