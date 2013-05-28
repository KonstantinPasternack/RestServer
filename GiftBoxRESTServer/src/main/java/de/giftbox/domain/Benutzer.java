package de.giftbox.domain;

import java.io.Serializable;

public class Benutzer implements Serializable {
	private static final long serialVersionUID = 4037937970688891459L;

	public long idBenutzer;

	public String username;

	public String passwort;

	public String kommentar;

	public String email;

	public Geschenkliste geschenkliste;

	public Benutzer() {
		super();
	}

	public Benutzer(long idBenutzer, String username, String passwort,
			String kommentar, String email, Geschenkliste geschenkliste) {
		super();
		this.idBenutzer = idBenutzer;
		this.username = username;
		this.passwort = passwort;
		this.kommentar = kommentar;
		this.email = email;
		this.geschenkliste = geschenkliste;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((geschenkliste == null) ? 0 : geschenkliste.hashCode());
		result = prime * result + (int) (idBenutzer ^ (idBenutzer >>> 32));
		result = prime * result
				+ ((kommentar == null) ? 0 : kommentar.hashCode());
		result = prime * result
				+ ((passwort == null) ? 0 : passwort.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		Benutzer other = (Benutzer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (geschenkliste == null) {
			if (other.geschenkliste != null)
				return false;
		} else if (!geschenkliste.equals(other.geschenkliste))
			return false;
		if (idBenutzer != other.idBenutzer)
			return false;
		if (kommentar == null) {
			if (other.kommentar != null)
				return false;
		} else if (!kommentar.equals(other.kommentar))
			return false;
		if (passwort == null) {
			if (other.passwort != null)
				return false;
		} else if (!passwort.equals(other.passwort))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Benutzer [idBenutzer=" + idBenutzer + ", username=" + username
				+ ", passwort=" + passwort + ", kommentar=" + kommentar
				+ ", email=" + email + ", geschenkliste=" + geschenkliste + "]";
	}

}
