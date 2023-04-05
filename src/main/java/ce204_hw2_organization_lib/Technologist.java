/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;
import java.sql.Date;
import java.util.*;

// line 113 "../organization.ump"
// line 214 "../organization.ump"
public class Technologist extends TechnicalStaff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------
	/**
	 * @brief Constructor for creating a Technologist object with the given
	 *        attributes.
	 * @param aTitle         The title of the technologist.
	 * @param aGivenName     The given name of the technologist.
	 * @param aMiddleName    The middle name of the technologist.
	 * @param aFamilyName    The family name of the technologist.
	 * @param aBirthDate     The birth date of the technologist.
	 * @param aGender        The gender of the technologist.
	 * @param aHomeAddress   The home address of the technologist.
	 * @param aPhone         The phone number of the technologist.
	 * @param aJoined        The date when the technologist joined the company.
	 * @param aEducation     The education level of the technologist.
	 * @param aCertification The certification held by the technologist.
	 * @param aLanguages     The languages spoken by the technologist.
	 * @param aDepartment    The department where the technologist works.
	 */

  public Technologist(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate, Gender aGender, Address aHomeAddress, Phone aPhone, Date aJoined, Department aDepartment)
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