package olivermakesco.de.bmc.testmod;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TestItem extends Item {
    public TestItem(Item.Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @Nullable Level level, List<Component> tooltip, @NotNull TooltipFlag tooltipFlag) {
        tooltip.add(Component.literal("Normal tooltip"));
        tooltip.add(Component.literal("Red tooltip").withStyle(ChatFormatting.RED));
        super.appendHoverText(itemStack, level, tooltip, tooltipFlag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        TestMod.debugSend(player, "[TestItem] use");
        return super.use(level, player, interactionHand);
    }
}
