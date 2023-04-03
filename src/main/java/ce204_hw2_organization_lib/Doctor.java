/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package ce204_hw2_organization_lib;
import java.util.*;
import java.sql.Date;

// line 76 "../organization.ump"
// line 179 "../organization.ump"
public class Doctor extends OperationsStaff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Doctor Attributes
  private List<String> specialty;
  private List<String> locations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Doctor(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate, Gender aGender, Address aHomeAddress, Phone aPhone, Date aJoined, Department aDepartment)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined, aDepartment);
    specialty = new ArrayList<String>();
    locations = new ArrayList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template attribute_SetMany */
  public boolean addSpecialty(String aSpecialty)
  {
    boolean wasAdded = false;
    wasAdded = specialty.add(aSpecialty);
    return wasAdded;
  }

  public boolean removeSpecialty(String aSpecialty)
  {
    boolean wasRemoved = false;
    wasRemoved = specialty.remove(aSpecialty);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  public boolean addLocation(String aLocation)
  {
    boolean wasAdded = false;
    wasAdded = locations.add(aLocation);
    return wasAdded;
  }

  public boolean removeLocation(String aLocation)
  {
    boolean wasRemoved = false;
    wasRemoved = locations.remove(aLocation);
    return wasRemoved;
  }
  /* Code from template attribute_GetMany */
  public String getSpecialty(int index)
  {
    String aSpecialty = specialty.get(index);
    return aSpecialty;
  }

  public String[] getSpecialty()
  {
    String[] newSpecialty = specialty.toArray(new String[specialty.size()]);
    return newSpecialty;
  }

  public int numberOfSpecialty()
  {
    int number = specialty.size();
    return number;
  }

  public boolean hasSpecialty()
  {
    boolean has = specialty.size() > 0;
    return has;
  }

  public int indexOfSpecialty(String aSpecialty)
  {
    int index = specialty.indexOf(aSpecialty);
    return index;
  }
  /* Code from template attribute_GetMany */
  public String getLocation(int index)
  {
    String aLocation = locations.get(index);
    return aLocation;
  }

  public String[] getLocations()
  {
    String[] newLocations = locations.toArray(new String[locations.size()]);
    return newLocations;
  }

  public int numberOfLocations()
  {
    int number = locations.size();
    return number;
  }

  public boolean hasLocations()
  {
    boolean has = locations.size() > 0;
    return has;
  }

  public int indexOfLocation(String aLocation)
  {
    int index = locations.indexOf(aLocation);
    return index;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+ "]";
  }
}