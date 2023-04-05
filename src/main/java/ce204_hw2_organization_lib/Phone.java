/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

// line 11 "../../model.ump"
// line 138 "../../model.ump"
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

  public Phone(String aPhoneNumber, String aPhoneHolderName, String aRelation)
  {
    phoneNumber = aPhoneNumber;
    phoneHolderName = aPhoneHolderName;
    relation = aRelation;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setPhoneNumber(String aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneHolderName(String aPhoneHolderName)
  {
    boolean wasSet = false;
    phoneHolderName = aPhoneHolderName;
    wasSet = true;
    return wasSet;
  }

  public boolean setRelation(String aRelation)
  {
    boolean wasSet = false;
    relation = aRelation;
    wasSet = true;
    return wasSet;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getPhoneHolderName()
  {
    return phoneHolderName;
  }

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