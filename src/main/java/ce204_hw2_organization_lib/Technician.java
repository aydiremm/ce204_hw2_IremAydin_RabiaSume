/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.sql.Date;
import java.util.*;

// line 109 "../../model.ump"
// line 210 "../../model.ump"
public class Technician extends TechnicalStaff {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * @brief Constructor for creating a Technician object with the given
	 *        attributes.
	 * @param aTitle         The title of the technician.
	 * @param aGivenName     The given name of the technician.
	 * @param aMiddleName    The middle name of the technician.
	 * @param aFamilyName    The family name of the technician.
	 * @param aBirthDate     The birth date of the technician.
	 * @param aGender        The gender of the technician.
	 * @param aHomeAddress   The home address of the technician.
	 * @param aPhone         The phone number of the technician.
	 * @param aJoined        The date when the technician joined the company.
	 * @param aEducation     The education level of the technician.
	 * @param aCertification The certification held by the technician.
	 * @param aLanguages     The languages spoken by the technician.
	 * @param aDepartment    The department where the technician works.
	 */

	public Technician(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification,
			String aLanguages, Department aDepartment) {
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