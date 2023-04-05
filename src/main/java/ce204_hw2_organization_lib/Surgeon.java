/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.util.*;
import java.sql.Date;

// line 89 "../../model.ump"
// line 190 "../../model.ump"
public class Surgeon extends Doctor {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * @brief Constructs a new Surgeon object with the specified properties.
	 *
	 * @param aTitle         The title of the surgeon.
	 * @param aGivenName     The given name of the surgeon.
	 * @param aMiddleName    The middle name of the surgeon.
	 * @param aFamilyName    The family name of the surgeon.
	 * @param aBirthDate     The birth date of the surgeon.
	 * @param aGender        The gender of the surgeon.
	 * @param aHomeAddress   The home address of the surgeon.
	 * @param aPhone         The phone number of the surgeon.
	 * @param aJoined        The date the surgeon joined.
	 * @param aEducation     The education of the surgeon.
	 * @param aCertification The certification of the surgeon.
	 * @param aLanguages     The languages spoken by the surgeon.
	 * @param aDepartment    The department that the surgeon belongs to.
	 * @param aSpecialty     The specialty of the surgeon.
	 * @param aLocations     The locations where the surgeon practices.
	 */
	public Surgeon(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification,
			String aLanguages, Department aDepartment, String aSpecialty, String aLocations) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined,
				aEducation, aCertification, aLanguages, aDepartment, aSpecialty, aLocations);
	}

	// ------------------------
	// INTERFACE
	// ------------------------

	public void delete() {
		super.delete();
	}

}