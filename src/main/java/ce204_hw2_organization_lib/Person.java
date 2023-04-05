/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.sql.Date;
import java.util.*;

// line 21 "../../model.ump"
// line 148 "../../model.ump"
public class Person {

	// ------------------------
	// ENUMERATIONS
	// ------------------------

	public enum Gender {
		Male, Female
	}

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Person Attributes
	private String title;
	private String givenName;
	private String middleName;
	private String familyName;
	private Date birthDate;
	private String gender;
	private String homeAddress;
	private String phone;

	// Person Associations
	private List<Hospital> hospitals;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * @brief Constructs a new Person object with the specified parameters.
	 * 
	 * @param aTitle       the person's title
	 * @param aGivenName   the person's given name
	 * @param aMiddleName  the person's middle name
	 * @param aFamilyName  the person's family name
	 * @param aBirthDate   the person's birth date
	 * @param aGender      the person's gender
	 * @param aHomeAddress the person's home address
	 * @param aPhone       the person's phone number
	 */

	public Person(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone) {
		title = aTitle;
		givenName = aGivenName;
		middleName = aMiddleName;
		familyName = aFamilyName;
		birthDate = aBirthDate;
		gender = aGender;
		homeAddress = aHomeAddress;
		phone = aPhone;
		hospitals = new ArrayList<Hospital>();
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/**
	 * @brief Sets the title of the person.
	 * 
	 * @param aTitle the new title of the person
	 * @return true if the title was successfully set, false otherwise
	 */

	public boolean setTitle(String aTitle) {
		boolean wasSet = false;
		title = aTitle;
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Sets the given name of the person.
	 * 
	 * @param aGivenName the new given name of the person
	 * @return true if the given name was successfully set, false otherwise
	 */

	public boolean setGivenName(String aGivenName) {
		boolean wasSet = false;
		givenName = aGivenName;
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Sets the middle name of the person.
	 * 
	 * @param aMiddleName the new middle name of the person
	 * @return true if the middle name was successfully set, false otherwise
	 */

	public boolean setMiddleName(String aMiddleName) {
		boolean wasSet = false;
		middleName = aMiddleName;
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Sets the family name of the person.
	 * 
	 * @param aFamilyName the new family name of the person
	 * @return true if the family name was successfully set, false otherwise
	 */
	public boolean setFamilyName(String aFamilyName) {
		boolean wasSet = false;
		familyName = aFamilyName;
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Sets the birth date of the person.
	 * 
	 * @param aBirthDate the new birth date of the person
	 * @return true if the birth date was successfully set, false otherwise
	 */
	public boolean setBirthDate(Date aBirthDate) {
		boolean wasSet = false;
		birthDate = aBirthDate;
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Sets the gender of the person.
	 * 
	 * @param aGender the new gender of the person
	 * @return true if the gender was successfully set, false otherwise
	 */

	public boolean setGender(String aGender) {
		boolean wasSet = false;
		gender = aGender;
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Sets the home address of the person.
	 * 
	 * @param aHomeAddress the new home address of the person
	 * @return true if the home address was successfully set, false otherwise
	 */

	public boolean setHomeAddress(String aHomeAddress) {
		boolean wasSet = false;
		homeAddress = aHomeAddress;
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Sets the phone number of the person.
	 * 
	 * @param aPhone the new phone number of the person
	 * @return true if the phone number was successfully set, false otherwise
	 */

	public boolean setPhone(String aPhone) {
		boolean wasSet = false;
		phone = aPhone;
		wasSet = true;
		return wasSet;
	}

	public String getTitle() {
		return title;
	}

	public String getGivenName() {
		return givenName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getName() {
		return title + " " + givenName + " " + middleName + " " + familyName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getGender() {
		return gender;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public String getPhone() {
		return phone;
	}

	/* Code from template association_GetMany */
	public Hospital getHospital(int index) {
		Hospital aHospital = hospitals.get(index);
		return aHospital;
	}

	public List<Hospital> getHospitals() {
		List<Hospital> newHospitals = Collections.unmodifiableList(hospitals);
		return newHospitals;
	}

	public int numberOfHospitals() {
		int number = hospitals.size();
		return number;
	}

	public boolean hasHospitals() {
		boolean has = hospitals.size() > 0;
		return has;
	}

	public int indexOfHospital(Hospital aHospital) {
		int index = hospitals.indexOf(aHospital);
		return index;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfHospitals() {
		return 0;
	}

	/* Code from template association_AddManyToManyMethod */
	/**
	 * @brief Adds a hospital to the list of hospitals associated with this person.
	 *
	 * @param aHospital the hospital to add
	 * @return true if the hospital was added successfully, false otherwise (e.g.,
	 *         if the hospital was already in the list)
	 */
	public boolean addHospital(Hospital aHospital) {
		boolean wasAdded = false;
		if (hospitals.contains(aHospital)) {
			return false;
		}
		hospitals.add(aHospital);
		if (aHospital.indexOfPerson(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aHospital.addPerson(this);
			if (!wasAdded) {
				hospitals.remove(aHospital);
			}
		}
		return wasAdded;
	}

	/* Code from template association_RemoveMany */
	/**
	 * @brief Removes a hospital from the list of hospitals associated with this
	 *        person.
	 *
	 * @param aHospital the hospital to remove
	 * @return true if the hospital was successfully removed, false otherwise (e.g.,
	 *         if the hospital was not in the list)
	 */
	public boolean removeHospital(Hospital aHospital) {
		boolean wasRemoved = false;
		if (!hospitals.contains(aHospital)) {
			return wasRemoved;
		}

		int oldIndex = hospitals.indexOf(aHospital);
		hospitals.remove(oldIndex);
		if (aHospital.indexOfPerson(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aHospital.removePerson(this);
			if (!wasRemoved) {
				hospitals.add(oldIndex, aHospital);
			}
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * @brief Adds a hospital to the list of hospitals associated with this person
	 *        at the given index.
	 *
	 * @param aHospital the hospital to add
	 * @param index     the index at which to add the hospital
	 * @return true if the hospital was added successfully, false otherwise (e.g.,
	 *         if the hospital was already in the list)
	 */
	public boolean addHospitalAt(Hospital aHospital, int index) {
		boolean wasAdded = false;
		if (addHospital(aHospital)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfHospitals()) {
				index = numberOfHospitals() - 1;
			}
			hospitals.remove(aHospital);
			hospitals.add(index, aHospital);
			wasAdded = true;
		}
		return wasAdded;
	}

	/**
	 * @brief Adds a hospital to the list of hospitals associated with this person
	 *        at the given index, or moves it to the specified index if it is
	 *        already in the list.
	 *
	 * @param aHospital the hospital to add or move
	 * @param index     the index at which to add or move the hospital
	 * @return true if the hospital was added or moved successfully, false otherwise
	 */

	public boolean addOrMoveHospitalAt(Hospital aHospital, int index) {
		boolean wasAdded = false;
		if (hospitals.contains(aHospital)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfHospitals()) {
				index = numberOfHospitals() - 1;
			}
			hospitals.remove(aHospital);
			hospitals.add(index, aHospital);
			wasAdded = true;
		} else {
			wasAdded = addHospitalAt(aHospital, index);
		}
		return wasAdded;
	}

	public void delete() {
		ArrayList<Hospital> copyOfHospitals = new ArrayList<Hospital>(hospitals);
		hospitals.clear();
		for (Hospital aHospital : copyOfHospitals) {
			aHospital.removePerson(this);
		}
	}

	public String toString() {
		return super.toString() + "[" + "title" + ":" + getTitle() + "," + "givenName" + ":" + getGivenName() + ","
				+ "middleName" + ":" + getMiddleName() + "," + "familyName" + ":" + getFamilyName() + "," + "name" + ":"
				+ getName() + "," + "gender" + ":" + getGender() + "," + "homeAddress" + ":" + getHomeAddress() + ","
				+ "phone" + ":" + getPhone() + "]" + System.getProperties().getProperty("line.separator") + "  "
				+ "birthDate" + "="
				+ (getBirthDate() != null
						? !getBirthDate().equals(this) ? getBirthDate().toString().replaceAll("  ", "    ") : "this"
						: "null");
	}
}