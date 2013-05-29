package de.giftbox.domain;

// Generated 29.05.2013 13:40:32 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Geschenkliste generated by hbm2java
 */
@Entity
@Table(name = "geschenkliste", catalog = "giftbox")
public class Geschenkliste implements java.io.Serializable {

	private int idGeschenkliste;
	private String name;
	private Set geschenklisteHasGeschenke = new HashSet(0);
	private Set benutzer = new HashSet(0);

	public Geschenkliste() {
	}

	public Geschenkliste(int idGeschenkliste, String name) {
		this.idGeschenkliste = idGeschenkliste;
		this.name = name;
	}

	public Geschenkliste(int idGeschenkliste, String name,
			Set geschenklisteHasGeschenke, Set benutzer) {
		this.idGeschenkliste = idGeschenkliste;
		this.name = name;
		this.geschenklisteHasGeschenke = geschenklisteHasGeschenke;
		this.benutzer = benutzer;
	}

	@Id
	@Column(name = "idGeschenkliste", unique = true, nullable = false)
	public int getIdGeschenkliste() {
		return this.idGeschenkliste;
	}

	public void setIdGeschenkliste(int idGeschenkliste) {
		this.idGeschenkliste = idGeschenkliste;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geschenkliste")
	public Set getGeschenklisteHasGeschenke() {
		return this.geschenklisteHasGeschenke;
	}

	public void setGeschenklisteHasGeschenke(Set geschenklisteHasGeschenke) {
		this.geschenklisteHasGeschenke = geschenklisteHasGeschenke;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "geschenklistes")
	public Set getBenutzer() {
		return this.benutzer;
	}

	public void setBenutzer(Set benutzer) {
		this.benutzer = benutzer;
	}

}
