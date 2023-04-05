//PLEASE DO NOT EDIT THIS CODE/

//This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!/
/**

This class represents a Consultant Doctor, which is a subtype of DoctorWT.
It has a team_leader association with a Team object and a one-to-many ultimate_responsibility association with PatientWT objects.
The ConsultantDoctor can be assigned as the leader of a Team and has ultimate responsibility over a list of patients.
*/
package ce204_hw2_wards_and_teams_lib;
import java.util.*;

import ce204_hw2_organization_lib.Address;
import ce204_hw2_organization_lib.Department;
import ce204_hw2_organization_lib.Phone;

import java.sql.Date;

// line 79 "../../model.ump"
// line 142 "../../model.ump"
public class ConsultantDoctor extends DoctorWT
{

  
	/**

	Constructor for ConsultantDoctor class.
	@param aTitle title of the ConsultantDoctor
	@param aGivenName given name of the ConsultantDoctor
	@param aMiddleName middle name of the ConsultantDoctor
	@param aFamilyName family name of the ConsultantDoctor
	@param aBirthDate birth date of the ConsultantDoctor
	@param aGender gender of the ConsultantDoctor
	@param aHomeAddress home address of the ConsultantDoctor
	@param aPhone phone number of the ConsultantDoctor
	@param aJoined joined date of the ConsultantDoctor
	@param aEducation education of the ConsultantDoctor
	@param aCertification certification of the ConsultantDoctor
	@param aLanguages languages spoken by the ConsultantDoctor
	@param aDepartment department of the ConsultantDoctor
	@param aSpecialty specialty of the ConsultantDoctor
	@param aLocations locations the ConsultantDoctor is available at
	*/
public ConsultantDoctor(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification,
			String aLanguages, Department aDepartment, String aSpecialty, String aLocations) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined, aEducation,
				aCertification, aLanguages, aDepartment, aSpecialty, aLocations);
		// TODO Auto-generated constructor stub
	}

//------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConsultantDoctor Associations
  private Team team_leader;
  private List<PatientWT> ultimate_responsibility;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  /**

  Returns the Team object that the ConsultantDoctor is leading.
  @return the team_leader of the ConsultantDoctor
  */
  public Team getTeam_leader()
  {
    return team_leader;
  }
  /**

  Returns true if the ConsultantDoctor is leading a team, false otherwise.
  @return true if the ConsultantDoctor is leading a team, false otherwise
  */
  public boolean hasTeam_leader()
  {
    boolean has = team_leader != null;
    return has;
  }
  /* Code from template association_GetMany */
  /**

  Returns the PatientWT object at the specified index in the ConsultantDoctor's ultimate_responsibility list.
  @param index the index of the PatientWT object to be returned
  @return the PatientWT object at the specified index
  */
  public PatientWT getUltimate_responsibility(int index)
  {
    PatientWT aUltimate_responsibility = ultimate_responsibility.get(index);
    return aUltimate_responsibility;
  }
  /**

  Returns an unmodifiable list of PatientWT objects that the ConsultantDoctor has ultimate responsibility over.
  @return an unmodifiable list of PatientWT objects
  */
  public List<PatientWT> getUltimate_responsibility()
  {
    List<PatientWT> newUltimate_responsibility = Collections.unmodifiableList(ultimate_responsibility);
    return newUltimate_responsibility;
  }

  public int numberOfUltimate_responsibility()
  {
    int number = ultimate_responsibility.size();
    return number;
  }
  /**

  Check if the consultant doctor has any patients for whom they have ultimate responsibility.
  @return True if the consultant doctor has at least one patient for whom they have ultimate responsibility, false otherwise.
  */
  public boolean hasUltimate_responsibility()
  {
    boolean has = ultimate_responsibility.size() > 0;
    return has;
  }
  /**

  Get the index of a patient for whom the consultant doctor has ultimate responsibility in the list of patients.
  @param aUltimate_responsibility The patient for whom to get the index.
  @return The index of the patient for whom the consultant doctor has ultimate responsibility, or -1 if the patient is not found.
  */
  public int indexOfUltimate_responsibility(PatientWT aUltimate_responsibility)
  {
    int index = ultimate_responsibility.indexOf(aUltimate_responsibility);
    return index;
  }
  /* Code from template association_SetOptionalOneToOne */
  /**

  Set the team leader of the consultant doctor.
  @param aNewTeam_leader The new team leader for the consultant doctor.
  @return True if the team leader was successfully set, false otherwise.
  */
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
  /**

  Get the minimum number of patients for whom the consultant doctor has ultimate responsibility.
  @return The minimum number of patients for whom the consultant doctor has ultimate responsibility.
  */
  public static int minimumNumberOfUltimate_responsibility()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */


  public boolean addUltimate_responsibility(PatientWT aUltimate_responsibility)
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

  public boolean removeUltimate_responsibility(PatientWT aUltimate_responsibility)
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
  public boolean addUltimate_responsibilityAt(PatientWT aUltimate_responsibility, int index)
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

  public boolean addOrMoveUltimate_responsibilityAt(PatientWT aUltimate_responsibility, int index)
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
      PatientWT aUltimate_responsibility = ultimate_responsibility.get(i - 1);
      aUltimate_responsibility.delete();
    }
    super.delete();
  }
  public static ConsultantDoctor get(int i) {
	    // TODO Auto-generated method stub
	    return null;
	}

}