package de.giftbox.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.giftbox.domain.Benutzer;

public class BenutzerController {
	private static final Logger log = LoggerFactory
			.getLogger(MainController.class);

	@RequestMapping(value = { "/", "benutzer.html" }, method = RequestMethod.GET)
	public String benuter() {
		log.debug("Giftbox Server Benutzer");
		return "benutzer";
	}

	@RequestMapping(value = "postbenutzer", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public @ResponseBody
	String postBenutzerJson(@RequestBody Benutzer benutzer) {
		log.debug("Benutzer retrieved");
		return "\"OK\"";
	}

	@RequestMapping(value = "fetchbenutzer", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	List<Benutzer> fetchBenutzerJson() {
		log.debug("Fetching JSON benutzer");
		return getAllBenutzer();
	}

	// TODO
	private List<Benutzer> getAllBenutzer() {
		List<Benutzer> listBenutzer = new ArrayList<>();
		return listBenutzer;
	}	
}
