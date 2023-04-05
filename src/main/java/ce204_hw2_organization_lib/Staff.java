/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.sql.Date;
import java.util.*;

// line 119 "../../model.ump"
// line 220 "../../model.ump"
public class Staff extends Person {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Staff Attributes
	private Date joined;
	private String education;
	private String certification;
	private String languages;

	// Staff Associations
	private Department department;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	/**
	 * @brief Constructs a new Staff object.
	 * 
	 * @param aTitle         The staff's title.
	 * @param aGivenName     The staff's given name.
	 * @param aMiddleName    The staff's middle name.
	 * @param aFamilyName    The staff's family name.
	 * @param aBirthDate     The staff's birth date.
	 * @param aGender        The staff's gender.
	 * @param aHomeAddress   The staff's home address.
	 * @param aPhone         The staff's phone number.
	 * @param aJoined        The date the staff joined the company.
	 * @param aEducation     The staff's education level.
	 * @param aCertification The staff's certification.
	 * @param aLanguages     The staff's language proficiency.
	 * @param aDepartment    The department that the staff is part of.
	 * 
	 * @throw RuntimeException If the department is not set.
	 */

	public Staff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification,
			String aLanguages, Department aDepartment) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone);
		joined = aJoined;
		education = aEducation;
		certification = aCertification;
		languages = aLanguages;
		boolean didAddDepartment = setDepartment(aDepartment);
		if (!didAddDepartment) {
			throw new RuntimeException(
					"Unable to create staff due to department. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/**
	 * @brief Sets the date the staff joined the company.
	 * 
	 * @param aJoined The date the staff joined the company.
	 * @return True if the date was successfully set, false otherwise.
	 */

	public boolean setJoined(Date aJoined) {
		boolean wasSet = false;
		joined = aJoined;
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Sets the education level of the staff.
	 * 
	 * @param aEducation The education level of the staff.
	 * @return True if the education level was successfully set, false otherwise.
	 */

	public boolean setEducation(String aEducation) {
		boolean wasSet = false;
		education = aEducation;
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Sets the certification of the staff.
	 * 
	 * @param aCertification The certification of the staff.
	 * @return True if the certification was successfully set, false otherwise.
	 */

	public boolean setCertification(String aCertification) {
		boolean wasSet = false;
		certification = aCertification;
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Sets the language proficiency of the staff.
	 * 
	 * @param aLanguages The language proficiency of the staff.
	 * @return True if the language proficiency was successfully set, false
	 *         otherwise.
	 */

	public boolean setLanguages(String aLanguages) {
		boolean wasSet = false;
		languages = aLanguages;
		wasSet = true;
		return wasSet;
	}

	public Date getJoined() {
		return joined;
	}

	public String getEducation() {
		return education;
	}

	public String getCertification() {
		return certification;
	}

	public String getLanguages() {
		return languages;
	}

	/* Code from template association_GetOne */
	public Department getDepartment() {
		return department;
	}

	/* Code from template association_SetOneToMany */
	/**
	 * @brief Sets the department of this staff member.
	 *
	 * @param aDepartment The department of this staff member.
	 * @return True if the department was successfully set, false otherwise.
	 */
	public boolean setDepartment(Department aDepartment) {
		boolean wasSet = false;
		if (aDepartment == null) {
			return wasSet;
		}

		Department existingDepartment = department;
		department = aDepartment;
		if (existingDepartment != null && !existingDepartment.equals(aDepartment)) {
			existingDepartment.removeStaff(this);
		}
		department.addStaff(this);
		wasSet = true;
		return wasSet;
	}

	public void delete() {
		Department placeholderDepartment = department;
		this.department = null;
		if (placeholderDepartment != null) {
			placeholderDepartment.removeStaff(this);
		}
		super.delete();
	}

	public String toString() {
		return super.toString() + "[" + "education" + ":" + getEducation() + "," + "certification" + ":"
				+ getCertification() + "," + "languages" + ":" + getLanguages() + "]"
				+ System.getProperties().getProperty("line.separator") + "  " + "joined" + "="
				+ (getJoined() != null
						? !getJoined().equals(this) ? getJoined().toString().replaceAll("  ", "    ") : "this"
						: "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "department = "
				+ (getDepartment() != null ? Integer.toHexString(System.identityHashCode(getDepartment())) : "null");
	}
}