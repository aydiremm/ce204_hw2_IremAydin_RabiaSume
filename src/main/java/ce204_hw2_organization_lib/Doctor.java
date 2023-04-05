/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.util.*;
import java.sql.Date;

// line 77 "../../model.ump"
// line 180 "../../model.ump"
public class Doctor extends OperationsStaff {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Doctor Attributes
	private String specialty;
	private String locations;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * Constructor for Doctor class.
	 * 
	 * @param aTitle         The title of the doctor.
	 * @param aGivenName     The given name of the doctor.
	 * @param aMiddleName    The middle name of the doctor.
	 * @param aFamilyName    The family name of the doctor.
	 * @param aBirthDate     The birth date of the doctor.
	 * @param aGender        The gender of the doctor.
	 * @param aHomeAddress   The home address of the doctor.
	 * @param aPhone         The phone number of the doctor.
	 * @param aJoined        The date the doctor joined the organization.
	 * @param aEducation     The education level of the doctor.
	 * @param aCertification The certifications of the doctor.
	 * @param aLanguages     The languages the doctor speaks.
	 * @param aDepartment    The department the doctor is a part of.
	 * @param aSpecialty     The specialty of the doctor.
	 * @param aLocations     The locations where the doctor practices.
	 */

	public Doctor(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification,
			String aLanguages, Department aDepartment, String aSpecialty, String aLocations) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined,
				aEducation, aCertification, aLanguages, aDepartment);
		specialty = aSpecialty;
		locations = aLocations;
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/**
	 * Sets the specialty of the doctor.
	 * 
	 * @param aSpecialty The specialty of the doctor.
	 * @return Returns true if the specialty is set successfully, false otherwise.
	 */

	public boolean setSpecialty(String aSpecialty) {
		boolean wasSet = false;
		specialty = aSpecialty;
		wasSet = true;
		return wasSet;
	}

	/**
	 * Sets the locations where the doctor practices.
	 * 
	 * @param aLocations The locations where the doctor practices.
	 * @return Returns true if the locations are set successfully, false otherwise.
	 */

	public boolean setLocations(String aLocations) {
		boolean wasSet = false;
		locations = aLocations;
		wasSet = true;
		return wasSet;
	}

	/**
	 * Gets the specialty of the doctor.
	 * 
	 * @return The specialty of the doctor.
	 */

	public String getSpecialty() {
		return specialty;
	}

	/**
	 * Gets the locations where the doctor practices.
	 * 
	 * @return The locations where the doctor practices.
	 */

	public String getLocations() {
		return locations;
	}

	/**
	 * Deletes the doctor entity.
	 */

	public void delete() {
		super.delete();
	}

	/**
	 * Returns a string representation of this Doctor object, including its
	 * attributes.
	 *
	 * @return A string containing the values of the object's attributes.
	 */

	public String toString() {
		return super.toString() + "[" + "specialty" + ":" + getSpecialty() + "," + "locations" + ":" + getLocations()
				+ "]";
	}
}