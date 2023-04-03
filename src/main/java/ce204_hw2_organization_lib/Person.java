/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package ce204_hw2_organization_lib;
import java.sql.Date;
import java.util.*;

// line 20 "../organization.ump"
// line 147 "../organization.ump"
public class Person
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Gender { Male, Female }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Person Attributes
  private String title;
  private String givenName;
  private String middleName;
  private String familyName;
  private Date birthDate;
  private Gender gender;
  private Address homeAddress;
  private Phone phone;

  //Person Associations
  private List<Hospital> hospitals;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Person(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate, Gender aGender, Address aHomeAddress, Phone aPhone)
  {
    title = aTitle;
    givenName = aGivenName;
    middleName = aMiddleName;
    familyName = aFamilyName;
    birthDate = aBirthDate;
    gender = aGender;
    homeAddress = aHomeAddress;
    phone = aPhone;
    hospitals = new ArrayList<Hospital>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTitle(String aTitle)
  {
    boolean wasSet = false;
    title = aTitle;
    wasSet = true;
    return wasSet;
  }

  public boolean setGivenName(String aGivenName)
  {
    boolean wasSet = false;
    givenName = aGivenName;
    wasSet = true;
    return wasSet;
  }

  public boolean setMiddleName(String aMiddleName)
  {
    boolean wasSet = false;
    middleName = aMiddleName;
    wasSet = true;
    return wasSet;
  }

  public boolean setFamilyName(String aFamilyName)
  {
    boolean wasSet = false;
    familyName = aFamilyName;
    wasSet = true;
    return wasSet;
  }

  public boolean setBirthDate(Date aBirthDate)
  {
    boolean wasSet = false;
    birthDate = aBirthDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setGender(Gender aGender)
  {
    boolean wasSet = false;
    gender = aGender;
    wasSet = true;
    return wasSet;
  }

  public boolean setHomeAddress(Address aHomeAddress)
  {
    boolean wasSet = false;
    homeAddress = aHomeAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhone(Phone aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public String getTitle()
  {
    return title;
  }

  public String getGivenName()
  {
    return givenName;
  }

  public String getMiddleName()
  {
    return middleName;
  }

  public String getFamilyName()
  {
    return familyName;
  }

  public String getName()
  {
    return title + " " + givenName + " " + middleName + " " + familyName;
  }

  public Date getBirthDate()
  {
    return birthDate;
  }

  public Gender getGender()
  {
    return gender;
  }

  public Address getHomeAddress()
  {
    return homeAddress;
  }

  public Phone getPhone()
  {
    return phone;
  }
  /* Code from template association_GetMany */
  public Hospital getHospital(int index)
  {
    Hospital aHospital = hospitals.get(index);
    return aHospital;
  }

  public List<Hospital> getHospitals()
  {
    List<Hospital> newHospitals = Collections.unmodifiableList(hospitals);
    return newHospitals;
  }

  public int numberOfHospitals()
  {
    int number = hospitals.size();
    return number;
  }

  public boolean hasHospitals()
  {
    boolean has = hospitals.size() > 0;
    return has;
  }

  public int indexOfHospital(Hospital aHospital)
  {
    int index = hospitals.indexOf(aHospital);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfHospitals()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addHospital(Hospital aHospital)
  {
    boolean wasAdded = false;
    if (hospitals.contains(aHospital)) { return false; }
    hospitals.add(aHospital);
    if (aHospital.indexOfPerson(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aHospital.addPerson(this);
      if (!wasAdded)
      {
        hospitals.remove(aHospital);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeHospital(Hospital aHospital)
  {
    boolean wasRemoved = false;
    if (!hospitals.contains(aHospital))
    {
      return wasRemoved;
    }

    int oldIndex = hospitals.indexOf(aHospital);
    hospitals.remove(oldIndex);
    if (aHospital.indexOfPerson(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aHospital.removePerson(this);
      if (!wasRemoved)
      {
        hospitals.add(oldIndex,aHospital);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addHospitalAt(Hospital aHospital, int index)
  {  
    boolean wasAdded = false;
    if(addHospital(aHospital))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHospitals()) { index = numberOfHospitals() - 1; }
      hospitals.remove(aHospital);
      hospitals.add(index, aHospital);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveHospitalAt(Hospital aHospital, int index)
  {
    boolean wasAdded = false;
    if(hospitals.contains(aHospital))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfHospitals()) { index = numberOfHospitals() - 1; }
      hospitals.remove(aHospital);
      hospitals.add(index, aHospital);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addHospitalAt(aHospital, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Hospital> copyOfHospitals = new ArrayList<Hospital>(hospitals);
    hospitals.clear();
    for(Hospital aHospital : copyOfHospitals)
    {
      aHospital.removePerson(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "title" + ":" + getTitle()+ "," +
            "givenName" + ":" + getGivenName()+ "," +
            "middleName" + ":" + getMiddleName()+ "," +
            "familyName" + ":" + getFamilyName()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "birthDate" + "=" + (getBirthDate() != null ? !getBirthDate().equals(this)  ? getBirthDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "gender" + "=" + (getGender() != null ? !getGender().equals(this)  ? getGender().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "homeAddress" + "=" + (getHomeAddress() != null ? !getHomeAddress().equals(this)  ? getHomeAddress().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "phone" + "=" + (getPhone() != null ? !getPhone().equals(this)  ? getPhone().toString().replaceAll("  ","    ") : "this" : "null");
  }
}