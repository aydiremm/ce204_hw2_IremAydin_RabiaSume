/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_wards_and_teams_lib;
import java.util.*;
import java.sql.Date;

// line 30 "../../model.ump"
// line 122 "../../model.ump"
public class Team
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Team> teamsByName = new HashMap<String, Team>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Team Attributes
  private String name;

  //Team Associations
  private HospitalWT hospitalWT;
  private List<PatientWT> patientWTs;
  private List<DoctorWT> doctorWTs;
  private ConsultantDoctor consultantDoctor;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Team(String aName, HospitalWT aHospitalWT, ConsultantDoctor aConsultantDoctor)
  {
    if (!setName(aName))
    {
      throw new RuntimeException("Cannot create due to duplicate name. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddHospitalWT = setHospitalWT(aHospitalWT);
    if (!didAddHospitalWT)
    {
      throw new RuntimeException("Unable to create team due to hospitalWT. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    patientWTs = new ArrayList<PatientWT>();
    doctorWTs = new ArrayList<DoctorWT>();
    boolean didAddConsultantDoctor = setConsultantDoctor(aConsultantDoctor);
    if (!didAddConsultantDoctor)
    {
      throw new RuntimeException("Unable to create team_leader due to consultantDoctor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

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
      teamsByName.remove(anOldName);
    }
    teamsByName.put(aName, this);
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template attribute_GetUnique */
  public static Team getWithName(String aName)
  {
    return teamsByName.get(aName);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithName(String aName)
  {
    return getWithName(aName) != null;
  }
  /* Code from template association_GetOne */
  public HospitalWT getHospitalWT()
  {
    return hospitalWT;
  }
  /* Code from template association_GetMany */
  public PatientWT getPatientWT(int index)
  {
    PatientWT aPatientWT = patientWTs.get(index);
    return aPatientWT;
  }

  public List<PatientWT> getPatientWTs()
  {
    List<PatientWT> newPatientWTs = Collections.unmodifiableList(patientWTs);
    return newPatientWTs;
  }

  public int numberOfPatientWTs()
  {
    int number = patientWTs.size();
    return number;
  }

  public boolean hasPatientWTs()
  {
    boolean has = patientWTs.size() > 0;
    return has;
  }

  public int indexOfPatientWT(PatientWT aPatientWT)
  {
    int index = patientWTs.indexOf(aPatientWT);
    return index;
  }
  /* Code from template association_GetMany */
  public DoctorWT getDoctorWT(int index)
  {
    DoctorWT aDoctorWT = doctorWTs.get(index);
    return aDoctorWT;
  }

  public List<DoctorWT> getDoctorWTs()
  {
    List<DoctorWT> newDoctorWTs = Collections.unmodifiableList(doctorWTs);
    return newDoctorWTs;
  }

  public int numberOfDoctorWTs()
  {
    int number = doctorWTs.size();
    return number;
  }

  public boolean hasDoctorWTs()
  {
    boolean has = doctorWTs.size() > 0;
    return has;
  }

  public int indexOfDoctorWT(DoctorWT aDoctorWT)
  {
    int index = doctorWTs.indexOf(aDoctorWT);
    return index;
  }
  /* Code from template association_GetOne */
  public ConsultantDoctor getConsultantDoctor()
  {
    return consultantDoctor;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setHospitalWT(HospitalWT aHospitalWT)
  {
    boolean wasSet = false;
    //Must provide hospitalWT to team
    if (aHospitalWT == null)
    {
      return wasSet;
    }

    if (hospitalWT != null && hospitalWT.numberOfTeams() <= HospitalWT.minimumNumberOfTeams())
    {
      return wasSet;
    }

    HospitalWT existingHospitalWT = hospitalWT;
    hospitalWT = aHospitalWT;
    if (existingHospitalWT != null && !existingHospitalWT.equals(aHospitalWT))
    {
      boolean didRemove = existingHospitalWT.removeTeam(this);
      if (!didRemove)
      {
        hospitalWT = existingHospitalWT;
        return wasSet;
      }
    }
    hospitalWT.addTeam(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatientWTs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PatientWT addPatientWT(String aId, String aGender, Date aBirthDate, Date aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs, ConsultantDoctor aConsultantDoctor, Ward aWard)
  {
    return new PatientWT(aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aAccepted, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, 0, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, null, aWard);
  }

  public boolean addPatientWT(PatientWT aPatientWT)
  {
    boolean wasAdded = false;
    if (patientWTs.contains(aPatientWT)) { return false; }
    Team existingTeam = aPatientWT.getTeam();
    boolean isNewTeam = existingTeam != null && !this.equals(existingTeam);
    if (isNewTeam)
    {
      aPatientWT.setTeam(this);
    }
    else
    {
      patientWTs.add(aPatientWT);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePatientWT(PatientWT aPatientWT)
  {
    boolean wasRemoved = false;
    //Unable to remove aPatientWT, as it must always have a team
    if (!this.equals(aPatientWT.getTeam()))
    {
      patientWTs.remove(aPatientWT);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPatientWTAt(PatientWT aPatientWT, int index)
  {  
    boolean wasAdded = false;
    if(addPatientWT(aPatientWT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatientWTs()) { index = numberOfPatientWTs() - 1; }
      patientWTs.remove(aPatientWT);
      patientWTs.add(index, aPatientWT);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientWTAt(PatientWT aPatientWT, int index)
  {
    boolean wasAdded = false;
    if(patientWTs.contains(aPatientWT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatientWTs()) { index = numberOfPatientWTs() - 1; }
      patientWTs.remove(aPatientWT);
      patientWTs.add(index, aPatientWT);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientWTAt(aPatientWT, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctorWTs()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addDoctorWT(DoctorWT aDoctorWT)
  {
    boolean wasAdded = false;
    if (doctorWTs.contains(aDoctorWT)) { return false; }
    Team existingTeam = aDoctorWT.getTeam();
    if (existingTeam == null)
    {
      aDoctorWT.setTeam(this);
    }
    else if (!this.equals(existingTeam))
    {
      existingTeam.removeDoctorWT(aDoctorWT);
      addDoctorWT(aDoctorWT);
    }
    else
    {
      doctorWTs.add(aDoctorWT);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDoctorWT(DoctorWT aDoctorWT)
  {
    boolean wasRemoved = false;
    if (doctorWTs.contains(aDoctorWT))
    {
      doctorWTs.remove(aDoctorWT);
      aDoctorWT.setTeam(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDoctorWTAt(DoctorWT aDoctorWT, int index)
  {  
    boolean wasAdded = false;
    if(addDoctorWT(aDoctorWT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorWTs()) { index = numberOfDoctorWTs() - 1; }
      doctorWTs.remove(aDoctorWT);
      doctorWTs.add(index, aDoctorWT);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDoctorWTAt(DoctorWT aDoctorWT, int index)
  {
    boolean wasAdded = false;
    if(doctorWTs.contains(aDoctorWT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorWTs()) { index = numberOfDoctorWTs() - 1; }
      doctorWTs.remove(aDoctorWT);
      doctorWTs.add(index, aDoctorWT);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDoctorWTAt(aDoctorWT, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToOptionalOne */
  public boolean setConsultantDoctor(ConsultantDoctor aNewConsultantDoctor)
  {
    boolean wasSet = false;
    if (aNewConsultantDoctor == null)
    {
      //Unable to setConsultantDoctor to null, as team_leader must always be associated to a consultantDoctor
      return wasSet;
    }
    
    Team existingTeam_leader = aNewConsultantDoctor.getTeam_leader();
    if (existingTeam_leader != null && !equals(existingTeam_leader))
    {
      //Unable to setConsultantDoctor, the current consultantDoctor already has a team_leader, which would be orphaned if it were re-assigned
      return wasSet;
    }
    
    ConsultantDoctor anOldConsultantDoctor = consultantDoctor;
    consultantDoctor = aNewConsultantDoctor;
    consultantDoctor.setTeam_leader(this);

    if (anOldConsultantDoctor != null)
    {
      anOldConsultantDoctor.setTeam_leader(null);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    teamsByName.remove(getName());
    HospitalWT placeholderHospitalWT = hospitalWT;
    this.hospitalWT = null;
    if(placeholderHospitalWT != null)
    {
      placeholderHospitalWT.removeTeam(this);
    }
    for(int i=patientWTs.size(); i > 0; i--)
    {
      PatientWT aPatientWT = patientWTs.get(i - 1);
      aPatientWT.delete();
    }
    while (doctorWTs.size() > 0)
    {
      DoctorWT aDoctorWT = doctorWTs.get(doctorWTs.size() - 1);
      aDoctorWT.delete();
      doctorWTs.remove(aDoctorWT);
    }
    
    ConsultantDoctor existingConsultantDoctor = consultantDoctor;
    consultantDoctor = null;
    if (existingConsultantDoctor != null)
    {
      existingConsultantDoctor.setTeam_leader(null);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hospitalWT = "+(getHospitalWT()!=null?Integer.toHexString(System.identityHashCode(getHospitalWT())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "consultantDoctor = "+(getConsultantDoctor()!=null?Integer.toHexString(System.identityHashCode(getConsultantDoctor())):"null");
  }
}