package de.giftbox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.giftbox.dao.BenutzerDAO;
import de.giftbox.domain.Benutzer;

@Controller
@RequestMapping("/benutzer/*")
public class BenutzerController {

	BenutzerDAO benutzerDao;

	private static final Logger log = LoggerFactory
			.getLogger(MainController.class);

	// @RequestMapping(value = { "/", "benutzer.html" }, method =
	// RequestMethod.GET)
	// public String benutzer() {
	// log.debug("Giftbox Server Benutzer");
	// return "benutzer";
	// }

	@RequestMapping(value = "postbenutzer", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public @ResponseBody
	String postBenutzerJson(@RequestBody Benutzer benutzer) {
		log.debug("Benutzer retrieved");
		return "\"OK\"";
	}

	@RequestMapping(value = "testpost/{name}", method = RequestMethod.GET)
	public @ResponseBody
	String testPost(@PathVariable(value = "name") String name) {
		log.info("testing Post to DB");
		Boolean geklappt = false;
		Benutzer benutzer = new Benutzer(name);
		try {
			benutzerDao.saveBenutzer(benutzer);
			geklappt = true;
		} catch (Exception ex) {

			ex.printStackTrace();
			geklappt = false;
			log.error("saveBenutzer hat nicht funktioniert");

		}

		return geklappt.toString();

	}

	@RequestMapping(value = "fetchbenutzer", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	List<Benutzer> fetchBenutzerJson() {
		log.debug("Fetching JSON benutzer");
		return getAllBenutzer();
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	private @ResponseBody
	List<Benutzer> getAllBenutzer() {
		log.debug("get all benutzer!");
		List<Benutzer> listBenutzer = benutzerDao.listBenutzer();
		return listBenutzer;
	}

	@RequestMapping(value = "id/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Benutzer findBenutzerById(@PathVariable(value = "id") Integer id) {
		log.debug("Find Benutzer by " + id + "!");
		Benutzer benutzer = new Benutzer();
		benutzer.setIdBenutzer(benutzerDao.findBenutzerById(id));
		return benutzer;
	}

	public void setBenutzerDAO(BenutzerDAO benutzerDao) {
		this.benutzerDao = benutzerDao;
	}
}
