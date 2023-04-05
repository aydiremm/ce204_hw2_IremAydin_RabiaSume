/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_wards_and_teams_lib;
import java.util.*;
import java.sql.Date;

// line 29 "../wards_and_teams.ump"
// line 107 "../wards_and_teams.ump"
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
  private Hospital hospital;
  private List<Patient> patients;
  private List<Doctor> doctors;
  private ConsultantDoctor consultantDoctor;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  /**

  Creates a new Team with the given name, hospital, and consultant doctor.
  @param aName the name of the team
  @param aHospitalWT the hospital the team belongs to
  @param aConsultantDoctor the consultant doctor of the team
  @throws RuntimeException if there is a violation of uniqueness or multiplicity constraints
  @see <a href="http://manual.umple.org?RE003ViolationofUniqueness.html">RE003ViolationofUniqueness</a>
  @see <a href="http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html">RE002ViolationofAssociationMultiplicity</a>
  */
  public Team(String aName, Hospital aHospital, ConsultantDoctor aConsultantDoctor)
  {
    if (!setName(aName))
    {
      throw new RuntimeException("Cannot create due to duplicate name. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddHospital = setHospital(aHospital);
    if (!didAddHospital)
    {
      throw new RuntimeException("Unable to create team due to hospital. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    patients = new ArrayList<Patient>();
    doctors = new ArrayList<Doctor>();
    boolean didAddConsultantDoctor = setConsultantDoctor(aConsultantDoctor);
    if (!didAddConsultantDoctor)
    {
      throw new RuntimeException("Unable to create team_leader due to consultantDoctor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /**

  Sets the name of the team.
  @param aName the name to set
  @return true if the name was set, false otherwise
  */
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
  /**

  Gets the name of the team.
  @return the name of the team
  */

  public String getName()
  {
    return name;
  }
  /* Code from template attribute_GetUnique */
  /**

  Gets the team with the specified name.
  @param aName the name of the team to get
  @return the team with the specified name, or null if no such team exists
  */
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
  public Hospital getHospital()
  {
    return hospital;
  }
  /* Code from template association_GetMany */
  /**

  @brief Get the Patient object at the specified index.
  @param index The index of the Patient to get.
  @return The Patient object at the specified index.
  */
  public Patient getPatient(int index)
  {
    Patient aPatient = patients.get(index);
    return aPatient;
  }
  /**

  @brief Get an unmodifiable list of all PatientWT objects associated with this Team.
  @return An unmodifiable list of all PatientWT objects associated with this Team.
  */
  public List<Patient> getPatients()
  {
    List<Patient> newPatients = Collections.unmodifiableList(patients);
    return newPatients;
  }
  /**

  @brief Get the number of Patient objects associated with this Team.
  @return The number of Patient objects associated with this Team.
  */
  public int numberOfPatients()
  {
    int number = patients.size();
    return number;
  }
  /**

  @brief Check if this Team has any associated PatientWT objects.
  @return True if this Team has at least one associated PatientWT object, false otherwise.
  */

  public boolean hasPatients()
  {
    boolean has = patients.size() > 0;
    return has;
  }
  /**

  @brief Get the index of the specified Patient object in the list of associated PatientWT objects.
  @param aPatientWT The Patient object to get the index of.
  @return The index of the specified Patient object, or -1 if it is not associated with this Team.
  */
  public int indexOfPatient(Patient aPatient)
  {
    int index = patients.indexOf(aPatient);
    return index;
  }
  /* Code from template association_GetMany */
  /**

  @brief Get the Doctor object at the specified index.
  @param index The index of the Doctor to get.
  @return The Doctor object at the specified index.
  */
  public Doctor getDoctor(int index)
  {
    Doctor aDoctor = doctors.get(index);
    return aDoctor;
  }
  /**

  @brief Get an unmodifiable list of all Doctor objects associated with this Team.
  @return An unmodifiable list of all Doctor objects associated with this Team.
  */
  public List<Doctor> getDoctors()
  {
    List<Doctor> newDoctors = Collections.unmodifiableList(doctors);
    return newDoctors;
  }
  /**

  @brief Get the number of Doctor objects associated with this Team.
  @return The number of Doctor objects associated with this Team.
  */
  public int numberOfDoctors()
  {
    int number = doctors.size();
    return number;
  }
  /**

  @brief Check if this Team has any associated DoctorWT objects.
  @return True if this Team has at least one associated DoctorWT object, false otherwise.
  */

  public boolean hasDoctors()
  {
    boolean has = doctors.size() > 0;
    return has;
  }
  /**

  @brief Get the index of the specified Doctor object in the list of associated DoctorWT objects.
  @param aDoctor The Doctor object to get the index of.
  @return The index of the specified Doctor object, or -1 if it is not associated with this Team.
  */

  public int indexOfDoctor(Doctor aDoctor)
  {
    int index = doctors.indexOf(aDoctor);
    return index;
  }
  /* Code from template association_GetOne */
  /**

  @brief Get the ConsultantDoctor object associated with this Team.
  @return The ConsultantDoctor object associated with this Team.
  */
  public ConsultantDoctor getConsultantDoctor()
  {
    return consultantDoctor;
  }
  /* Code from template association_SetOneToMandatoryMany */
  public boolean setHospital(Hospital aHospital)
  {
    boolean wasSet = false;
    //Must provide hospital to team
    if (aHospital == null)
    {
      return wasSet;
    }

    if (hospital != null && hospital.numberOfTeams() <= Hospital.minimumNumberOfTeams())
    {
      return wasSet;
    }

    Hospital existingHospital = hospital;
    hospital = aHospital;
    if (existingHospital != null && !existingHospital.equals(aHospital))
    {
      boolean didRemove = existingHospital.removeTeam(this);
      if (!didRemove)
      {
        hospital = existingHospital;
        return wasSet;
      }
    }
    hospital.addTeam(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  /**
   * Returns the minimum number of PatientWT objects that must be associated with this Team.
   * @return The minimum number of PatientWT objects that must be associated with this Team.
   */
  public static int minimumNumberOfPatients()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  /**
   * Adds a new Patient object to the patientWTs list of this Team.
   * @param aId The ID of the patient.
   * @param aGender The gender of the patient.
   * @param aBirthDate The birth date of the patient.
   * @param aAccepted The date the patient was accepted.
   * @param aSickness The sickness of the patient.
   * @param aPrescriptions The prescriptions of the patient.
   * @param aAllergies The allergies of the patient.
   * @param aSpecialReqs The special requirements of the patient.
   * @param aConsultantDoctor The consultant doctor of the patient.
   * @param aWard The ward of the patient.
   * @return The newly created PatientWT object.
   */
  public Patient addPatient(String aId, Patient.Gender aGender, Date aBirthDate, Date aAccepted, History aSickness, ConsultantDoctor aConsultantDoctor, Ward aWard)
  {
    return new Patient(aId, aGender, aBirthDate, aAccepted, aSickness, this, aConsultantDoctor, aWard);
  }

  /**
   * Adds the specified Patient object to the patientWTs list of this Team.
   * @param aPatientWT The Patient object to add.
   * @return True if the Patient object was added successfully, false otherwise.
   */
  public boolean addPatient(Patient aPatient)
  {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) { return false; }
    Team existingTeam = aPatient.getTeam();
    boolean isNewTeam = existingTeam != null && !this.equals(existingTeam);
    if (isNewTeam)
    {
      aPatient.setTeam(this);
    }
    else
    {
      patients.add(aPatient);
    }
    wasAdded = true;
    return wasAdded;
  }
  /**
   * Removes the specified Patient object from the patientWTs list of this Team.
   * @param aPatientWT The Patient object to remove.
   * @return True if the Patient object was removed successfully, false otherwise.
   */

  public boolean removePatient(Patient aPatient)
  {
    boolean wasRemoved = false;
    //Unable to remove aPatient, as it must always have a team
    if (!this.equals(aPatient.getTeam()))
    {
      patients.remove(aPatient);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  /**
   * Adds the specified Patient object to the patientWTs list of this Team at the specified index.
   * @param aPatient The Patient object to add.
   * @param index The index at which to add the Patient object.
   * @return True if the Patient object was added successfully, false otherwise.
   */
  public boolean addPatientAt(Patient aPatient, int index)
  {  
    boolean wasAdded = false;
    if(addPatient(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientAt(Patient aPatient, int index)
  {
    boolean wasAdded = false;
    if(patients.contains(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatients()) { index = numberOfPatients() - 1; }
      patients.remove(aPatient);
      patients.add(index, aPatient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientAt(aPatient, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctors()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addDoctor(Doctor aDoctor)
  {
    boolean wasAdded = false;
    if (doctors.contains(aDoctor)) { return false; }
    Team existingTeam = aDoctor.getTeam();
    if (existingTeam == null)
    {
      aDoctor.setTeam(this);
    }
    else if (!this.equals(existingTeam))
    {
      existingTeam.removeDoctor(aDoctor);
      addDoctor(aDoctor);
    }
    else
    {
      doctors.add(aDoctor);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDoctor(Doctor aDoctor)
  {
    boolean wasRemoved = false;
    if (doctors.contains(aDoctor))
    {
      doctors.remove(aDoctor);
      aDoctor.setTeam(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDoctorAt(Doctor aDoctor, int index)
  {  
    boolean wasAdded = false;
    if(addDoctor(aDoctor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctors()) { index = numberOfDoctors() - 1; }
      doctors.remove(aDoctor);
      doctors.add(index, aDoctor);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDoctorAt(Doctor aDoctor, int index)
  {
    boolean wasAdded = false;
    if(doctors.contains(aDoctor))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctors()) { index = numberOfDoctors() - 1; }
      doctors.remove(aDoctor);
      doctors.add(index, aDoctor);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDoctorAt(aDoctor, index);
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
    Hospital placeholderHospital = hospital;
    this.hospital = null;
    if(placeholderHospital != null)
    {
      placeholderHospital.removeTeam(this);
    }
    for(int i=patients.size(); i > 0; i--)
    {
      Patient aPatient = patients.get(i - 1);
      aPatient.delete();
    }
    while (doctors.size() > 0)
    {
      Doctor aDoctor = doctors.get(doctors.size() - 1);
      aDoctor.delete();
      doctors.remove(aDoctor);
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
            "  " + "hospital = "+(getHospital()!=null?Integer.toHexString(System.identityHashCode(getHospital())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "consultantDoctor = "+(getConsultantDoctor()!=null?Integer.toHexString(System.identityHashCode(getConsultantDoctor())):"null");
  }
}