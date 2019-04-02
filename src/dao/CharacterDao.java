package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CharacterDao {

	
	private Connection connection;
	private final String GET_CHARACTERS_QUERY = "select * from characters";
	private final String GET_CHARACTER_BY_ID_QUERY = "select * from characters where id = ?";
	private final String DELETE_CHARACTER_BY_ID_QUERY = "delete from characters where id = ?";
	private final String UPDATE_CHARACTER_QUERY = "update characters set first_name = ?, last_name = ? where id = ?";
	private final String CREATE_CHARACTER_QUERY = "insert into characters(first_name, last_name) values(?,?)";
	
	public CharacterDao() {
		connection = DBConnection.getConnection();
	}
	
	public String getCharacters() throws SQLException {
		String i = "";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(GET_CHARACTERS_QUERY);
		
		while (rs.next()) {
			System.out.println("id: " + rs.getInt(1) + "   Name: " + rs.getString(2) + " " + rs.getString(3));
	}
		return i;
	}
	
	public String getCharacterById(int id) throws SQLException {
		String i = "";
		PreparedStatement ps = connection.prepareStatement(GET_CHARACTER_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("id: " + rs.getInt(1) + "   Name: " + rs.getString(2) + " " + rs.getString(3));
		}
		return i;
	}
	
	public void deleteCharacterById(int characterId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_CHARACTER_BY_ID_QUERY);
		ps.setInt(1, characterId);
		ps.executeUpdate();
	}
	
	public void updateCharacterById(int id, String firstName, String lastName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_CHARACTER_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setInt(3, id);
		ps.executeUpdate();
	}
	
	public void createNewCharacter(String firstName, String lastName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_CHARACTER_QUERY);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.executeUpdate();
	}
}
