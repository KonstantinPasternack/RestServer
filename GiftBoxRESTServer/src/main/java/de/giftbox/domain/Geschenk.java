package de.giftbox.domain;

// Generated 29.05.2013 13:40:32 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Geschenk generated by hbm2java
 */
@Entity
@Table(name = "geschenk", catalog = "giftbox")
public class Geschenk implements java.io.Serializable {

	private static final long serialVersionUID = 1653525742662101040L;
	
	private Integer id_Geschenk;
	private String bezeichnung;
	private String kategorie;
	private Double preis;
	private String ort;
	private String link;
	private String kommentar;
//	private Set<GeschenklisteHasGeschenk> geschenklisteHasGeschenke = new HashSet<GeschenklisteHasGeschenk>(0);
//	private Set<Bewertungen> bewertungen = new HashSet<Bewertungen>(0);

	public Geschenk() {
	}

	public Geschenk(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Geschenk(String bezeichnung, String kategorie, Double preis,
			String ort, String link, String kommentar,
			Set<GeschenklisteHasGeschenk> geschenklisteHasGeschenke, Set<Bewertungen> bewertungen) {
		this.bezeichnung = bezeichnung;
		this.kategorie = kategorie;
		this.preis = preis;
		this.ort = ort;
		this.link = link;
		this.kommentar = kommentar;
//		this.geschenklisteHasGeschenke = geschenklisteHasGeschenke;
//		this.bewertungen = bewertungen;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_Geschenk", unique = true, nullable = false)
	public Integer getId_Geschenk() {
		return this.id_Geschenk;
	}

	public void setId_Geschenk(Integer id_Geschenk) {
		this.id_Geschenk = id_Geschenk;
	}

	@Column(name = "bezeichnung", nullable = false, length = 45)
	public String getBezeichnung() {
		return this.bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	@Column(name = "kategorie", length = 45)
	public String getKategorie() {
		return this.kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	@Column(name = "preis", precision = 22, scale = 0)
	public Double getPreis() {
		return this.preis;
	}

	public void setPreis(Double preis) {
		this.preis = preis;
	}

	@Column(name = "ort", length = 45)
	public String getOrt() {
		return this.ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	@Column(name = "link", length = 256)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "kommentar", length = 140)
	public String getKommentar() {
		return this.kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geschenk")
//	public Set<GeschenklisteHasGeschenk> getGeschenklisteHasGeschenke() {
//		return this.geschenklisteHasGeschenke;
//	}
//
//	public void setGeschenklisteHasGeschenke(Set<GeschenklisteHasGeschenk> geschenklisteHasGeschenke) {
//		this.geschenklisteHasGeschenke = geschenklisteHasGeschenke;
//	}

//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geschenk")
//	public Set<Bewertungen> getBewertungen() {
//		return this.bewertungen;
//	}
//
//	public void setBewertungen(Set<Bewertungen> bewertungen) {
//		this.bewertungen = bewertungen;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result
//				+ ((bewertungen == null) ? 0 : bewertungen.hashCode());
//		result = prime * result
//				+ ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
//		result = prime
//				* result
//				+ ((geschenklisteHasGeschenke == null) ? 0
//						: geschenklisteHasGeschenke.hashCode());
		result = prime * result
				+ ((id_Geschenk == null) ? 0 : id_Geschenk.hashCode());
		result = prime * result
				+ ((kategorie == null) ? 0 : kategorie.hashCode());
		result = prime * result
				+ ((kommentar == null) ? 0 : kommentar.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		result = prime * result + ((preis == null) ? 0 : preis.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Geschenk other = (Geschenk) obj;
//		if (bewertungen == null) {
//			if (other.bewertungen != null) {
//				return false;
//			}
//		} else if (!bewertungen.equals(other.bewertungen)) {
//			return false;
//		}
//		if (bezeichnung == null) {
//			if (other.bezeichnung != null) {
//				return false;
//			}
//		} else if (!bezeichnung.equals(other.bezeichnung)) {
//			return false;
//		}
//		if (geschenklisteHasGeschenke == null) {
//			if (other.geschenklisteHasGeschenke != null) {
//				return false;
//			}
//		} else if (!geschenklisteHasGeschenke
//				.equals(other.geschenklisteHasGeschenke)) {
//			return false;
//		}
		if (id_Geschenk == null) {
			if (other.id_Geschenk != null) {
				return false;
			}
		} else if (!id_Geschenk.equals(other.id_Geschenk)) {
			return false;
		}
		if (kategorie == null) {
			if (other.kategorie != null) {
				return false;
			}
		} else if (!kategorie.equals(other.kategorie)) {
			return false;
		}
		if (kommentar == null) {
			if (other.kommentar != null) {
				return false;
			}
		} else if (!kommentar.equals(other.kommentar)) {
			return false;
		}
		if (link == null) {
			if (other.link != null) {
				return false;
			}
		} else if (!link.equals(other.link)) {
			return false;
		}
		if (ort == null) {
			if (other.ort != null) {
				return false;
			}
		} else if (!ort.equals(other.ort)) {
			return false;
		}
		if (preis == null) {
			if (other.preis != null) {
				return false;
			}
		} else if (!preis.equals(other.preis)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Geschenk [id_Geschenk=" + id_Geschenk + ", bezeichnung="
				+ bezeichnung + ", kategorie=" + kategorie + ", preis=" + preis
				+ ", ort=" + ort + ", link=" + link + ", kommentar="
				+ kommentar + "]";
	}

}
