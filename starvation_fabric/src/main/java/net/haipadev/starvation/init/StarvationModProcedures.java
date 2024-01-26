
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.haipadev.starvation.init;

import net.haipadev.starvation.procedures.StarvePlayerProcedure;
import net.haipadev.starvation.procedures.StarvePlayerHighDmgPeacefulProcedure;
import net.haipadev.starvation.procedures.StarvePlayerBelowProcedure;
import net.haipadev.starvation.procedures.OnPlayerRespawnProcedure;
import net.haipadev.starvation.procedures.OnPlayerJoinWorldProcedure;
import net.haipadev.starvation.procedures.OnPlayerGoesToBedProcedure;
import net.haipadev.starvation.procedures.OnBlockBrokenProcedure;
import net.haipadev.starvation.procedures.ConfigWriteProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class StarvationModProcedures {
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
