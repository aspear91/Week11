package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.CharacterDao;

public class Menu {
	
	private CharacterDao characterDao = new CharacterDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Characters",
			"Display Specific Character",
			"Create Character",
			"Update Character",
			"Delete Character");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			try {
				if (selection.equals("1")) {
					displayCharacters();
				} else if (selection.equals("2")) {
					displayCharacter();
				} else if (selection.equals("3")) {
					createCharacter();
				} else if (selection.equals("4")) {
					updateCharacter();
				} else if (selection.equals("5")) {
					deleteCharacter();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to continue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select an Option:\n-----------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayCharacters() throws SQLException {
		String characters = characterDao.getCharacters();
		System.out.println(characters);
	}
	
	private void displayCharacter() throws SQLException {
		System.out.println("Enter character id");
		int id = Integer.parseInt(scanner.nextLine());
		String character = characterDao.getCharacterById(id);
		System.out.println(character);
	}
			
	
	public void createCharacter() throws SQLException {
		System.out.println("Enter First Name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter Last Name: ");
		String lastName = scanner.nextLine();
		characterDao.createNewCharacter(firstName, lastName);
	}
	
	private void updateCharacter() throws SQLException {
		System.out.println("Enter New First Name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter New Last Name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter Character Id: ");
		int id = scanner.nextInt();
		characterDao.updateCharacterById(id, lastName, firstName);
	}
	
	private void deleteCharacter() throws SQLException {
		System.out.println("Enter Character ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		characterDao.deleteCharacterById(id);
	}
}
