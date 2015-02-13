package com.lopina.stackoverflow;

import java.util.HashMap;
import java.util.Map;

public class FollowerCombos {
	public static class Counters {
		private static Map<Abilities, Threats> counterMap = new HashMap<Abilities, Threats>();
		
		static {
			for (Abilities ability : Abilities.values()) {
				counterMap.put(ability, ability.getThreat());
			}
		}
		
		public static boolean canCounter(Abilities ability, Threats threat) {
			Threats counterThreat = counterMap.get(ability);
			
			return threat.equals(counterThreat);
		}
	}
	
	public static class Follower {
		public String spec;
		public Abilities ability1;
		public Abilities ability2;
		
		public Follower(String spec, Abilities ability1, Abilities ability2) {
			this.spec = spec;
			this.ability1 = ability1;
			this.ability2 = ability2;
		}
		
		public boolean counters(Threats threat) {
			return Counters.canCounter(ability1, threat) || Counters.canCounter(ability1, threat);
		}
	}
	
	public static final class Classes {
		public static final class DeathKnight {
			public static final class Blood {
				public static Abilities[] abilites;
				
				static {
					abilites = new Abilities[] {
							Abilities.BONE_SHIELD,
							Abilities.DARK_COMMAND,
							Abilities.DEATH_AND_DECAY,
							Abilities.EMPOWER_RUNE_WEAPON,
							Abilities.MIND_FREEZE
					};
				}
			}
			
			public static final class Frost {
				public static Abilities[] abilites;
				
				static {
					abilites = new Abilities[] {
							Abilities.ANTI_MAGIC_SHELL,
							Abilities.DARK_COMMAND,
							Abilities.DEATH_AND_DECAY,
							Abilities.EMPOWER_RUNE_WEAPON,
							Abilities.MIND_FREEZE
					};
				}
			}
			
			public static final class Unholy {
				public static Abilities[] abilites;
				
				static {
					abilites = new Abilities[] {
							Abilities.BONE_SHIELD,
							Abilities.DARK_COMMAND,
							Abilities.DEATH_AND_DECAY,
							Abilities.EMPOWER_RUNE_WEAPON,
							Abilities.MIND_FREEZE
					};
				}
			}
		}
	}
	
	public static enum Threats {
		DANGER_ZONES("Danger Zones"),
		DEADLY_MINIONS("Deadly Minions"),
		GROUP_DAMAGE("Group Damage"),
		MAGIC_DEBUFF("Magic_Debuff"),
		MASSIVE_STRIKE("Massive Strike"),
		MINION_SWARMS("Minion Swarms"),
		POWERFUL_SPELL("Danger Zones"),
		TIMED_BATTLE("Timed Battle"),
		WILD_AGGRESSION("Wild Aggression"),;
		
		private String threat;

		Threats(String threat) {
			this.threat = threat;
		}
	}
	
	public static enum Abilities {
		ANTI_MAGIC_SHELL("Anti-Magic Shell", Threats.MAGIC_DEBUFF),
		BONE_SHIELD("Bone Shield", Threats.MASSIVE_STRIKE),
		DARK_COMMAND("Dark Command", Threats.WILD_AGGRESSION),
		DEATH_AND_DECAY("Death and Decay", Threats.MINION_SWARMS),
		EMPOWER_RUNE_WEAPON("Empower Rune Weapon", Threats.TIMED_BATTLE),
		MIND_FREEZE("Mind Freeze", Threats.POWERFUL_SPELL),
		
		BARKSKIN("Barkskin", Threats.MASSIVE_STRIKE),
		BERSERK("Berserk", Threats.TIMED_BATTLE),
		CELESTIAL_ALIGNMENT("Celestial Alignment", Threats.TIMED_BATTLE),
		DASH("Dash", Threats.DANGER_ZONES),
		ENTANGLING_ROOTS("Entangling Roots", Threats.DEADLY_MINIONS),
		GROWL("Growl", Threats.WILD_AGGRESSION),
		HURRICANE("Hurricane", Threats.MINION_SWARMS),
		INNERVATE("Innervate", Threats.TIMED_BATTLE),
		NATURES_CURE("Nature's Cure", Threats.MAGIC_DEBUFF),
		WILD_GROWTH("Wild Growth", Threats.GROUP_DAMAGE),
		
		COUNTER_SHOT("Counter Shot", Threats.POWERFUL_SPELL),
		DETERRENCE("Deterrence", Threats.MASSIVE_STRIKE),
		DISENGAGE("Disengage", Threats.DANGER_ZONES),
		FEIGN_DEATH("Feigh Death", Threats.WILD_AGGRESSION),
		FREEZING_TRAP("Freezing Trap", Threats.DEADLY_MINIONS),
		MULTI_SHOT("Multi-Shot", Threats.MINION_SWARMS),
		RAPID_FIRE("Rapid Fire", Threats.TIMED_BATTLE),
		
