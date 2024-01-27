
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.haipadev.starvation_configured.init;

import net.haipadev.starvation_configured.procedures.StarvePlayerProcedure;
import net.haipadev.starvation_configured.procedures.StarvePlayerHighDmgPeacefulProcedure;
import net.haipadev.starvation_configured.procedures.StarvePlayerBelowProcedure;
import net.haipadev.starvation_configured.procedures.OnPlayerRespawnProcedure;
import net.haipadev.starvation_configured.procedures.OnPlayerJoinWorldProcedure;
import net.haipadev.starvation_configured.procedures.OnPlayerGoesToBedProcedure;
import net.haipadev.starvation_configured.procedures.OnBlockBrokenProcedure;
import net.haipadev.starvation_configured.procedures.ConfigWriteProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class StarvationConfiguredModProcedures {
	public static void load() {
		new ConfigWriteProcedure();
		new StarvePlayerProcedure();
		new OnPlayerRespawnProcedure();
		new OnPlayerJoinWorldProcedure();
		new OnBlockBrokenProcedure();
		new StarvePlayerBelowProcedure();
		new OnPlayerGoesToBedProcedure();
		new StarvePlayerHighDmgPeacefulProcedure();
	}
}
