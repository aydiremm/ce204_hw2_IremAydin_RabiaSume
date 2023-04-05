/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.sql.Date;
import java.util.*;

// line 128 "../../model.ump"
// line 225 "../../model.ump"
public class SurgicalTechnologist extends Technologist {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * @brief Constructs a new SurgicalTechnologist object with the specified
	 *        properties.
	 *
	 * @param aTitle         The title of the surgical technologist.
	 * @param aGivenName     The given name of the surgical technologist.
	 * @param aMiddleName    The middle name of the surgical technologist.
	 * @param aFamilyName    The family name of the surgical technologist.
	 * @param aBirthDate     The birth date of the surgical technologist.
	 * @param aGender        The gender of the surgical technologist.
	 * @param aHomeAddress   The home address of the surgical technologist.
	 * @param aPhone         The phone number of the surgical technologist.
	 * @param aJoined        The date the surgical technologist joined.
	 * @param aEducation     The education of the surgical technologist.
	 * @param aCertification The certification of the surgical technologist.
	 * @param aLanguages     The languages spoken by the surgical technologist.
	 * @param aDepartment    The department that the surgical technologist belongs
	 *                       to.
	 */

	public SurgicalTechnologist(String aTitle, String aGivenName, String aMiddleName, String aFamilyName,
			Date aBirthDate, String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation,
			String aCertification, String aLanguages, Department aDepartment) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined,
				aEducation, aCertification, aLanguages, aDepartment);
	}

	// ------------------------
	// INTERFACE
	// ------------------------

	public void delete() {
		super.delete();
	}

}