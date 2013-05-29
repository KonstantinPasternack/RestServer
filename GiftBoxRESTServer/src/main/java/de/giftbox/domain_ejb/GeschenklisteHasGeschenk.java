package de.giftbox.domain_ejb;

// Generated 29.05.2013 13:40:32 by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * GeschenklisteHasGeschenk generated by hbm2java
 */
@Entity
@Table(name = "geschenkliste_has_geschenk", catalog = "giftbox")
public class GeschenklisteHasGeschenk implements java.io.Serializable {

	private GeschenklisteHasGeschenkId id;
	private Benutzer benutzer;
	private Geschenkliste geschenkliste;
	private Geschenk geschenk;

	public GeschenklisteHasGeschenk() {
	}

	public GeschenklisteHasGeschenk(GeschenklisteHasGeschenkId id,
			Benutzer benutzer, Geschenkliste geschenkliste, Geschenk geschenk) {
		this.id = id;
		this.benutzer = benutzer;
		this.geschenkliste = geschenkliste;
		this.geschenk = geschenk;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "geschenklisteIdGeschenkliste", column = @Column(name = "Geschenkliste_idGeschenkliste", nullable = false)),
			@AttributeOverride(name = "geschenklisteIdGeschenk", column = @Column(name = "Geschenkliste_idGeschenk", nullable = false)),
			@AttributeOverride(name = "geschenklisteIdBenutzer", column = @Column(name = "Geschenkliste_idBenutzer", nullable = false)) })
	public GeschenklisteHasGeschenkId getId() {
		return this.id;
	}

	public void setId(GeschenklisteHasGeschenkId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Geschenkliste_idBenutzer", nullable = false, insertable = false, updatable = false)
	public Benutzer getBenutzer() {
		return this.benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Geschenkliste_idGeschenkliste", nullable = false, insertable = false, updatable = false)
	public Geschenkliste getGeschenkliste() {
		return this.geschenkliste;
	}

	public void setGeschenkliste(Geschenkliste geschenkliste) {
		this.geschenkliste = geschenkliste;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Geschenkliste_idGeschenk", nullable = false, insertable = false, updatable = false)
	public Geschenk getGeschenk() {
		return this.geschenk;
	}

	public void setGeschenk(Geschenk geschenk) {
		this.geschenk = geschenk;
	}

}
