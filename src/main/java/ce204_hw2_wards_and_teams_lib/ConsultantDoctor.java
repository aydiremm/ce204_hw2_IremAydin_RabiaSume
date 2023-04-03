/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package ce204_hw2_wards_and_teams_lib;
import java.util.*;
import java.sql.Date;

// line 78 "../wards_and_teams.ump"
// line 134 "../wards_and_teams.ump"
public class ConsultantDoctor extends Doctor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConsultantDoctor Associations
  private Team team_leader;
  private List<Patient> ultimate_responsibility;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConsultantDoctor()
  {
    super();
    ultimate_responsibility = new ArrayList<Patient>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Team getTeam_leader()
  {
    return team_leader;
  }

  public boolean hasTeam_leader()
  {
    boolean has = team_leader != null;
    return has;
  }
  /* Code from template association_GetMany */
  public Patient getUltimate_responsibility(int index)
  {
    Patient aUltimate_responsibility = ultimate_responsibility.get(index);
    return aUltimate_responsibility;
  }

  public List<Patient> getUltimate_responsibility()
  {
    List<Patient> newUltimate_responsibility = Collections.unmodifiableList(ultimate_responsibility);
    return newUltimate_responsibility;
  }

  public int numberOfUltimate_responsibility()
  {
    int number = ultimate_responsibility.size();
    return number;
  }

  public boolean hasUltimate_responsibility()
  {
    boolean has = ultimate_responsibility.size() > 0;
    return has;
  }

  public int indexOfUltimate_responsibility(Patient aUltimate_responsibility)
  {
    int index = ultimate_responsibility.indexOf(aUltimate_responsibility);
    return index;
  }
  /* Code from template association_SetOptionalOneToOne */
  public boolean setTeam_leader(Team aNewTeam_leader)
  {
    boolean wasSet = false;
    if (team_leader != null && !team_leader.equals(aNewTeam_leader) && equals(team_leader.getConsultantDoctor()))
    {
      //Unable to setTeam_leader, as existing team_leader would become an orphan
      return wasSet;
    }

    team_leader = aNewTeam_leader;
    ConsultantDoctor anOldConsultantDoctor = aNewTeam_leader != null ? aNewTeam_leader.getConsultantDoctor() : null;

    if (!this.equals(anOldConsultantDoctor))
    {
      if (anOldConsultantDoctor != null)
      {
        anOldConsultantDoctor.team_leader = null;
      }
      if (team_leader != null)
      {
        team_leader.setConsultantDoctor(this);
      }
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfUltimate_responsibility()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Patient addUltimate_responsibility(String aId, Patient.Gender aGender, Date aBirthDate, Date aAccepted, History aSickness, Team aTeam, Ward aWard)
  {
    return new Patient(aId, aGender, aBirthDate, aAccepted, aSickness, aTeam, this, aWard);
  }

  public boolean addUltimate_responsibility(Patient aUltimate_responsibility)
  {
    boolean wasAdded = false;
    if (ultimate_responsibility.contains(aUltimate_responsibility)) { return false; }
    ConsultantDoctor existingConsultantDoctor = aUltimate_responsibility.getConsultantDoctor();
    boolean isNewConsultantDoctor = existingConsultantDoctor != null && !this.equals(existingConsultantDoctor);
    if (isNewConsultantDoctor)
    {
      aUltimate_responsibility.setConsultantDoctor(this);
    }
    else
    {
      ultimate_responsibility.add(aUltimate_responsibility);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeUltimate_responsibility(Patient aUltimate_responsibility)
  {
    boolean wasRemoved = false;
    //Unable to remove aUltimate_responsibility, as it must always have a consultantDoctor
    if (!this.equals(aUltimate_responsibility.getConsultantDoctor()))
    {
      ultimate_responsibility.remove(aUltimate_responsibility);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addUltimate_responsibilityAt(Patient aUltimate_responsibility, int index)
  {  
    boolean wasAdded = false;
    if(addUltimate_responsibility(aUltimate_responsibility))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUltimate_responsibility()) { index = numberOfUltimate_responsibility() - 1; }
      ultimate_responsibility.remove(aUltimate_responsibility);
      ultimate_responsibility.add(index, aUltimate_responsibility);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveUltimate_responsibilityAt(Patient aUltimate_responsibility, int index)
  {
    boolean wasAdded = false;
    if(ultimate_responsibility.contains(aUltimate_responsibility))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfUltimate_responsibility()) { index = numberOfUltimate_responsibility() - 1; }
      ultimate_responsibility.remove(aUltimate_responsibility);
      ultimate_responsibility.add(index, aUltimate_responsibility);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addUltimate_responsibilityAt(aUltimate_responsibility, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Team existingTeam_leader = team_leader;
    team_leader = null;
    if (existingTeam_leader != null)
    {
      existingTeam_leader.delete();
    }
    for(int i=ultimate_responsibility.size(); i > 0; i--)
    {
      Patient aUltimate_responsibility = ultimate_responsibility.get(i - 1);
      aUltimate_responsibility.delete();
    }
    super.delete();
  }

}