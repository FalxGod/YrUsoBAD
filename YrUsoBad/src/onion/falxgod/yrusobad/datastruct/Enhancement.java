package onion.falxgod.yrusobad.datastruct;

import java.util.ArrayList;
import java.util.List;

import onion.falxgod.yrusobad.references.GearTypeIdentifiers;


public class Enhancement {
	private String name;
	private GearTypeIdentifiers gtype;
	private List<Triplet> tripletList;

	
	public Enhancement(String name) {
		this.name = name;
		this.tripletList = new ArrayList<>(2);
	}
	
	public Enhancement() {
		this(null);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGearType(GearTypeIdentifiers gtype) {
		this.gtype = gtype;
	}
	
	public void addTriplet(Triplet triplet) {
		if(!tripletList.contains(triplet)) {
			tripletList.add(triplet);
		}
	}
	
	public List<Triplet> getTripletList() {
		return new ArrayList<>(tripletList);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Name: ");
		sb.append(name);
		for(Triplet t : this.getTripletList()) {
			sb.append(" | " + t.getStatID().toString() + " = " + t.getValue() + " :: " + t.isFlat());
		}
		
		return sb.toString();
	}
	
}
