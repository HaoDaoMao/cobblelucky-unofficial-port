package com.scouter.cobblelucky.blocks;

import com.mojang.logging.LogUtils;
import com.scouter.cobblelucky.util.CLTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CobblemonLuckyItemBlock extends Block {

    private static final Logger LOGGER = LogUtils.getLogger();

    public CobblemonLuckyItemBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            Item randomItem = getRandomCobblemonItem(level);

            ItemStack randomItemStack = new ItemStack(randomItem);

            if (randomItemStack.is(Items.AIR)) {
                player.sendSystemMessage(Component.translatable("cobblelucky.item_fail.get").withStyle(ChatFormatting.RED));
            } else {
                try {
                    ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, randomItemStack);
                    level.addFreshEntity(itemEntity);
                } catch (Exception e) {
                    LOGGER.error("Something went wrong generating a random item", e);
                }
            }

            level.destroyBlock(pos, false);
        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    private Item getRandomCobblemonItem(Level level) {
        // First try the tag
        var tagResult = BuiltInRegistries.ITEM.getTag(CLTags.Items.COBBLEMON_ITEMS);
        if (tagResult.isPresent() && tagResult.get().size() > 0) {
            return tagResult.get().getRandomElement(level.getRandom()).map(Holder::value).orElse(Items.AIR);
        }

        // Fallback: collect all items from the cobblemon namespace
        List<Item> cobblemonItems = new ArrayList<>();
        for (Item item : BuiltInRegistries.ITEM) {
            if (BuiltInRegistries.ITEM.getKey(item).getNamespace().equals("cobblemon")) {
                cobblemonItems.add(item);
            }
        }

        if (cobblemonItems.isEmpty()) {
            return Items.AIR;
        }

        return cobblemonItems.get(level.random.nextInt(cobblemonItems.size()));
    }
}