package net.haipadev.starvation_configured.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

public class OnPlayerRespawnProcedure {
	public OnPlayerRespawnProcedure() {
		ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
			execute(newPlayer.level(), newPlayer);
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
