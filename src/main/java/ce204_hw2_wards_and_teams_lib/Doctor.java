/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package ce204_hw2_wards_and_teams_lib;
import java.util.*;

// line 65 "../wards_and_teams.ump"
// line 123 "../wards_and_teams.ump"
public class Doctor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Doctor Attributes
  private List<String> specialty;
  private List<String> locations;

  //Doctor Associations
  private List<Patient> treats;
  private Team team;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Doctor()
  {
    specialty = new ArrayList<String>();
    locations = new ArrayList<String>();
    treats = new ArrayList<Patient>();
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
  /* Code from template association_GetMany */
  public Patient getTreat(int index)
  {
    Patient aTreat = treats.get(index);
    return aTreat;
  }

  public List<Patient> getTreats()
  {
    List<Patient> newTreats = Collections.unmodifiableList(treats);
    return newTreats;
  }

  public int numberOfTreats()
  {
    int number = treats.size();
    return number;
  }

  public boolean hasTreats()
  {
    boolean has = treats.size() > 0;
    return has;
  }

  public int indexOfTreat(Patient aTreat)
  {
    int index = treats.indexOf(aTreat);
    return index;
  }
  /* Code from template association_GetOne */
  public Team getTeam()
  {
    return team;
  }

  public boolean hasTeam()
  {
    boolean has = team != null;
    return has;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTreats()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTreat(Patient aTreat)
  {
    boolean wasAdded = false;
    if (treats.contains(aTreat)) { return false; }
    treats.add(aTreat);
    if (aTreat.indexOfDoctor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTreat.addDoctor(this);
      if (!wasAdded)
      {
        treats.remove(aTreat);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTreat(Patient aTreat)
  {
    boolean wasRemoved = false;
    if (!treats.contains(aTreat))
    {
      return wasRemoved;
    }

    int oldIndex = treats.indexOf(aTreat);
    treats.remove(oldIndex);
    if (aTreat.indexOfDoctor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTreat.removeDoctor(this);
      if (!wasRemoved)
      {
        treats.add(oldIndex,aTreat);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTreatAt(Patient aTreat, int index)
  {  
    boolean wasAdded = false;
    if(addTreat(aTreat))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreats()) { index = numberOfTreats() - 1; }
      treats.remove(aTreat);
      treats.add(index, aTreat);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTreatAt(Patient aTreat, int index)
  {
    boolean wasAdded = false;
    if(treats.contains(aTreat))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreats()) { index = numberOfTreats() - 1; }
      treats.remove(aTreat);
      treats.add(index, aTreat);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTreatAt(aTreat, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setTeam(Team aTeam)
  {
    boolean wasSet = false;
    Team existingTeam = team;
    team = aTeam;
    if (existingTeam != null && !existingTeam.equals(aTeam))
    {
      existingTeam.removeDoctor(this);
    }
    if (aTeam != null)
    {
      aTeam.addDoctor(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Patient> copyOfTreats = new ArrayList<Patient>(treats);
    treats.clear();
    for(Patient aTreat : copyOfTreats)
    {
      aTreat.removeDoctor(this);
    }
    if (team != null)
    {
      Team placeholderTeam = team;
      this.team = null;
      placeholderTeam.removeDoctor(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "team = "+(getTeam()!=null?Integer.toHexString(System.identityHashCode(getTeam())):"null");
  }
}