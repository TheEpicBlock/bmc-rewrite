package olivermakesco.de.bmc.impl;

import org.geysermc.geyser.api.event.Subscribe;
import org.geysermc.geyser.api.event.lifecycle.GeyserDefineCustomItemsEvent;
import org.geysermc.geyser.api.extension.Extension;

public class GeyserEventHandler implements Extension {
    @Subscribe
    public void onGeyserPreInitializeEvent(GeyserDefineCustomItemsEvent event) {
        System.out.println("Hello from onGeyserPreInitializeEvent :D");
    }
}
