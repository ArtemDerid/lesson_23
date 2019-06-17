package ua.lviv.lgs;

import java.util.Comparator;

public class DeputiesGraftComparator implements Comparator<Deputy> {

	@Override
	public int compare(Deputy o1, Deputy o2) {
		return (-1)*(o1.getGraft() > o2.getGraft() ? 1 : -1);
	}

}
