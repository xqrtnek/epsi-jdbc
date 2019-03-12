package fr.stazi.orm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.stazi.orm.jdbc.dao.PokemonDao;

public class App {

	private static final String JDBC_CONNECTION_STRING = "jdbc:postgresql://%s:%s/%s";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Chargement du driver de connexion � Postgresql
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to find JDBC driver.");
			throw e;
		}
		
		String hostname = "localhost";
		String port = "5432";
		String dbName = "orm-jdbc-pokemon";
		String username = "postgres";
		String password = "postgres";
		String connectionString = String.format(JDBC_CONNECTION_STRING, hostname, port, dbName);
		System.out.println(connectionString);
		
		// Connexion � la base de donn�es		
		try (Connection connection = DriverManager.getConnection(connectionString, username, password)) {
			PokemonDao pokemonDao = new PokemonDao(connection);
			
			pokemonDao.findAll().forEach(p -> System.out.println(p));
		}
	}

}
