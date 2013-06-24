package de.giftbox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.giftbox.dao.GeschenklisteDAO;
import de.giftbox.helper.JSONStringToMap;

@Controller
@RequestMapping("/geschenkliste/*")
public class GeschenklisteController {

	GeschenklisteDAO geschenklisteDao;
	JSONStringToMap jsonStringToMap;
	
	
}
