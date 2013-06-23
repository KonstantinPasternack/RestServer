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

import com.google.gson.Gson;

import de.giftbox.dao.BenutzerDAO;
import de.giftbox.domain.Benutzer;
import de.giftbox.helper.JSONStringToMap;

@Controller
@RequestMapping("/benutzer/*")
public class BenutzerController {

	BenutzerDAO benutzerDao;
	JSONStringToMap jsonStringToMap;

	private static final Logger log = LoggerFactory
			.getLogger(MainController.class);

	// Methode, die alle Benutzer zurückgibt
	@RequestMapping(value = "all", method = RequestMethod.GET)
	private @ResponseBody
	List<Benutzer> getAllBenutzer() {
		log.debug("get all benutzer!");
		List<Benutzer> listBenutzer = benutzerDao.listBenutzer();
		return listBenutzer;
	}

	// Methode, die einen Benutzer speichert
	@RequestMapping(value = "new", method = RequestMethod.POST)
	public @ResponseBody
	String postBenutzer(@RequestBody String json) {
		Benutzer b = new Benutzer();
		log.debug(json.toString());

		Gson gson = new Gson();
		b = gson.fromJson(json, Benutzer.class);

		log.debug(b.toString());

		log.info("testing Post \"Benutzer\":" + b.toString() + " to DB");
		Boolean geklappt = false;
		try {
			benutzerDao.saveBenutzer(b);
			geklappt = true;
			log.info("neuen Benutzer in die DB geschrieben!");
		} catch (Exception ex) {

			ex.printStackTrace();
			geklappt = false;
			log.error("saveBenutzer hat nicht funktioniert");

		}

		return geklappt.toString();

	}

	// Methode, die einen Benutzer über ID zurückliefert
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody
	String getBenutzerById(@PathVariable(value = "id") Integer id) {

		Benutzer b = benutzerDao.getBenutzerById(id);

		Gson gson = new Gson();
		String json = gson.toJson(b, Benutzer.class);

		return json;
	}

	// Methode, die einen Benutzer über ID zurückliefert
	@RequestMapping(value = "username/{name}", method = RequestMethod.GET)
	public @ResponseBody
	String getBenutzerByName(@PathVariable(value = "name") String name) {

		Benutzer b = benutzerDao.findBenutzerByUsername(name);

		Gson gson = new Gson();
		String json = gson.toJson(b, Benutzer.class);

		return json;
	}

	public void setBenutzerDAO(BenutzerDAO benutzerDao) {
		this.benutzerDao = benutzerDao;
	}

	public void setJSONStringToMap(JSONStringToMap jsonStringToMap) {
		this.jsonStringToMap = jsonStringToMap;
	}
}
