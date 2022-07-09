package olivermakesco.de.bmc.mixin;

import olivermakesco.de.bmc.impl.GeyserEventHandler;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.geysermc.geyser.GeyserImpl;
import org.geysermc.geyser.api.extension.Extension;
import org.geysermc.geyser.extension.GeyserExtensionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = GeyserExtensionManager.class, remap = false)
public abstract class InjectGeyserInit {

    @Shadow public abstract void enableExtension(Extension extension);

    @Shadow public abstract void enable(@NonNull Extension extension);

    @Inject(method = "init", at = @At(value = "INVOKE", target = "Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"))
    public void onGeyserInit(CallbackInfo ci) {
        // TODO better way to inject into event handler. We should really set up a full extension
        var geyserExtension = new GeyserEventHandler();
        GeyserImpl.getInstance().eventBus().register(geyserExtension, geyserExtension);
    }
}
