/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;
import java.sql.Date;
import java.util.*;

// line 103 "../organization.ump"
// line 204 "../organization.ump"
public class TechnicalStaff extends Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------
	/**
	 * Constructs a new TechnicalStaff object with the given attributes.
	 *
	 * @param aTitle         the title of the technical staff
	 * @param aGivenName     the given name of the technical staff
	 * @param aMiddleName    the middle name of the technical staff
	 * @param aFamilyName    the family name of the technical staff
	 * @param aBirthDate     the birth date of the technical staff
	 * @param aGender        the gender of the technical staff
	 * @param aHomeAddress   the home address of the technical staff
	 * @param aPhone         the phone number of the technical staff
	 * @param aJoined        the join date of the technical staff
	 * @param aEducation     the education level of the technical staff
	 * @param aCertification the certification(s) held by the technical staff
	 * @param aLanguages     the language(s) spoken by the technical staff
	 * @param aDepartment    the department the technical staff is in
	 */
  public TechnicalStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate, Gender aGender, Address aHomeAddress, Phone aPhone, Date aJoined, Department aDepartment)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined, aDepartment);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}