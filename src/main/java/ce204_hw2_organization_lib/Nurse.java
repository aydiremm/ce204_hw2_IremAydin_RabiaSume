/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.util.*;
import java.sql.Date;

// line 84 "../../model.ump"
// line 185 "../../model.ump"
public class Nurse extends OperationsStaff {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * @brief Constructs a Nurse object with the given parameters.
	 * 
	 * @param aTitle         The nurse's title.
	 * @param aGivenName     The nurse's given name.
	 * @param aMiddleName    The nurse's middle name.
	 * @param aFamilyName    The nurse's family name.
	 * @param aBirthDate     The nurse's birth date.
	 * @param aGender        The nurse's gender.
	 * @param aHomeAddress   The nurse's home address.
	 * @param aPhone         The nurse's phone number.
	 * @param aJoined        The date when the nurse joined the department.
	 * @param aEducation     The nurse's education.
	 * @param aCertification The nurse's certification.
	 * @param aLanguages     The nurse's languages.
	 * @param aDepartment    The department to which the nurse belongs.
	 */

	public Nurse(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
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