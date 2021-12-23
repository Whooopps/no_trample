package com.no.trample.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(FarmlandBlock.class)
public class noTrampleMixin extends Block {
    public noTrampleMixin(Settings settings) {
        super(settings);
    }

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FarmlandBlock;setToDirt(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V"), method = "onLandedUpon", cancellable = true)
    public void checkEntitiy(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance,
            CallbackInfo info) {
        if (entity != null) {

            super.onLandedUpon(world, state, pos, entity, fallDistance);
            info.cancel();

        }

    }

}