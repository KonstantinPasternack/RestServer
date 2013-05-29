package de.giftbox.restService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import de.giftbox.domain.Geschenk;
import de.giftbox.dao.MySQL;

@Path("/message")
public class Service {

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}

	@GET
	@Path("/geschenk/")
	public Response createGeschenk() {
 
//		String result = "";
		boolean result = false;
		Geschenk geschenk = new Geschenk();
		geschenk.setBezeichnung("testGeschenk");
		
		try{
			MySQL db = new MySQL();
	        result = db.RunQuery("INSERT INTO `giftbox`.`geschenk` (bezeichnung) VALUES ('test')");
			
//			result = "geklappt!!!";
			return Response.status(200).entity(result).build();
		} catch (Exception ex){
			ex.printStackTrace();
//			result = "nicht geklappt!!!";
			return Response.status(500).entity(result).build();
		}
 
		
 
	}
}
