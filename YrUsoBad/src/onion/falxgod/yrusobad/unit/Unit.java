package onion.falxgod.yrusobad.unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import onion.falxgod.yrusobad.datastruct.Enhancement;
import onion.falxgod.yrusobad.references.StatIdentifiers;
import onion.falxgod.yrusobad.references.UnitTypes;

public class Unit {
	private String name;
	private int tier;
	private UnitTypes type;
	
	private Map<StatIdentifiers, Float> stats;
	private List<Enhancement> enhancementList;
	private List<Enhancement> buffList;
	
	public Unit() {
		this.stats = new HashMap<>();
		this.enhancementList = new ArrayList<>(4);
		this.buffList = new ArrayList<>(2);
	}
	
	public void addStat(StatIdentifiers statIdentifiers, float value) {
		if(!stats.containsKey(statIdentifiers)) {
			stats.put(statIdentifiers, value);
		}
	}
	
	public void setEnhancementList(List<Enhancement> enhancementList) {
		if(enhancementList != null && enhancementList.size() > 0) {
			this.enhancementList = enhancementList;
		}
	}
	
	public void addEnhancements(List<Enhancement> enhancements) {
		if(enhancements != null && enhancements.size() > 0) {
			enhancements.forEach(v -> {
				if(!enhancementList.contains(v)) {
					enhancementList.add(v);
				}
			});
		}
	}
	
	public void addEnhancement(Enhancement enhancement) {
		if(!enhancementList.contains(enhancement)) {
			enhancementList.add(enhancement);
		}
	}
	
	public void addBuff(Enhancement buff) {
		if(!buffList.contains(buff)) buffList.add(buff);
	}
	
	public void setUnitType(UnitTypes unitType) {
		this.type = unitType;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTier(int tier) {
		this.tier = tier;
	}
}
