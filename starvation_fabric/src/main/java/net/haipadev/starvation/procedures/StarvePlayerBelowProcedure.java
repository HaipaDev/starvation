package net.haipadev.starvation.procedures;

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

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.Gson;

public class StarvePlayerBelowProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		File file = new File("");
		com.google.gson.JsonObject json = new com.google.gson.JsonObject();
		Entity entity_ = null;
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
		double healthToDieFromStarvationHard = 0;
		double peacefulDealDamageFrom = 0;
		hardStarveDmg = 4;
		normalStarveDmg = 2;
		easyStarveDmg = 1;
		peacefulStarveDmg = 0;
		hardDealDamageTill = 0;
		normalDealDamageTill = 0;
		easyDealDamageTill = 0;
		peacefulDealDamageTill = 0;
		peacefulDealDamageFrom = 10;
		healthToDieFromStarvationHard = 2;
		healthToDieFromStarvationNormal = 2;
		healthToDieFromStarvationEasy = 2;
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
					if (json.has("hardStarveDmg")) {
						hardStarveDmg = json.get("hardStarveDmg").getAsDouble();
					}
					if (json.has("normalStarveDmg")) {
						normalStarveDmg = json.get("normalStarveDmg").getAsDouble();
					}
					if (json.has("easyStarveDmg")) {
						easyStarveDmg = json.get("easyStarveDmg").getAsDouble();
					}
					if (json.has("peacefulStarveDmg")) {
						peacefulStarveDmg = json.get("peacefulStarveDmg").getAsDouble();
					}
					if (json.has("hardDealDamageTill")) {
						hardDealDamageTill = json.get("hardDealDamageTill").getAsDouble();
					}
					if (json.has("normalDealDamageTill")) {
						normalDealDamageTill = json.get("normalDealDamageTill").getAsDouble();
					}
					if (json.has("easyDealDamageTill")) {
						easyDealDamageTill = json.get("easyDealDamageTill").getAsDouble();
					}
					if (json.has("peacefulDealDamageTill")) {
						peacefulDealDamageTill = json.get("peacefulDealDamageTill").getAsDouble();
					}
					if (json.has("peacefulDealDamageFrom")) {
						peacefulDealDamageFrom = json.get("peacefulDealDamageFrom").getAsDouble();
					}
					if (json.has("healthToDieFromStarvationHard")) {
						healthToDieFromStarvationHard = json.get("healthToDieFromStarvationHard").getAsDouble();
					}
					if (json.has("healthToDieFromStarvationNormal")) {
						healthToDieFromStarvationNormal = json.get("healthToDieFromStarvationNormal").getAsDouble();
					}
					if (json.has("healthToDieFromStarvationEasy")) {
						healthToDieFromStarvationEasy = json.get("healthToDieFromStarvationEasy").getAsDouble();
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
		if (world.getDifficulty() == Difficulty.EASY) {
			if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 0) {
				entity_ = null;
			}
			if (easyStarveDmg == 0) {
				if (entity_ instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
				if ((entity_ instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 1) {
					if (entity_ instanceof Player _player)
						_player.getFoodData().setFoodLevel(1);
				}
			}
			if ((entity_ instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 0) {
				if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= healthToDieFromStarvationEasy) {
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
				if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 11) {
					if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > easyDealDamageTill) {
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
							}, (float) Math.min(Math.abs((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - easyDealDamageTill), easyStarveDmg));
					}
					if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 0) {
						entity_ = null;
					}
					if (!(entity_ == null)) {
						new Object() {
							private int ticks = 0;

							public void startDelay(LevelAccessor world) {
								ServerTickEvents.END_SERVER_TICK.register((server) -> {
									this.ticks++;
									if (this.ticks == 80) {
										StarvePlayerBelowProcedure.execute(world, entity);
										return;
									}
								});
							}
						}.startDelay(world);
					}
				}
			} else {
				if (!(entity_ == null)) {
					new Object() {
						private int ticks = 0;

						public void startDelay(LevelAccessor world) {
							ServerTickEvents.END_SERVER_TICK.register((server) -> {
								this.ticks++;
								if (this.ticks == 5) {
									StarvePlayerBelowProcedure.execute(world, entity);
									return;
								}
							});
						}
					}.startDelay(world);
				}
			}
		}
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
				if (peacefulStarveDmg == 0) {
					if (entity_ instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
					if ((entity_ instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 1) {
						if (entity_ instanceof Player _player)
							_player.getFoodData().setFoodLevel(1);
					}
				}
				if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > peacefulDealDamageTill && (entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= peacefulDealDamageFrom) {
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
				} else {
					if (entity_ instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 1));
					if ((entity_ instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) <= 1) {
						if (entity_ instanceof Player _player)
							_player.getFoodData().setFoodLevel(1);
					}
				}
				if ((entity_ instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 0) {
					entity_ = null;
				}
				if (!(entity_ == null)) {
					new Object() {
						private int ticks = 0;

						public void startDelay(LevelAccessor world) {
							ServerTickEvents.END_SERVER_TICK.register((server) -> {
								this.ticks++;
								if (this.ticks == 80) {
									StarvePlayerBelowProcedure.execute(world, entity);
									return;
								}
							});
						}
					}.startDelay(world);
				}
			} else {
				if (!(entity_ == null)) {
					new Object() {
						private int ticks = 0;

						public void startDelay(LevelAccessor world) {
							ServerTickEvents.END_SERVER_TICK.register((server) -> {
								this.ticks++;
								if (this.ticks == 5) {
									StarvePlayerBelowProcedure.execute(world, entity);
									return;
								}
							});
						}
					}.startDelay(world);
				}
			}
		}
	}
}
