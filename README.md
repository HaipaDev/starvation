Simple configurable mod allowing you to edit how much damage does starving deal per difficulty level and if its possible to die (0 will disable death from starvation, 20 or whatever higher will make you instantly die)
### THIS MOD DOES NOT ENABLE STARVATION ON PEACEFUL, IT JUST PROVIDES THE ABILITY TO MAKE A PLAYER DIE OF "STARVATION", for prior functionality check out other mods like:

[https://modrinth.com/mod/hungy](https://modrinth.com/mod/hungy)
For this mod set "peacefulDealDamageFrom": 10

[https://modrinth.com/mod/hunger-in-peaceful](https://modrinth.com/mod/hunger-in-peaceful)
For this mod set "peacefulDealDamageFrom": 20 (I think?)

Default values:
```
{
  "hardStarveDmg": 4,  ## 2 hearts
  "normalStarveDmg": 2,  ## 1 heart
  "easyStarveDmg": 1,  ## half a heart
  "peacefulStarveDmg": 1,
  "hardDealDamageTill": 0,  ## deal damage till this amount of health, so 0 will make it possible to die
  "normalDealDamageTill": 0,  ## the vanilla default would be 1
  "easyDealDamageTill": 0,  ## the vanilla default would be 10
  "peacefulDealDamageTill": 0,
  "peacefulDealDamageFrom": 10,  ## compatibility variable for other mods so you dont take damage twice (other mods fake it like your on Easy so vanilla ticks down to 10 hp)
  "healthToDieFromStarvationHard": 1,
  "healthToDieFromStarvationNormal": 1,
  "healthToDieFromStarvationEasy": 1,
  "healthToDieFromStarvationPeaceful": 1
}
```
First of all it uses "faked" starvation custom damage, that is only localized in English, Polish and Japanese with ` %1$s starved to death. ` (for the localization to work its required on the client!)
If you know how to get your own language in, go ahead, if you want to contribute a translation or whatever else; also go ahead Ill probably accept a [https://github.com/HaipaDev/starvation/pulls](pr)

Unfortunately on Easy and Peaceful it can be a bit scuffed and possibly cheesable because its counting a timer to deal damage above the vanilla limit after vanilla did its thing, I cannot make the check run on player based ticks or whatever.

Also setting the value of dealDamageTill above vanilla in any difficulty will also be a tiny bit scuffed, it will still "damage" you but then you will get 0.5 hunger when at the set limit so vanilla stops, I cant cancel the damage unfortunately.
Setting damage to 0 will make you not take any starvation damage (look point above, it can only damage you once at full health) and will bring back 0.5 hunger