package de.giftbox.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import de.giftbox.restService.Service;

public class MessageApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();

	public MessageApplication() {
		singletons.add(new Service());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
