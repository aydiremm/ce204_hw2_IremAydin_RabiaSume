/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.sql.Date;
import java.util.*;

// line 99 "../../model.ump"
// line 200 "../../model.ump"
public class Receptionist extends FrontDeskStaff {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * 
	 * Constructor for a Receptionist object.
	 * 
	 * @param aTitle         the title of the receptionist
	 * @param aGivenName     the given name of the receptionist
	 * @param aMiddleName    the middle name of the receptionist
	 * @param aFamilyName    the family name of the receptionist
	 * @param aBirthDate     the birth date of the receptionist
	 * @param aGender        the gender of the receptionist
	 * @param aHomeAddress   the home address of the receptionist
	 * @param aPhone         the phone number of the receptionist
	 * @param aJoined        the date when the receptionist joined the company
	 * @param aEducation     the education level of the receptionist
	 * @param aCertification the certification level of the receptionist
	 * @param aLanguages     the languages spoken by the receptionist
	 * @param aDepartment    the department where the receptionist works
	 */

	public Receptionist(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
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