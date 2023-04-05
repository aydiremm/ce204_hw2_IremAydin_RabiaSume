/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;
import java.sql.Date;
import java.util.*;

// line 93 "../organization.ump"
// line 194 "../organization.ump"
public class FrontDeskStaff extends AdministrativeStaff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

	/**
	 * 
	 * @brief Constructor for creating a Front Desk Staff object with given
	 *        properties.
	 * @param aTitle         the title of the staff member
	 * @param aGivenName     the given name of the staff member
	 * @param aMiddleName    the middle name of the staff member
	 * @param aFamilyName    the family name of the staff member
	 * @param aBirthDate     the birth date of the staff member
	 * @param aGender        the gender of the staff member
	 * @param aHomeAddress   the home address of the staff member
	 * @param aPhone         the phone number of the staff member
	 * @param aJoined        the joining date of the staff member
	 * @param aEducation     the education level of the staff member
	 * @param aCertification the certifications of the staff member
	 * @param aLanguages     the languages known by the staff member
	 * @param aDepartment    the department the staff member belongs to
	 */

  public FrontDeskStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate, Gender aGender, Address aHomeAddress, Phone aPhone, Date aJoined, Department aDepartment)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined, aDepartment);
  }

  //------------------------
  // INTERFACE
  //------------------------
	/**
	 * 
	 * @brief This method is used to delete a Front Desk Staff object.
	 */

  public void delete()
  {
    super.delete();
  }

}