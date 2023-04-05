/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_wards_and_teams_lib;

// line 15 "../wards_and_teams.ump"
// line 95 "../wards_and_teams.ump"
public class Phone
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Phone Attributes
  private String phoneNumber;
  private String phoneHolderName;
  private String relation;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  /**

  Constructor for the Phone class.
  @param aPhoneNumber Phone number of the phone object.
  @param aPhoneHolderName Name of the person who holds the phone object.
  @param aRelation Relation of the person who holds the phone object.
  */

  public Phone(String aPhoneNumber, String aPhoneHolderName, String aRelation)
  {
    phoneNumber = aPhoneNumber;
    phoneHolderName = aPhoneHolderName;
    relation = aRelation;
  }

  //------------------------
  // INTERFACE
  //------------------------

  /**

  Setter method for the phoneNumber attribute.
  @param aPhoneNumber Phone number of the phone object.
  @return True if the attribute is set, false otherwise.
  */
  public boolean setPhoneNumber(String aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }
  /**

  Setter method for the phoneHolderName attribute.
  @param aPhoneHolderName Name of the person who holds the phone object.
  @return True if the attribute is set, false otherwise.
  */

  public boolean setPhoneHolderName(String aPhoneHolderName)
  {
    boolean wasSet = false;
    phoneHolderName = aPhoneHolderName;
    wasSet = true;
    return wasSet;
  }
  /**

  Setter method for the relation attribute.
  @param aRelation Relation of the person who holds the phone object.
  @return True if the attribute is set, false otherwise.
  */

  public boolean setRelation(String aRelation)
  {
    boolean wasSet = false;
    relation = aRelation;
    wasSet = true;
    return wasSet;
  }
  /**

  Getter method for the phoneNumber attribute.
  @return The phone number of the phone object.
  */
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
  /**

  Getter method for the phoneHolderName attribute.
  @return The name of the person who holds the phone object.
  */

  public String getPhoneHolderName()
  {
    return phoneHolderName;
  }
  /**

  Getter method for the relation attribute.
  @return The relation of the person who holds the phone object.
  */
  public String getRelation()
  {
    return relation;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "phoneNumber" + ":" + getPhoneNumber()+ "," +
            "phoneHolderName" + ":" + getPhoneHolderName()+ "," +
            "relation" + ":" + getRelation()+ "]";
  }
}