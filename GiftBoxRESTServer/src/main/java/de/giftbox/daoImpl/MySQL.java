package de.giftbox.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

	private String Username = "root";
	private String Password = "";
	private String Driver = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://localhost:3306/giftbox";
	private Connection connection;

	/**
	 * Konstruktor, der direkt eine Verbindung herstellt
	 */
	public MySQL() {
		this.Connect();
	}


	/**
	 * @param user
	 * @param pass
	 */
	public MySQL(String user, String pass) {
		this.Username = user;
		this.Password = pass;
		this.Connect();
	}

	/*
	 * Sollte der Konstruktur mit den Argumenten user und pass aufgerufen
	 * werden, werden diese definiert und dann Verbunden.
	 */

	/**
	 * 
	 */
	public void Close() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (Exception e) {
			}
		}
	}

	/*
	 * Die Funktion Close() schlie�t das Query um den Speicher wieder frei zu
	 * geben
	 */

	/**
	 * 
	 */
	public void Connect() {
		try {
			Class.forName(this.Driver);
			this.connection = DriverManager.getConnection(this.URL,
					this.Username, this.Password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error Connecting with User:" + Username
					+ " and Password:" + Password);
		}
	}

	/*
	 * Connect registriert den JDBC Treiber und versucht eine Verbindung
	 * herzustellen. Sollte dies nicht m�glich sein, wird eine Exception
	 * ausgel�st
	 */

	/**
	 * @return
	 */
	public boolean isConnected() {
		try {
			ResultSet rs = this.ReturnQuery("SELECT 1;");
			if (rs == null) {
				return false;
			}
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * fr�gt ein einfaches Query ab, welches "1" zur�ck liefert, falls man
	 * verbunden ist
	 */

	/**
	 * @param query
	 * @return ResultSet
	 * 
	 * Query, die ein ResultSet zur�ck gibt
	 */
	public ResultSet ReturnQuery(String query) {
		try {
			Statement stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			System.err.println(e.toString());
			return null;
		}
	}

	/* Sendet ein Query und erwartet eine R�ckgabe in Form eines ResultSet */

	/**
	 * @param query
	 * @return
	 */
	public boolean RunQuery(String query) {
		try {
			Statement stmt = this.connection.createStatement();
			stmt.execute(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/* F�hrt das query aus, erwartet aber keine R�ckantwort des Servers. */

}
