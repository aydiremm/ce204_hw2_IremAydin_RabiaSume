/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

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
	/**
	 * Constructor for Doctor class.
	 * 
	 * @param aTitle         The title of the doctor.
	 * @param aGivenName     The given name of the doctor.
	 * @param aMiddleName    The middle name of the doctor.
	 * @param aFamilyName    The family name of the doctor.
	 * @param aBirthDate     The birth date of the doctor.
	 * @param aGender        The gender of the doctor.
	 * @param aHomeAddress   The home address of the doctor.
	 * @param aPhone         The phone number of the doctor.
	 * @param aJoined        The date the doctor joined the organization.
	 * @param aEducation     The education level of the doctor.
	 * @param aCertification The certifications of the doctor.
	 * @param aLanguages     The languages the doctor speaks.
	 * @param aDepartment    The department the doctor is a part of.
	 * @param aSpecialty     The specialty of the doctor.
	 * @param aLocations     The locations where the doctor practices.
	 */

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
	/**
	 * Sets the specialty of the doctor.
	 * 
	 * @param aSpecialty The specialty of the doctor.
	 * @return Returns true if the specialty is set successfully, false otherwise.
	 */
  public boolean addSpecialty(String aSpecialty)
  {
    boolean wasAdded = false;
    wasAdded = specialty.add(aSpecialty);
    return wasAdded;
  }

	/**
	 * Sets the locations where the doctor practices.
	 * 
	 * @param aLocations The locations where the doctor practices.
	 * @return Returns true if the locations are set successfully, false otherwise.
	 */

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

	/**
	 * Gets the specialty of the doctor.
	 * 
	 * @return The specialty of the doctor.
	 */

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

	/**
	 * Gets the locations where the doctor practices.
	 * 
	 * @return The locations where the doctor practices.
	 */

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


	/**
	 * Deletes the doctor entity.
	 */

  public void delete()
  {
    super.delete();
  }


	/**
	 * Returns a string representation of this Doctor object, including its
	 * attributes.
	 *
	 * @return A string containing the values of the object's attributes.
	 */

  public String toString()
  {
    return super.toString() + "["+ "]";
  }
}