		BLINK("Blink", Threats.DANGER_ZONES),
		BLIZZARD("Blizzard", Threats.MINION_SWARMS),
		CONJURE_FOOD("Conjure Food", Threats.TIMED_BATTLE),
		COUNTERSPELL("Counterspell", Threats.POWERFUL_SPELL),
		ICE_BLOCK("Ice Block", Threats.MASSIVE_STRIKE),
		POLYMORPH("Polymorph", Threats.DEADLY_MINIONS),
		TIME_WARP("Time Warp", Threats.TIMED_BATTLE),
		
		CHI_WAVE("Chi Wave", Threats.GROUP_DAMAGE),
		DETOX("Detox", Threats.MAGIC_DEBUFF),
		ENERGIZING_BREW("Energizing Brew", Threats.TIMED_BATTLE),
		GUARD("Guard", Threats.MASSIVE_STRIKE),
		MANA_TEA("Mana Tea", Threats.TIMED_BATTLE),
		PARALYSIS("Paralysis", Threats.DEADLY_MINIONS),
		PROVOKE("Provoke", Threats.WILD_AGGRESSION),
		ROLL("Roll", Threats.DANGER_ZONES),
		SPEAR_HAND_STRIKE("Spear Hand Strike", Threats.POWERFUL_SPELL),
		
		AVENGING_WRATH("Avenging Wrath", Threats.TIMED_BATTLE),
		CLEANSE("Cleanse", Threats.MAGIC_DEBUFF),
		DIVINE_PLEA("Divine Plea", Threats.TIMED_BATTLE),
		DIVINE_SHIELD("Divine Shield", Threats.MASSIVE_STRIKE),
		DIVINE_STORM("Divine Storm", Threats.MINION_SWARMS),
		HOLY_RADIANCE("Holy Radiance", Threats.GROUP_DAMAGE),
		REBUKE("Rebuke", Threats.POWERFUL_SPELL),
		RECKONING("Reckoning", Threats.WILD_AGGRESSION),
		REPENTANCE("Repentance", Threats.DEADLY_MINIONS),
		
		DISPEL_MAGIC("Dispel Magic", Threats.MAGIC_DEBUFF),
		DOMINATE_MIND("Dominate Mind", Threats.DEADLY_MINIONS),
		LEAP_OF_FAITH("Leap of Faith", Threats.DANGER_ZONES),
		MIND_SEAR("Mind Sear", Threats.MINION_SWARMS),
		POWER_INFUSION("Power Infusion", Threats.TIMED_BATTLE),
		PRAYER_OF_HEALING("Prayer of Healing", Threats.GROUP_DAMAGE),
		SHADOWFIEND("Shadowfiend", Threats.TIMED_BATTLE),
		
		EVASION("Evasion", Threats.MASSIVE_STRIKE),
		FAN_OF_KNIVES("Fan of Knives", Threats.MINION_SWARMS),
		KICK("Kick", Threats.POWERFUL_SPELL),
		MARKED_FOR_DEATH("Marked for Death", Threats.TIMED_BATTLE),
		SAP("Sap", Threats.DEADLY_MINIONS),
		SPRINT("Sprint", Threats.DANGER_ZONES),
		
		ASCENDANCE("Ascendance", Threats.TIMED_BATTLE),
		CHAIN_HEAL("Chain Heal", Threats.GROUP_DAMAGE),
		CHAIN_LIGHTNING("Chain Lightning", Threats.MINION_SWARMS),
		GHOST_WOLF("Ghost Wolf", Threats.DANGER_ZONES),
		HEX("Hex", Threats.DEADLY_MINIONS),
		PURIFY_SPIRIT("Purify Spirit", Threats.MAGIC_DEBUFF),
		WATER_SHIELD("Water Shield", Threats.TIMED_BATTLE),
		WIND_SHEAR("Wind Shear", Threats.POWERFUL_SPELL),
		
		DRAIN_LIFE("Drain Life", Threats.GROUP_DAMAGE),
		FEAR("Fear", Threats.DEADLY_MINIONS),
		METAMORPHOSIS("Metamorphosis", Threats.TIMED_BATTLE),
		RAIN_OF_FIRE("Rain of Fire", Threats.MINION_SWARMS),
		SINGE_MAGIC("Singe Magic", Threats.MAGIC_DEBUFF),
		SPELL_LOCK("Spell Lock", Threats.POWERFUL_SPELL),
		SUMMON_INFERNAL("Summon Infernal", Threats.TIMED_BATTLE),
		UNENDING_RESOLVE("Unending Resolve", Threats.MASSIVE_STRIKE),
		
		CLEAVE("Drain Life", Threats.MINION_SWARMS),
		HEROIC_LEAP("Fear", Threats.DANGER_ZONES),
		PUMMEL("Metamorphosis", Threats.POWERFUL_SPELL),
		RECKLESSNESS("Rain of Fire", Threats.TIMED_BATTLE),
		SHIELD_WALL("Singe Magic", Threats.MASSIVE_STRIKE),
		TAUNT("Spell Lock", Threats.WILD_AGGRESSION);
		
		private String ability;
		private Threats threat;

		Abilities(String ability, Threats threat) {
			this.ability = ability;
			this.threat = threat;
		}
		
		public String getAbility() {
			return ability;
		}
		
		public Threats getThreat() {
			return threat;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
