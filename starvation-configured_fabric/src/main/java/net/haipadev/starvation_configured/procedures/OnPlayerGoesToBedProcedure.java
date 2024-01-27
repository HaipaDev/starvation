package net.haipadev.starvation_configured.procedures;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;

public class OnPlayerGoesToBedProcedure {
	public OnPlayerGoesToBedProcedure() {
		EntitySleepEvents.STOP_SLEEPING.register((entity, blockPos) -> {
			execute();
		});
	}

	public static void execute() {
	}
}
