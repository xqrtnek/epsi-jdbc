package fr.stazi.orm.jdbc.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.stazi.orm.jdbc.model.Pokemon;

public class PokemonMapper {
	
	public Pokemon process(ResultSet rs) throws SQLException {
		Pokemon pokemon = new Pokemon();
		
		// Exemple d'utilisation : rs.getInt(0)
		// Essaie de récupérer la première colonne du tuple en cours sous forme d'entier
		Long id = rs.getLong(1);
		pokemon.setId(id);
		
		// A compléter
		
		return pokemon;
	}
}
