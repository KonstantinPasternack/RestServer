package de.giftbox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/*")
public class MainController {
	private static final Logger log = LoggerFactory
			.getLogger(MainController.class);

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home() {
		log.debug("Giftbox Server Home");
		return "home";
	}
}