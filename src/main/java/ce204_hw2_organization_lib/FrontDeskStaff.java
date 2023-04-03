/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

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

  public FrontDeskStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate, Gender aGender, Address aHomeAddress, Phone aPhone, Date aJoined, Department aDepartment)
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