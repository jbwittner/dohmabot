package fr.bot.dohmabot.tests.controllers.rest.configuration;

import fr.bot.dohmabot.server.controllers.rest.configurationController;
import fr.bot.dohmabot.tools.stub.stubIRCBot;
import org.junit.jupiter.api.BeforeEach;

/**
 * Mother class of configuration tests
 */
public class configurationTest {

    protected configurationController controller;

    /**
     * Setup of each configuration tests
     */
    @BeforeEach
    public void setUp() {
        this.controller = new configurationController(new stubIRCBot());
    }
}
