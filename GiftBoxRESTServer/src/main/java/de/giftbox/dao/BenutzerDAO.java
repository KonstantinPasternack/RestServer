package de.giftbox.dao;

import java.util.List;

import de.giftbox.domain.Benutzer;

public interface BenutzerDAO {

	public void saveBenutzer(Benutzer benutzer);

	public List<Benutzer> listBenutzer();

	public Benutzer findBenutzerById(Integer id);

	public Benutzer findBenutzerByUsername(String name);
}