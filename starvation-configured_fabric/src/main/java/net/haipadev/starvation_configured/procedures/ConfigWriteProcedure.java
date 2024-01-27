package net.haipadev.starvation_configured.procedures;

import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class ConfigWriteProcedure {
	public static void execute() {
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		file = (File) new File((Minecraft.getInstance().gameDirectory + "/config/"), File.separator + "starvation.json");
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			json.addProperty("hardStarveDmg", 4);
			json.addProperty("normalStarveDmg", 2);
			json.addProperty("easyStarveDmg", 1);
			json.addProperty("peacefulStarveDmg", 1);
			json.addProperty("hardDealDamageTill", 0);
			json.addProperty("normalDealDamageTill", 0);
			json.addProperty("easyDealDamageTill", 0);
			json.addProperty("peacefulDealDamageTill", 0);
			json.addProperty("peacefulDealDamageFrom", 10);
			json.addProperty("healthToDieFromStarvationHard", 2);
			json.addProperty("healthToDieFromStarvationNormal", 2);
			json.addProperty("healthToDieFromStarvationEasy", 2);
			json.addProperty("healthToDieFromStarvationPeaceful", 2);
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(file);
					fileWriter.write(mainGSONBuilderVariable.toJson(json));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
