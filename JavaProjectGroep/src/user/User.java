/** 
 * @author      Erik-Jan Krielen 	erik-jan.krielen@atos.net
 * @version     0.1					Current version number of program
 * @since       October 2nd 2014	Creation of this file
 * @update		October 14th 2014	Latest update of this file
 * 
 * 
 */

package user;

public class User {
	
	/**
	 * id used to connect User with Seller and/or Buyer.
	 * Gets the int from {@link controls.Utility} named userCounter.
	 * @see controls.Utility & Seller & Buyer
	 */
	private int id;
	
	protected String name;
	protected String nameFile;
	//String locationFile; //not sure if needed yet
	private Seller seller;// = new Seller(id);
	private Buyer buyer;// = new Buyer(id);
	
	/**
	 * Class Constructor, used by {@link controls.Utility}
	 * @param id Unique id to connect User with Seller and/or Buyer
	 * @param name Stores the String input of the User 's name.
	 * @param nameFile Stores, in String format, the name of the file where changes will be documented.
	 * 
	 * @see controls.Utility
	 */
	public User(int id, String name, String nameFile){
		this.id = id;
		this.name = name;
		this.nameFile = nameFile;
		
		this.seller = new Seller(id);
		this.buyer = new Buyer(id);
		
	}
	
	
	
	//Getters and Setters
	public int getId() {
		return id;
	}
	
	public int getSellerId(){
		return seller.getUserId();
		
	}
	
	public int getBuyerId(){
		return buyer.getUserId();
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

}
