package onion.falxgod.yrusobad.references;

import java.util.Arrays;

public enum StatIdentifiers {
	CHARGE_IMPACT,
	IMPACT_DAMAGE,
	MELEE_ATTACK,
	MELEE_WEAPON_DAMAGE,
	MELEE_WEAPON_PENETRATION_DAMAGE,
	MORALE_FLANK_DAMAGE,
	CHARGE_DEFLECT,
	MELEE_DEFENSE,
	MISSILE_BLOCK_CHANCE,
	BODY_ARMOUR,
	HEALTH,
	MORALE,
	ACCELERATION,
	DECELERATION,
	MOVEMENT_SPEED,
	TURN_SPEED,
	VIEW_RANGE,
	
	MISSILE_DISPERSION,
	MISSILE_WEAPON_DAMAGE,
	MISSILE_WEAPON_PENETRATION_DAMAGE,
	MISSILE_WEAPON_RANGE,
	
	SHIELD_MELEE_DEFENSE,
	SHIELD_ARMOUR
	
	;
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}
	
	public static StatIdentifiers getFromSring(String statIdentifiers) {
		if(statIdentifiers != null) {
			for(StatIdentifiers uT : Arrays.asList(StatIdentifiers.values())) {
				if(uT.toString().equals(statIdentifiers)) return uT;
			}
		}
		return null;
	}
	
	public static boolean contains(StatIdentifiers statIdentifiers) {
		if(statIdentifiers != null && Arrays.asList(StatIdentifiers.values()).contains(statIdentifiers)) return true;
		
		return false;
	}
}
