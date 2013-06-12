package de.giftbox.dao;

import java.util.List;

import de.giftbox.domain.Benutzer;

public interface BenutzerDAO {

	public void saveBenutzer(Benutzer benutzer);

	public List<Benutzer> listBenutzer();

	public Integer findBenutzerById(Integer id);
}