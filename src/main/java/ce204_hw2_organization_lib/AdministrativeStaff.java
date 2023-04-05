/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;
import java.sql.Date;
import java.util.*;

// line 71 "../organization.ump"
// line 174 "../organization.ump"
/**
 * @brief The AdministrativeStaff class represents the administrative staff in
 *        an organization.
 * @details AdministrativeStaff class inherits from the Staff class. it has no
 *          additional member variables or methods compared to the Staff class.
 */
public class AdministrativeStaff extends Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

	/**
	 * @brief Constructor for the AdministrativeStaff class.
	 * @param aTitle         The title of the administrative staff member.
	 * @param aGivenName     The given name of the administrative staff member.
	 * @param aMiddleName    The middle name of the administrative staff member.
	 * @param aFamilyName    The family name of the administrative staff member.
	 * @param aBirthDate     The birth date of the administrative staff member.
	 * @param aGender        The gender of the administrative staff member.
	 * @param aHomeAddress   The home address of the administrative staff member.
	 * @param aPhone         The phone number of the administrative staff member.
	 * @param aJoined        The date the administrative staff member joined the
	 *                       organization.
	 * @param aEducation     The education level of the administrative staff member.
	 * @param aCertification The certification level of the administrative staff
	 *                       member.
	 * @param aLanguages     The languages spoken by the administrative staff
	 *                       member.
	 * @param aDepartment    The department the administrative staff member belongs
	 *                       to.
	 */
  public AdministrativeStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate, Gender aGender, Address aHomeAddress, Phone aPhone, Date aJoined, Department aDepartment)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined, aDepartment);
  }

  //------------------------
  // INTERFACE
  //------------------------
	/**
	 * @brief Deletes the AdministrativeStaff object.
	 * @details Calls the delete method of the parent class, Staff.
	 */
  public void delete()
  {
    super.delete();
  }

}