package onion.falxgod.yrusobad.enhancements;

import java.util.ArrayList;
import java.util.List;

import onion.falxgod.yrusobad.datastruct.Triplet;

public class EnhancementDEAD {
	private List<Triplet> tripletList;
	
	public EnhancementDEAD() {
		this.tripletList = new ArrayList<>(2);
	}
	
	
	public void addTriplet(Triplet triplet) {
		if(!tripletList.contains(triplet)) {
			tripletList.add(triplet);
		}
	}
	
	public List<Triplet> getTripletList() {
		return new ArrayList<>(tripletList);
	}
}
