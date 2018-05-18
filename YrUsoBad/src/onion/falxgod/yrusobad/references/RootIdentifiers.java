package onion.falxgod.yrusobad.references;

import java.util.Arrays;

public enum RootIdentifiers {
	FACTION("faction"),
	TYPE("type"),
	TIER("tier"),
	UNIT_NAME("unit name"),
	STATS("stats"),
	CONSUMABLES("consumables"),
	
	
	FACTION_BARBARIAN("barbarian"),
	FACTION_ROMAN("roman"),
	FACTION_GREEK("greek"),
	FACTION_CARTHAGE("carthage"),
	
	TYPE_FALX("falx"),
	TYPE_SWORD("sword"),
	TYPE_SPEAR("spear"),
	TYPE_SWORD_CAV("sword cav"),
	TYPE_SPEAR_CAV("spear cav"),
	TYPE_ARCHER("archer"),
	TYPE_SLINGER("slinger"),
	TYPE_JAVELIN("javelin"),
	TYPE_HEAVY_ARTY("heavy arty"),
	TYPE_LIGHT_ARTY("light arty"),
	TYPE_ELEPHANT("elephant"),
	
	T1("1"),
	T2("2"),
	T3("3"),
	T4("4"),
	T5("5"),
	T6("6"),
	T7("7"),
	T8("8"),
	T9("9"),
	T10("10"),
	
	SPAR("spar"),
	FEAST("feast"),
	SWEAR_OATH("swear oath"),
	
	CHARGE_IMPACT("charge impact"),
	IMPACT_DAMAGE("impact damage"),
	MELEE_ATTACK("melee attack"),
	MELEE_WEAPON_DAMAGE("melee weapon damage"),
	MELEE_WEAPON_PENETRATION_DAMAGE("melee weapon penetration damage"),
	MORALE_FLANK_DAMAGE("morale flank damage"),
	CHARGE_DEFLECT("charge deflect"),
	MELEE_DEFENSE("melee defense"),
	MISSILE_BLOCK_CHANCE("missile block chance"),
	BODY_ARMOUR("body armour"),
	HEALTH("health"),
	MORALE("morale"),
	ACCELERATION("acceleration"),
	DECELERATION("deceleration"),
	MOVEMENT_SPEED("movement speed"),
	TURN_SPEED("turn speed"),
	VIEW_RANGE("view range");
	
	private String name;
	private RootIdentifiers(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name != null ? this.name : "N/A";
	}
	
	public static boolean isNameIdentifier(String statName) {
		if(statName == null) return false;
		return Arrays.asList(RootIdentifiers.values()).stream().map(s -> s.getName()).anyMatch(statName::equals);
//		return Arrays.asList(NameIdentifier.values()).stream().map(s -> s.getName()).anyMatch(s -> s.equals(statName));
	}
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
