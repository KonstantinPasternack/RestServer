package de.giftbox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.giftbox.dao.GeschenkDAO;
import de.giftbox.domain.Geschenk;

@Controller
@RequestMapping("/geschenk/*")
public class GeschenkController {

	GeschenkDAO geschenkDao;

	private static final Logger log = LoggerFactory
			.getLogger(GeschenkController.class);

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public @ResponseBody
	String geschenk() {
		log.debug("Giftbox Server Geschenk");
		return "geschenk";
	}

	@RequestMapping(value = "postgeschenk", method = RequestMethod.POST, headers = "Content-Type=application/json")
	public @ResponseBody
	String postBenutzerJson(@RequestBody Geschenk geschenk) {
		log.debug("Geschenk retrieved");
		return "\"OK\"";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody
	String postGeschenk(@RequestBody String json) {
		Geschenk geschenk = new Geschenk();
		log.debug(json.toString());

		geschenk.setBezeichnung("Testbezeichnung");

		log.info("testing Post \"Geschenk\" to DB");
		Boolean geklappt = false;
		try {
			geschenkDao.saveGeschenk(geschenk);
			geklappt = true;
			log.info("neues Geschenk in die DB geschrieben!");
		} catch (Exception ex) {

			ex.printStackTrace();
			geklappt = false;
			log.error("saveGeschenk hat nicht funktioniert");

		}

		return geklappt.toString();

	}

	@RequestMapping(value = "fetchgeschenk", method = RequestMethod.GET, headers = "application/json")
	public @ResponseBody
	List<Geschenk> fetchBenutzerJson() {
		log.debug("Fetching JSON geschenk");
		return getAllGeschenk();
	}

	@RequestMapping(value = "all", method = RequestMethod.GET)
	private @ResponseBody
	List<Geschenk> getAllGeschenk() {
		log.debug("get all geschenk!");
		List<Geschenk> listGeschenk = geschenkDao.listGeschenk();
		return listGeschenk;
	}

	public void setGeschenkDAO(GeschenkDAO geschenkDao) {
		this.geschenkDao = geschenkDao;
	}
}
