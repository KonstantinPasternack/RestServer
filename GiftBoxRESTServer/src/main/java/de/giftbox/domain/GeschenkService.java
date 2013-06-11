package de.giftbox.domain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeschenkService {
	
	private static final Logger log = LoggerFactory
			.getLogger(GeschenkService.class);

	public List<Geschenk> getAllGeschenke() {

		
		log.debug("persisting GeschenklisteHasGeschenk instance");
		List<Geschenk> geschenkList = new ArrayList<Geschenk>();
		
		geschenkList.add(new Geschenk("Maus"));
		geschenkList.add(new Geschenk("Laptop"));
		geschenkList.add(new Geschenk("Game Of Thrones - Staffel 01"));
		
		return geschenkList;
	}
}
