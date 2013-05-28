package de.giftbox.domain;

import java.io.Serializable;

public class Geschenk implements Serializable {
	private static final long serialVersionUID = -2226001240291755013L;

	public long idGeschenk;

	public String bezeichnung;

	public String kategorie;

	public double preis;

	public String ort;

	public String link;

	public String kommentar;

	public Geschenk() {
		super();
	}

	public Geschenk(long idGeschenk, String bezeichnung, String kategorie,
			double preis, String ort, String link, String kommentar) {
		super();
		this.idGeschenk = idGeschenk;
		this.bezeichnung = bezeichnung;
		this.kategorie = kategorie;
		this.preis = preis;
		this.ort = ort;
		this.link = link;
		this.kommentar = kommentar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bezeichnung == null) ? 0 : bezeichnung.hashCode());
		result = prime * result + (int) (idGeschenk ^ (idGeschenk >>> 32));
		result = prime * result
				+ ((kategorie == null) ? 0 : kategorie.hashCode());
		result = prime * result
				+ ((kommentar == null) ? 0 : kommentar.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((ort == null) ? 0 : ort.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geschenk other = (Geschenk) obj;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (idGeschenk != other.idGeschenk)
			return false;
		if (kategorie == null) {
			if (other.kategorie != null)
				return false;
		} else if (!kategorie.equals(other.kategorie))
			return false;
		if (kommentar == null) {
			if (other.kommentar != null)
				return false;
		} else if (!kommentar.equals(other.kommentar))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (Double.doubleToLongBits(preis) != Double
				.doubleToLongBits(other.preis))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Geschenk [idGeschenk=" + idGeschenk + ", bezeichnung="
				+ bezeichnung + ", kategorie=" + kategorie + ", preis=" + preis
				+ ", ort=" + ort + ", link=" + link + ", kommentar="
				+ kommentar + "]";
	}

}
