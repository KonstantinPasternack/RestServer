package de.giftbox.domain;

import java.util.ArrayList;
import java.util.List;

public class GeschenkService {

	public List<Geschenk> getAllGeschenke() {

		List<Geschenk> geschenkList = new ArrayList<Geschenk>();
		
		geschenkList.add(new Geschenk("Maus"));
		geschenkList.add(new Geschenk("Laptop"));
		geschenkList.add(new Geschenk("Game Of Thrones - Staffel 01"));
		
		return geschenkList;
	}
}
