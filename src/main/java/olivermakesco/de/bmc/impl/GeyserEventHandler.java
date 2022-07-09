package olivermakesco.de.bmc.impl;

import net.minecraft.core.Registry;
import net.minecraft.world.item.TieredItem;
import org.geysermc.geyser.api.event.Subscribe;
import org.geysermc.geyser.api.event.lifecycle.GeyserDefineCustomItemsEvent;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.api.item.custom.NonVanillaCustomItemData;
import org.geysermc.geyser.item.GeyserNonVanillaCustomItemData;

public class GeyserEventHandler implements Extension {
    @Subscribe
    public void onGeyserPreInitializeEvent(GeyserDefineCustomItemsEvent event) {
        for (var item : Registry.ITEM) {
            var identifier = Registry.ITEM.getKey(item);
            if (identifier.getNamespace().equals("minecraft")) return;

            var isTool = item instanceof TieredItem;
            event.register((NonVanillaCustomItemData)new GeyserNonVanillaCustomItemData.NonVanillaCustomItemDataBuilder()
                            .name(identifier.getPath())
                            .identifier(identifier.toString())
                            .javaId(Registry.ITEM.getId(item))
                            .tool(isTool)
                            .maxDamage(item.getMaxDamage())
                            .stackSize(item.getMaxStackSize())
                            .translationString(item.getDescriptionId())
                            .icon("stick")
                            .build());
        }
    }
}
