package de.giftbox.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.giftbox.domain.Geschenk;
import de.giftbox.domain.GeschenkService;

@Path("/geschenk")
public class GeschenkRessource {

	GeschenkService gs = new GeschenkService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Geschenk> getAllGeschenke() {

		List<Geschenk> geschenkList = new ArrayList<Geschenk>();
		geschenkList = gs.getAllGeschenke();

		return geschenkList;
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Geschenk getGeschenk() {
		Geschenk g = new Geschenk("TestGeschenk");

		return g;
	}
}
