/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_wards_and_teams_lib;
import java.util.*;
import ce204_hw2_organization_lib.*;
import ce204_hw2_organization_lib.Address;
import ce204_hw2_organization_lib.Phone;

// line 21 "../../model.ump"
// line 91 "../../model.ump"
// line 117 "../../model.ump"
public class HospitalWT extends Hospital
{

  public HospitalWT(String aName, String aAddress, String aPhone) {
		super(aName, aAddress, aPhone);
		// TODO Auto-generated constructor stub
	    address = aAddress;
	    phone = aPhone;
	    if (!setName(aName))
	    {
	      throw new RuntimeException("Cannot create due to duplicate name. See http://manual.umple.org?RE003ViolationofUniqueness.html");
	    }
	    wards = new ArrayList<Ward>();
	    teams = new ArrayList<Team>();
	}


//------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, HospitalWT> hospitalwtsByName = new HashMap<String, HospitalWT>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //HospitalWT Attributes
  private String name;
  private String address;
  private String phone;

  //HospitalWT Associations
  private List<Ward> wards;
  private List<Team> teams;

  //------------------------
  // CONSTRUCTOR
  //------------------------


  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    String anOldName = getName();
    if (anOldName != null && anOldName.equals(aName)) {
      return true;
    }
    if (hasWithName(aName)) {
      return wasSet;
    }
    name = aName;
    wasSet = true;
    if (anOldName != null) {
      hospitalwtsByName.remove(anOldName);
    }
    hospitalwtsByName.put(aName, this);
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhone(String aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template attribute_GetUnique */
  public static HospitalWT getWithName(String aName)
  {
    return hospitalwtsByName.get(aName);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithName(String aName)
  {
    return getWithName(aName) != null;
  }

  public String getAddress()
  {
    return address;
  }

  public String getPhone()
  {
    return phone;
  }
  /* Code from template association_GetMany */
  public Ward getWard(int index)
  {
    Ward aWard = wards.get(index);
    return aWard;
  }

  public List<Ward> getWards()
  {
    List<Ward> newWards = Collections.unmodifiableList(wards);
    return newWards;
  }

  public int numberOfWards()
  {
    int number = wards.size();
    return number;
  }

  public boolean hasWards()
  {
    boolean has = wards.size() > 0;
    return has;
  }

  public int indexOfWard(Ward aWard)
  {
    int index = wards.indexOf(aWard);
    return index;
  }
  /* Code from template association_GetMany */
  public Team getTeam(int index)
  {
    Team aTeam = teams.get(index);
    return aTeam;
  }

  public List<Team> getTeams()
  {
    List<Team> newTeams = Collections.unmodifiableList(teams);
    return newTeams;
  }

  public int numberOfTeams()
  {
    int number = teams.size();
    return number;
  }

  public boolean hasTeams()
  {
    boolean has = teams.size() > 0;
    return has;
  }

  public int indexOfTeam(Team aTeam)
  {
    int index = teams.indexOf(aTeam);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfWards()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Ward addWard(String aId, String aPatientsGender, int aCapacity)
  {
    return new Ward(aId, aPatientsGender, aCapacity, this);
  }

  public boolean addWard(Ward aWard)
  {
    boolean wasAdded = false;
    if (wards.contains(aWard)) { return false; }
    HospitalWT existingHospitalWT = aWard.getHospitalWT();
    boolean isNewHospitalWT = existingHospitalWT != null && !this.equals(existingHospitalWT);
    if (isNewHospitalWT)
    {
      aWard.setHospitalWT(this);
    }
    else
    {
      wards.add(aWard);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWard(Ward aWard)
  {
    boolean wasRemoved = false;
    //Unable to remove aWard, as it must always have a hospitalWT
    if (!this.equals(aWard.getHospitalWT()))
    {
      wards.remove(aWard);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addWardAt(Ward aWard, int index)
  {  
    boolean wasAdded = false;
    if(addWard(aWard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWards()) { index = numberOfWards() - 1; }
      wards.remove(aWard);
      wards.add(index, aWard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWardAt(Ward aWard, int index)
  {
    boolean wasAdded = false;
    if(wards.contains(aWard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWards()) { index = numberOfWards() - 1; }
      wards.remove(aWard);
      wards.add(index, aWard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWardAt(aWard, index);
    }
    return wasAdded;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfTeamsValid()
  {
    boolean isValid = numberOfTeams() >= minimumNumberOfTeams();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTeams()
  {
    return 1;
  }
  /* Code from template association_AddMandatoryManyToOne */
  public Team addTeam(String aName, ConsultantDoctor aConsultantDoctor)
  {
    Team aNewTeam = new Team(aName, this, aConsultantDoctor);
    return aNewTeam;
  }

  public boolean addTeam(Team aTeam)
  {
    boolean wasAdded = false;
    if (teams.contains(aTeam)) { return false; }
    HospitalWT existingHospitalWT = aTeam.getHospitalWT();
    boolean isNewHospitalWT = existingHospitalWT != null && !this.equals(existingHospitalWT);

    if (isNewHospitalWT && existingHospitalWT.numberOfTeams() <= minimumNumberOfTeams())
    {
      return wasAdded;
    }
    if (isNewHospitalWT)
    {
      aTeam.setHospitalWT(this);
    }
    else
    {
      teams.add(aTeam);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTeam(Team aTeam)
  {
    boolean wasRemoved = false;
    //Unable to remove aTeam, as it must always have a hospitalWT
    if (this.equals(aTeam.getHospitalWT()))
    {
      return wasRemoved;
    }

    //hospitalWT already at minimum (1)
    if (numberOfTeams() <= minimumNumberOfTeams())
    {
      return wasRemoved;
    }

    teams.remove(aTeam);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTeamAt(Team aTeam, int index)
  {  
    boolean wasAdded = false;
    if(addTeam(aTeam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTeams()) { index = numberOfTeams() - 1; }
      teams.remove(aTeam);
      teams.add(index, aTeam);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTeamAt(Team aTeam, int index)
  {
    boolean wasAdded = false;
    if(teams.contains(aTeam))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTeams()) { index = numberOfTeams() - 1; }
      teams.remove(aTeam);
      teams.add(index, aTeam);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTeamAt(aTeam, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    hospitalwtsByName.remove(getName());
    while (wards.size() > 0)
    {
      Ward aWard = wards.get(wards.size() - 1);
      aWard.delete();
      wards.remove(aWard);
    }
    
    while (teams.size() > 0)
    {
      Team aTeam = teams.get(teams.size() - 1);
      aTeam.delete();
      teams.remove(aTeam);
    }
    
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "," +
            "phone" + ":" + getPhone()+ "]";
  }
}