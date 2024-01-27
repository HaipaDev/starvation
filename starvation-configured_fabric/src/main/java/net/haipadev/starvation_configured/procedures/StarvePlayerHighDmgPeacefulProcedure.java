package net.haipadev.starvation_configured.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class StarvePlayerHighDmgPeacefulProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity entity_ = null;
		File file = new File("");
		double normalDealDamageTill = 0;
		double hardDealDamageTill = 0;
		double easyStarveDmg = 0;
		double peacefulStarveDmg = 0;
		double easyDealDamageTill = 0;
		double healthToDieFromStarvationEasy = 0;
		double normalStarveDmg = 0;
		double peacefulDealDamageTill = 0;
		double hardStarveDmg = 0;
		double healthToDieFromStarvationNormal = 0;
		double healthToDieFromStarvationPeaceful = 0;
		double peacefulDealDamageFrom = 0;
		double healthToDieFromStarvationHard = 0;
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		peacefulStarveDmg = 0;
		peacefulDealDamageTill = 0;
		peacefulDealDamageFrom = 10;
		healthToDieFromStarvationPeaceful = 2;
		file = (File) new File((Minecraft.getInstance().gameDirectory + "/config/"), File.separator + "starvation.json");
		if (file.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					json = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (json.has("peacefulStarveDmg")) {
						peacefulStarveDmg = json.get("peacefulStarveDmg").getAsDouble();
					}
					if (json.has("peacefulDealDamageTill")) {
						peacefulDealDamageTill = json.get("peacefulDealDamageTill").getAsDouble();
					}
					if (json.has("peacefulDealDamageFrom")) {
						peacefulDealDamageFrom = json.get("peacefulDealDamageFrom").getAsDouble();
					}
					if (json.has("healthToDieFromStarvationPeaceful")) {
						healthToDieFromStarvationPeaceful = json.get("healthToDieFromStarvationPeaceful").getAsDouble();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		entity_ = entity;
		if (world.getDifficulty() == Difficulty.PEACEFUL) {
			if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 0) {
				entity_ = null;
			}
			if ((entity_ instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 0) {
				if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= healthToDieFromStarvationPeaceful) {
					if (entity_ instanceof LivingEntity _entity)
						_entity.hurt(new DamageSource(_entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)) {
							@Override
							public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
								String _translatekey = "death.attack." + "starvation";
								if (this.getEntity() == null && this.getDirectEntity() == null) {
									return _msgEntity.getKillCredit() != null
											? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
											: Component.translatable(_translatekey, _msgEntity.getDisplayName());
								} else {
									Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
									ItemStack _itemstack = ItemStack.EMPTY;
									if (this.getEntity() instanceof LivingEntity _livingentity)
										_itemstack = _livingentity.getMainHandItem();
									return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
											? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
											: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
								}
							}
						}, 255);
					entity_ = null;
				}
				if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > peacefulDealDamageTill) {
					if (entity_ instanceof LivingEntity _entity)
						_entity.hurt(new DamageSource(_entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)) {
							@Override
							public Component getLocalizedDeathMessage(LivingEntity _msgEntity) {
								String _translatekey = "death.attack." + "starvation";
								if (this.getEntity() == null && this.getDirectEntity() == null) {
									return _msgEntity.getKillCredit() != null
											? Component.translatable(_translatekey + ".player", _msgEntity.getDisplayName(), _msgEntity.getKillCredit().getDisplayName())
											: Component.translatable(_translatekey, _msgEntity.getDisplayName());
								} else {
									Component _component = this.getEntity() == null ? this.getDirectEntity().getDisplayName() : this.getEntity().getDisplayName();
									ItemStack _itemstack = ItemStack.EMPTY;
									if (this.getEntity() instanceof LivingEntity _livingentity)
										_itemstack = _livingentity.getMainHandItem();
									return !_itemstack.isEmpty() && _itemstack.hasCustomHoverName()
											? Component.translatable(_translatekey + ".item", _msgEntity.getDisplayName(), _component, _itemstack.getDisplayName())
											: Component.translatable(_translatekey, _msgEntity.getDisplayName(), _component);
								}
							}
						}, (float) Math.min(Math.abs((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - peacefulDealDamageTill), peacefulStarveDmg));
				}
				if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 0) {
					entity_ = null;
				}
			}
		}
	}
}
