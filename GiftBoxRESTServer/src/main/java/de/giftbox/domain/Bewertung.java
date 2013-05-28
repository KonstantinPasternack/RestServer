package de.giftbox.domain;

import java.io.Serializable;

public class Bewertung implements Serializable {

	private static final long serialVersionUID = 5990069353510106465L;

	public long idBewertung;

	public String bewertung;

	public Geschenk geschenk;

	public Benutzer benutzer;

	public Bewertung() {
		super();
	}

	public Bewertung(long idBewertung, String bewertung, Geschenk geschenk,
			Benutzer benutzer) {
		super();
		this.idBewertung = idBewertung;
		this.bewertung = bewertung;
		this.geschenk = geschenk;
		this.benutzer = benutzer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((benutzer == null) ? 0 : benutzer.hashCode());
		result = prime * result
				+ ((bewertung == null) ? 0 : bewertung.hashCode());
		result = prime * result
				+ ((geschenk == null) ? 0 : geschenk.hashCode());
		result = prime * result + (int) (idBewertung ^ (idBewertung >>> 32));
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
		Bewertung other = (Bewertung) obj;
		if (benutzer == null) {
			if (other.benutzer != null)
				return false;
		} else if (!benutzer.equals(other.benutzer))
			return false;
		if (bewertung == null) {
			if (other.bewertung != null)
				return false;
		} else if (!bewertung.equals(other.bewertung))
			return false;
		if (geschenk == null) {
			if (other.geschenk != null)
				return false;
		} else if (!geschenk.equals(other.geschenk))
			return false;
		if (idBewertung != other.idBewertung)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bewertung [idBewertung=" + idBewertung + ", bewertung="
				+ bewertung + ", geschenk=" + geschenk + ", benutzer="
				+ benutzer + "]";
	}

}
