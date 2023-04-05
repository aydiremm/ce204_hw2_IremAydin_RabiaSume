/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;
import java.sql.Date;
import java.util.*;

// line 118 "../organization.ump"
// line 219 "../organization.ump"
public class Staff extends Person
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Staff Attributes
  private Date joined;
  private List<String> education;
  private List<String> certification;
  private List<String> languages;

  //Staff Associations
  private Department department;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Staff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate, Gender aGender, Address aHomeAddress, Phone aPhone, Date aJoined, Department aDepartment)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone);
    joined = aJoined;
    education = new ArrayList<String>();
    certification = new ArrayList<String>();
    languages = new ArrayList<String>();
    boolean didAddDepartment = setDepartment(aDepartment);
    if (!didAddDepartment)
    {
      throw new RuntimeException("Unable to create staff due to department. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setJoined(Date aJoined)
  {
    boolean wasSet = false;
    joined = aJoined;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetMany */
  public boolean addEducation(String aEducation)
  {
    boolean wasAdded = false;
    wasAdded = education.add(aEducation);
    return wasAdded;
  }

  public boolean removeEducation(String aEducation)
  {
    boolean wasRemoved = false;
    wasRemoved = education.remove(aEducation);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  public boolean addCertification(String aCertification)
  {
    boolean wasAdded = false;
    wasAdded = certification.add(aCertification);
    return wasAdded;
  }

  public boolean removeCertification(String aCertification)
  {
    boolean wasRemoved = false;
    wasRemoved = certification.remove(aCertification);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  public boolean addLanguage(String aLanguage)
  {
    boolean wasAdded = false;
    wasAdded = languages.add(aLanguage);
    return wasAdded;
  }

  public boolean removeLanguage(String aLanguage)
  {
    boolean wasRemoved = false;
    wasRemoved = languages.remove(aLanguage);
    return wasRemoved;
  }

  public Date getJoined()
  {
    return joined;
  }
  /* Code from template attribute_GetMany */
  public String getEducation(int index)
  {
    String aEducation = education.get(index);
    return aEducation;
  }

  public String[] getEducation()
  {
    String[] newEducation = education.toArray(new String[education.size()]);
    return newEducation;
  }

  public int numberOfEducation()
  {
    int number = education.size();
    return number;
  }

  public boolean hasEducation()
  {
    boolean has = education.size() > 0;
    return has;
  }

  public int indexOfEducation(String aEducation)
  {
    int index = education.indexOf(aEducation);
    return index;
  }
  /* Code from template attribute_GetMany */
  public String getCertification(int index)
  {
    String aCertification = certification.get(index);
    return aCertification;
  }

  public String[] getCertification()
  {
    String[] newCertification = certification.toArray(new String[certification.size()]);
    return newCertification;
  }

  public int numberOfCertification()
  {
    int number = certification.size();
    return number;
  }

  public boolean hasCertification()
  {
    boolean has = certification.size() > 0;
    return has;
  }

  public int indexOfCertification(String aCertification)
  {
    int index = certification.indexOf(aCertification);
    return index;
  }
  /* Code from template attribute_GetMany */
  public String getLanguage(int index)
  {
    String aLanguage = languages.get(index);
    return aLanguage;
  }

  public String[] getLanguages()
  {
    String[] newLanguages = languages.toArray(new String[languages.size()]);
    return newLanguages;
  }

  public int numberOfLanguages()
  {
    int number = languages.size();
    return number;
  }

  public boolean hasLanguages()
  {
    boolean has = languages.size() > 0;
    return has;
  }

  public int indexOfLanguage(String aLanguage)
  {
    int index = languages.indexOf(aLanguage);
    return index;
  }
  /* Code from template association_GetOne */
  public Department getDepartment()
  {
    return department;
  }
  /* Code from template association_SetOneToMany */
  public boolean setDepartment(Department aDepartment)
  {
    boolean wasSet = false;
    if (aDepartment == null)
    {
      return wasSet;
    }

    Department existingDepartment = department;
    department = aDepartment;
    if (existingDepartment != null && !existingDepartment.equals(aDepartment))
    {
      existingDepartment.removeStaff(this);
    }
    department.addStaff(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Department placeholderDepartment = department;
    this.department = null;
    if(placeholderDepartment != null)
    {
      placeholderDepartment.removeStaff(this);
    }
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "joined" + "=" + (getJoined() != null ? !getJoined().equals(this)  ? getJoined().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "department = "+(getDepartment()!=null?Integer.toHexString(System.identityHashCode(getDepartment())):"null");
  }
}