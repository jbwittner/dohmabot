package fr.bot.dohmabot.server.controllers;

import fr.bot.dohmabot.bot.IRCBot;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class ConfigurationController {

    @Resource
    private IRCBot ircBot;

    @RequestMapping("/connect")
    public boolean connect(final String uri, final Integer port, final String token)
            throws IOException, IrcException, NickAlreadyInUseException {
        boolean isConnected;
        isConnected = this.ircBot.toConnect(uri, port, token);
        return isConnected;
    }

    @RequestMapping("/joinChannel")
    public void joinChannel(final String channel){
        final String channelToConnect = "#" + channel;
        this.ircBot.joinIRCChannel(channelToConnect);
    }

    @RequestMapping("/sendMessage")
    public void sendMessage(final String channel, final String message){
        final String channelToSendMessage = "#" + channel;
        this.ircBot.sendIRCMessage(channelToSendMessage, message);
    }
}
