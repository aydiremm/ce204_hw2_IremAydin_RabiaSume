/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

// line 11 "../../model.ump"
// line 138 "../../model.ump"
public class Phone {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Phone Attributes
	private String phoneNumber;
	private String phoneHolderName;
	private String relation;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * 
	 * Constructs a phone object with a given phone number, phone holder name, and
	 * relation.
	 * 
	 * @param aPhoneNumber     the phone number of the phone object
	 * @param aPhoneHolderName the name of the person who owns the phone
	 * @param aRelation        the relation of the phone holder to the owner of the
	 *                         phone
	 */

	public Phone(String aPhoneNumber, String aPhoneHolderName, String aRelation) {
		phoneNumber = aPhoneNumber;
		phoneHolderName = aPhoneHolderName;
		relation = aRelation;
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/**
	 * 
	 * Sets the phone number of the phone object.
	 * 
	 * @param aPhoneNumber the phone number to set
	 * @return true if the phone number was set, false otherwise
	 */

	public boolean setPhoneNumber(String aPhoneNumber) {
		boolean wasSet = false;
		phoneNumber = aPhoneNumber;
		wasSet = true;
		return wasSet;
	}

	/**
	 * 
	 * Sets the name of the person who owns the phone object.
	 * 
	 * @param aPhoneHolderName the name of the phone holder to set
	 * @return true if the name of the phone holder was set, false otherwise
	 */

	public boolean setPhoneHolderName(String aPhoneHolderName) {
		boolean wasSet = false;
		phoneHolderName = aPhoneHolderName;
		wasSet = true;
		return wasSet;
	}

	/**
	 * 
	 * Sets the relation of the phone holder to the owner of the phone object.
	 * 
	 * @param aRelation the relation to set
	 * @return true if the relation was set, false otherwise
	 */

	public boolean setRelation(String aRelation) {
		boolean wasSet = false;
		relation = aRelation;
		wasSet = true;
		return wasSet;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPhoneHolderName() {
		return phoneHolderName;
	}

	public String getRelation() {
		return relation;
	}

	public void delete() {
	}

	public String toString() {
		return super.toString() + "[" + "phoneNumber" + ":" + getPhoneNumber() + "," + "phoneHolderName" + ":"
				+ getPhoneHolderName() + "," + "relation" + ":" + getRelation() + "]";
	}
}