package com.scouter.cobblelucky.setup;

import com.scouter.cobblelucky.CobbleLucky;
import com.scouter.cobblelucky.blocks.CLBlocks;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.ArrayList;
import java.util.List;

public class ModSetup {

    public static void setup() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) return;

            // Inject lucky blocks into abandoned mineshaft chests
            if (ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft").equals(key.location())) {
                LootPool.Builder pool = LootPool.lootPool()
                        .setRolls(UniformGenerator.between(1, 4))
                        .add(LootItem.lootTableItem(CLBlocks.COBBLEMON_LUCKY_BLOCK.asItem())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(LootItem.lootTableItem(CLBlocks.COBBLEMON_LUCKY_ITEM_BLOCK.asItem())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))
                        .add(EmptyLootItem.emptyItem().setWeight(2));

                tableBuilder.withPool(pool);
            }
        });
    }
}