package net.haipadev.starvation.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public class OnPlayerJoinWorldProcedure {
	public OnPlayerJoinWorldProcedure() {
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			execute(handler.getPlayer().level(), handler.getPlayer());
		});
	}

	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ConfigWriteProcedure.execute();
		if (world.getDifficulty() == Difficulty.PEACEFUL) {
			StarvePlayerBelowProcedure.execute(world, entity);
		}
		if (world.getDifficulty() == Difficulty.EASY) {
			StarvePlayerBelowProcedure.execute(world, entity);
		}
	}
}
