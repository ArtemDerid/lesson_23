package ua.lviv.lgs.max;

import java.util.Comparator;

public class CommodityNameComparator implements Comparator<Commodity> {

	@Override
	public int compare(Commodity o1, Commodity o2) {
		return o1.getName().compareTo(o2.getName()) > 0 ? 1 : -1;
	}

}
