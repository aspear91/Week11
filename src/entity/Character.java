package entity;

public class Character {
	
//	private int characterId;
	private String firstName;
	private String lastName;
	
	public Character(String firstName, String lastName){
//		this.setCharacterId(characterId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

/*	public int getCharacterId() {
		return characterId;
	}

	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
