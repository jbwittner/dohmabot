package fr.bot.dohmabot.tests.controllers.rest.configuration;

import fr.bot.dohmabot.server.controllers.rest.configurationController;
import fr.bot.dohmabot.tools.Stub.StubIRCBot;
import org.junit.jupiter.api.BeforeEach;

public class configurationTest {

    protected configurationController controller;

    @BeforeEach
    public void setUp() throws Exception {
        this.controller = new configurationController(new StubIRCBot());
    }
}
