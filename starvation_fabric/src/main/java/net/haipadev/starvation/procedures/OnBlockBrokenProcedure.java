package net.haipadev.starvation.procedures;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;

public class OnBlockBrokenProcedure {
	public OnBlockBrokenProcedure() {
		PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockentity) -> {
			execute();
			return true;
		});
	}

	public static void execute() {
		ConfigWriteProcedure.execute();
	}
}
