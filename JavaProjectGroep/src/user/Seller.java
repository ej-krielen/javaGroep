/**
 * @author      Erik-Jan Krielen 	erik-jan.krielen@atos.net
 * @version     0.1					Current version number of program
 * @since       October 2nd 2014	Creation of this file
 * @update		October 7th 2014	Latest update of this file
 */

package user;

public class Seller {

	private int userId;
	private boolean used = false;
	
	public Seller(int userId) {
		this.userId = userId;
	}

	// Getters and Setters

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

}
