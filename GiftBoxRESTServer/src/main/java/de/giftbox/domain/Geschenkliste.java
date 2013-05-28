package de.giftbox.domain;

import java.io.Serializable;

public class Geschenkliste implements Serializable {

	private static final long serialVersionUID = 7899379015081298156L;

	public long idGeschenkliste;

	public String name;

	public Geschenkliste() {
		super();
	}

	public Geschenkliste(long idGeschenkliste, String name) {
		super();
		this.idGeschenkliste = idGeschenkliste;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idGeschenkliste ^ (idGeschenkliste >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Geschenkliste other = (Geschenkliste) obj;
		if (idGeschenkliste != other.idGeschenkliste)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Geschenkliste [idGeschenkliste=" + idGeschenkliste + ", name="
				+ name + "]";
	}

}
