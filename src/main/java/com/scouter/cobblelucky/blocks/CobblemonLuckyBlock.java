package com.scouter.cobblelucky.blocks;

import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class CobblemonLuckyBlock extends Block {

    private static final Logger LOGGER = LogUtils.getLogger();

    public CobblemonLuckyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide && level instanceof ServerLevel serverLevel) {
            try {
                PokemonProperties randomProp = PokemonProperties.Companion.parse("species=random", " ", "=");
                randomProp.setLevel(level.random.nextInt(1, 100));
                Pokemon pokemon = randomProp.create();
                pokemon.sendOut(serverLevel, Vec3.atCenterOf(pos), null, (Function1<PokemonEntity, Unit>) (entity) -> Unit.INSTANCE);
            } catch (Exception e) {
                LOGGER.error("Something went wrong generating a random pokemon", e);
            }
        }
        return super.playerWillDestroy(level, pos, state, player);
    }
}