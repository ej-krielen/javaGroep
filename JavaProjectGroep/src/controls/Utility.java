package controls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import user.User;

/**
 * 
 * This is were all user actions are defined
 * 
 * @author Erik-Jan Krielen erik-jan.krielen@atos.net
 * @version 0.1 Current version number of program
 * @since October 2nd 2014 Creation of this file
 * @update October 31th 2014 Latest update of this file
 * 
 */

public class Utility {
	private static Utility INSTANCE;

	static {
		INSTANCE = new Utility();
		INSTANCE.bootstrapFromResource(User.class
				.getResourceAsStream("mosters_definition.txt"));
	}

	public static Utility getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Utility();
		}
		return INSTANCE;
	}

//	private Map<String, Monster> repository = new HashMap<String,Monster>();
//
	private void bootstrapFromResource(InputStream resourceAsStream) {
//		Monster mo1 = new Monster("Dire Rat", .....);
//		repository.put(mo1.getMonsterName(), mo1);
//		Monster mo2 = new Monster("Tarasque", .....);
//		repository.put(mo2.getMonsterName(), mo2);
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(
//				resourceAsStream));
//		for (String line = br.readLine(); line != null; line = br.readLine()) {
//			// process line to your repository
//
//			// Parse the string line to ojbect monster
//			String monsterName;
//			int monsterHp;
//			int monsterAttack;
//			String monsterDamage;
//			
//			StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
//			monsterName = stringTokenizer.nextToken();
//			monsterHp = Integer.getInteger(stringTokenizer.nextToken());
//			monsterAttack = Integer.getInteger(stringTokenizer.nextToken());
//			monsterDamage = stringTokenizer.nextToken();
//			
//			Monster monster = new Monster(monsterName, monsterHp, monsterAttack, monsterDamage);
//			// Add monster to repository
//			repository.put(monsterName, monster);
//		}
	}

//	public Monster getMonsterByName(String name) {
//		return repository.get(name);
//	}

	//
	private static final String BASE_DIRECTORY = "C:/JavaProjectAtos";
	private static List<User> userArr = new ArrayList<User>();
	/**
	 * Counter used to give each {@link User} an unique ID Maybe replace once
	 * connected to a database
	 */
	private static int userCounter;

	/**
	 * Calls method to get a name from the user. Uses input and
	 * {@link userCounter} to create a {@link User} in {@link userArr} and
	 * creates a file to log changes in.
	 * 
	 * @param userName
	 *            String gathered from the interface field {@link userNameField}
	 */
	public static void createUser(String userName) {
		userCounter++;
		// create file for changelog
		String nameFile = createFile(userName);
		userArr.add(new User(userCounter, userName, nameFile));

	}// createUser

	public void createSeller() {
		// (from User, update file)
	}// createSeller

	public void createBuyer() {
		// (from User, update file)
	}// createBuyer

	private static File getUserFile(String userName) {
		// ...
		return null;
	}

	private static File getUserFile(int userId) {
		return new File(BASE_DIRECTORY, "user" + userId + ".txt");
	}

	/**
	 * Uses parameters to select a changelog file. Reads the file line by line
	 * and appends it to a StringBuffer.
	 * 
	 * @param userName
	 *            Input from interface: {@link userHistoryNameField}
	 * @return StringBuffer converted to a String
	 */
	public static String requestUserHistory(String userName) {
		// Find user file
		File userFile = getUserFile(userName);

		if (userFile == null || !userFile.exists()) {
			// Iets van error
		} else {
			// Do request user history op userFile
		}

		// (show file)

		Path pad = Paths.get("C:\\JavaProjectAtos");

		// TODO use this to create a list of members
		// String globPattern = "*.txt";
		// DirectoryStream<Path> dir;
		// String fileName = "";
		// try {
		// dir = Files.newDirectoryStream(pad, globPattern);
		// for (Path p : dir) {
		// fileName = p.getFileName().toString();
		// }
		// } catch (IOException ex) {
		// ex.printStackTrace();
		// }

		StringBuffer buffer = new StringBuffer("");
		try {
			FileReader fr = new FileReader("" + pad + "\\" + userName + ".txt");
			BufferedReader br = new BufferedReader(fr);
			String buff;
			try {
				while ((buff = br.readLine()) != null) {
					buffer.append(buff + "\n");
				}
				br.close();
			} catch (IOException e) {
				return "user not found";
			}
		} catch (FileNotFoundException e) {
			return "user not found";
		}

		return buffer.toString();

	}// requestUserHistory

	public static void deleteSeller() {
		// (if used = false)
	}// deleteSeller

	public static void deleteBuyer() {
		// (if used = false)
	}// deleteBuyer

	public static void editSeller() {
		// (update Seller, update file)
	}// editSeller

	public static void editBuyer() {
		// (update Buyer, update file)
	}// editBuyer

	/**
	 * Create a file where changes will be recorded later, initially writes
	 * creation date and name. All changes should include a timestamp.
	 * 
	 * @param userName
	 *            Name of the user
	 * @return Name (including path) of the file
	 */
	private static String createFile(String userName) {
		File userFile = createNewUserFile();
		String date = new Date().toString();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(userFile))) {
			bw.write("Created on ");
			bw.write(date);
			bw.newLine();
			bw.write("Name of user: ");
			bw.write(userName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userFile.getAbsolutePath();
		// String nameFile = BASE_DIRECTORY + "/user"+ userCounter + ".txt";
		// String date = new Date().toString();
		// try (BufferedWriter bw = new BufferedWriter(new
		// FileWriter(nameFile))) {
		// bw.write("Created on ");
		// bw.write(date);
		// bw.newLine();
		// bw.write("Name of user: ");
		// bw.write(userName);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// return nameFile;
	}// createFile

	private static File createNewUserFile() {
		File userFile = getUserFile(userCounter);
		while (userFile.exists()) {
			userCounter++;
			userFile = getUserFile(userCounter);
		}

		return userFile;
	}
}
