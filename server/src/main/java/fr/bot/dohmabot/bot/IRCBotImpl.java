package fr.bot.dohmabot.bot;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.PircBot;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IRCBotImpl extends PircBot implements IRCBot {

    private String uri;

    public IRCBotImpl(){
        System.out.println("impl");
        this.setName("Dohmabot");
        this.isConnected();
        this.setVerbose(true);
    }

    public boolean toConnect(String uri, Integer port, String token) throws IOException, IrcException, NickAlreadyInUseException {
        boolean isConnected;
        System.out.println("connect");
        this.connect(uri, port, token);
        isConnected = this.isConnected();
        return isConnected;
    }

    public void joinIRCChannel(String channel){
        this.joinChannel(channel);
    }

    public void sendIRCMessage(String channel, String message){
        this.sendMessage(channel, message);
    }

    public void toDisconnect(){
        super.disconnect();
    }
}
