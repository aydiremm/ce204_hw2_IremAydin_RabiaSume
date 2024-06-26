/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_wards_and_teams_lib;
import java.util.*;
import java.sql.Date;

// line 42 "../wards_and_teams.ump"
// line 117 "../wards_and_teams.ump"
public class Patient
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Gender { Male, Female }

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Patient> patientsById = new HashMap<String, Patient>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Patient Attributes
  private String id;
  private Gender gender;
  private Date birthDate;
  private Date accepted;
  private History sickness;
  private List<String> prescriptions;
  private List<String> allergies;
  private List<String> specialReqs;

  //Patient Associations
  private Team team;
  private List<Doctor> doctors;
  private ConsultantDoctor consultantDoctor;
  private Ward ward;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Patient(String aId, Gender aGender, Date aBirthDate, Date aAccepted, History aSickness, Team aTeam, ConsultantDoctor aConsultantDoctor, Ward aWard)
  {
    gender = aGender;
    birthDate = aBirthDate;
    accepted = aAccepted;
    sickness = aSickness;
    prescriptions = new ArrayList<String>();
    allergies = new ArrayList<String>();
    specialReqs = new ArrayList<String>();
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddTeam = setTeam(aTeam);
    if (!didAddTeam)
    {
      throw new RuntimeException("Unable to create patient due to team. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    doctors = new ArrayList<Doctor>();
    boolean didAddConsultantDoctor = setConsultantDoctor(aConsultantDoctor);
    if (!didAddConsultantDoctor)
    {
      throw new RuntimeException("Unable to create ultimate_responsibility due to consultantDoctor. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    boolean didAddWard = setWard(aWard);
    if (!didAddWard)
    {
      throw new RuntimeException("Unable to create patient due to ward. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    String anOldId = getId();
    if (anOldId != null && anOldId.equals(aId)) {
      return true;
    }
    if (hasWithId(aId)) {
      return wasSet;
    }
    id = aId;
    wasSet = true;
    if (anOldId != null) {
      patientsById.remove(anOldId);
    }
    patientsById.put(aId, this);
    return wasSet;
  }

  public boolean setGender(Gender aGender)
  {
    boolean wasSet = false;
    gender = aGender;
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
  /**

  Sets the accepted insurance of the patient.
  @param aAccepted the accepted insurance
  @return true if the accepted insurance is set successfully, false otherwise
  */
  public boolean setAccepted(Date aAccepted)
  {
    boolean wasSet = false;
    accepted = aAccepted;
    wasSet = true;
    return wasSet;
  }
  /**

  Sets the sickness of the patient.
  @param aSickness the sickness
  @return true if the sickness is set successfully, false otherwise
  */
  public boolean setSickness(History aSickness)
  {
    boolean wasSet = false;
    sickness = aSickness;
    wasSet = true;
    return wasSet;
  }
  /* Code from template attribute_SetMany */
  /**

  Add the prescriptions of the patient.
  @param aPrescriptions the prescriptions
  @return true if the prescriptions are set successfully, false otherwise
  */
  public boolean addPrescription(String aPrescription)
  {
    boolean wasAdded = false;
    wasAdded = prescriptions.add(aPrescription);
    return wasAdded;
  }

  public boolean removePrescription(String aPrescription)
  {
    boolean wasRemoved = false;
    wasRemoved = prescriptions.remove(aPrescription);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  /**

  Add the allergies of the patient.
  @param aAllergies the allergies
  @return true if the allergies are set successfully, false otherwise
  */
  public boolean addAllergy(String aAllergy)
  {
    boolean wasAdded = false;
    wasAdded = allergies.add(aAllergy);
    return wasAdded;
  }

  public boolean removeAllergy(String aAllergy)
  {
    boolean wasRemoved = false;
    wasRemoved = allergies.remove(aAllergy);
    return wasRemoved;
  }
  /* Code from template attribute_SetMany */
  /**

  Add the special requirements of the patient.
  @param aSpecialReqs the special requirements
  @return true if the special requirements are set successfully, false otherwise
  */
  public boolean addSpecialReq(String aSpecialReq)
  {
    boolean wasAdded = false;
    wasAdded = specialReqs.add(aSpecialReq);
    return wasAdded;
  }

  public boolean removeSpecialReq(String aSpecialReq)
  {
    boolean wasRemoved = false;
    wasRemoved = specialReqs.remove(aSpecialReq);
    return wasRemoved;
  }
  /**

  Returns the ID of the patient.
  @return the ID of the patient
  */
  public String getId()
  {
    return id;
  }
  /* Code from template attribute_GetUnique */
  /**

  Returns the Patient with the given ID.
  @param aId the ID of the patient
  @return the Patient with the given ID
  */
  public static Patient getWithId(String aId)
  {
    return patientsById.get(aId);
  }
  /* Code from template attribute_HasUnique */
  /**

  Returns true if there is a PatientWT with the given ID, false otherwise.
  @param aId the ID of the patient
  @return true if there is a PatientWT with the given ID, false otherwise
  */
  public static boolean hasWithId(String aId)
  {
    return getWithId(aId) != null;
  }
  /**

  Returns the gender of the patient.
  @return the gender of the patient
  */

  public Gender getGender()
  {
    return gender;
  }
  /**

  Returns the birth date of the patient.
  @return the birth date of the patient
  */
  public Date getBirthDate()
  {
    return birthDate;
  }

  public int getAge()
  {
    return new Date(System.currentTimeMillis()).getYear() - birthDate.getYear();
  }
  /**
   * Returns the acceptance status of the patient.
   * @return the acceptance status of the patient.
   */
  public Date getAccepted()
  {
    return accepted;
  }
  /**
   * Returns the current sickness of the patient.
   * @return the current sickness of the patient.
   */

  public History getSickness()
  {
    return sickness;
  }
  /* Code from template attribute_GetMany */
  /**
   * Returns the current prescriptions of the patient.
   * @return the current prescriptions of the patient.
   */
  public String getPrescription(int index)
  {
    String aPrescription = prescriptions.get(index);
    return aPrescription;
  }

  public String[] getPrescriptions()
  {
    String[] newPrescriptions = prescriptions.toArray(new String[prescriptions.size()]);
    return newPrescriptions;
  }

  public int numberOfPrescriptions()
  {
    int number = prescriptions.size();
    return number;
  }

  public boolean hasPrescriptions()
  {
    boolean has = prescriptions.size() > 0;
    return has;
  }

  public int indexOfPrescription(String aPrescription)
  {
    int index = prescriptions.indexOf(aPrescription);
    return index;
  }
  /* Code from template attribute_GetMany */
  
  public String getAllergy(int index)
  {
    String aAllergy = allergies.get(index);
    return aAllergy;
  }
  /**
   * Returns the allergies of the patient.
   * @return the allergies of the patient.
   */
  public String[] getAllergies()
  {
    String[] newAllergies = allergies.toArray(new String[allergies.size()]);
    return newAllergies;
  }

  public int numberOfAllergies()
  {
    int number = allergies.size();
    return number;
  }

  public boolean hasAllergies()
  {
    boolean has = allergies.size() > 0;
    return has;
  }

  public int indexOfAllergy(String aAllergy)
  {
    int index = allergies.indexOf(aAllergy);
    return index;
  }
  /* Code from template attribute_GetMany */
 
  public String getSpecialReq(int index)
  {
    String aSpecialReq = specialReqs.get(index);
    return aSpecialReq;
  }
  /**
   * Returns the allergies of the patient.
   * @return the allergies of the patient.
   */

  public String[] getSpecialReqs()
  {
    String[] newSpecialReqs = specialReqs.toArray(new String[specialReqs.size()]);
    return newSpecialReqs;
  }

  public int numberOfSpecialReqs()
  {
    int number = specialReqs.size();
    return number;
  }

  public boolean hasSpecialReqs()
  {
    boolean has = specialReqs.size() > 0;
    return has;
  }

  public int indexOfSpecialReq(String aSpecialReq)
  {
    int index = specialReqs.indexOf(aSpecialReq);
    return index;
  }
  /* Code from template association_GetOne */
  /**
   * Returns the team that the patient is assigned to.
   * @return the team that the patient is assigned to.
   * @see Team
   */
  public Team getTeam()
  {
    return team;
  }
  /* Code from template association_GetMany */
  /**
   * Returns the Doctor object at the specified index.
   * @param index the index of the Doctor object to return.
   * @return the Doctor object at the specified index.
   * @see DoctorWT
   */
  public Doctor getDoctor(int index)
  {
    Doctor aDoctor = doctors.get(index);
    return aDoctor;
  }
  /**
   * Returns an unmodifiable list of DoctorWT objects associated with the patient.
   * @return an unmodifiable list of DoctorWT objects associated with the patient.
   * @see Doctor
   */
  public List<Doctor> getDoctors()
  {
    List<Doctor> newDoctors = Collections.unmodifiableList(doctors);
    return newDoctors;
  }
  /**
   * Returns the number of Doctor objects associated with the patient.
   * @return the number of Doctor objects associated with the patient.
   */
  public int numberOfDoctors()
  {
    int number = doctors.size();
    return number;
  }
  /**
   * Returns true if the patient has at least one Doctor object associated with them, false otherwise.
   * @return true if the patient has at least one Doctor object associated with them, false otherwise.
   */
  public boolean hasDoctors()
  {
    boolean has = doctors.size() > 0;
    return has;
  }
  /**
   * Returns the index of the specified DoctorWT object in the list of DoctorWT objects associated with the patient.
   * @param aDoctor the Doctor object to search for.
   * @return the index of the specified DoctorWT object in the list of DoctorWT objects associated with the patient, or -1 if the object is not found.
   */
  public int indexOfDoctor(Doctor aDoctor)
  {
    int index = doctors.indexOf(aDoctor);
    return index;
  }
  /* Code from template association_GetOne */
  /**
   * Returns the consultant doctor assigned to the patient.
   * @return the consultant doctor assigned to the patient.
   * @see ConsultantDoctor
   */
  public ConsultantDoctor getConsultantDoctor()
  {
    return consultantDoctor;
  }
  /* Code from template association_GetOne */
  public Ward getWard()
  {
    return ward;
  }
  /* Code from template association_SetOneToMany */
  public boolean setTeam(Team aTeam)
  {
    boolean wasSet = false;
    if (aTeam == null)
    {
      return wasSet;
    }

    Team existingTeam = team;
    team = aTeam;
    if (existingTeam != null && !existingTeam.equals(aTeam))
    {
      existingTeam.removePatient(this);
    }
    team.addPatient(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctors()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDoctor(Doctor aDoctor)
  {
    boolean wasAdded = false;
    if (doctors.contains(aDoctor)) { return false; }
    doctors.add(aDoctor);
    if (aDoctor.indexOfTreat(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDoctor.addTreat(this);
      if (!wasAdded)
      {
        doctors.remove(aDoctor);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDoctor(Doctor aDoctor)
  {
    boolean wasRemoved = false;
    if (!doctors.contains(aDoctor))
    {
      return wasRemoved;
    }

    int oldIndex = doctors.indexOf(aDoctor);
    doctors.remove(oldIndex);
    if (aDoctor.indexOfTreat(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDoctor.removeTreat(this);
      if (!wasRemoved)
      {
        doctors.add(oldIndex,aDoctor);
      }
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
  /* Code from template association_SetOneToMany */
  public boolean setConsultantDoctor(ConsultantDoctor aConsultantDoctor)
  {
    boolean wasSet = false;
    if (aConsultantDoctor == null)
    {
      return wasSet;
    }

    ConsultantDoctor existingConsultantDoctor = consultantDoctor;
    consultantDoctor = aConsultantDoctor;
    if (existingConsultantDoctor != null && !existingConsultantDoctor.equals(aConsultantDoctor))
    {
      existingConsultantDoctor.removeUltimate_responsibility(this);
    }
    consultantDoctor.addUltimate_responsibility(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setWard(Ward aWard)
  {
    boolean wasSet = false;
    if (aWard == null)
    {
      return wasSet;
    }

    Ward existingWard = ward;
    ward = aWard;
    if (existingWard != null && !existingWard.equals(aWard))
    {
      existingWard.removePatient(this);
    }
    ward.addPatient(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    patientsById.remove(getId());
    Team placeholderTeam = team;
    this.team = null;
    if(placeholderTeam != null)
    {
      placeholderTeam.removePatient(this);
    }
    ArrayList<Doctor> copyOfDoctors = new ArrayList<Doctor>(doctors);
    doctors.clear();
    for(Doctor aDoctor : copyOfDoctors)
    {
      aDoctor.removeTreat(this);
    }
    ConsultantDoctor placeholderConsultantDoctor = consultantDoctor;
    this.consultantDoctor = null;
    if(placeholderConsultantDoctor != null)
    {
      placeholderConsultantDoctor.removeUltimate_responsibility(this);
    }
    Ward placeholderWard = ward;
    this.ward = null;
    if(placeholderWard != null)
    {
      placeholderWard.removePatient(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "age" + ":" + getAge()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "gender" + "=" + (getGender() != null ? !getGender().equals(this)  ? getGender().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "birthDate" + "=" + (getBirthDate() != null ? !getBirthDate().equals(this)  ? getBirthDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "accepted" + "=" + (getAccepted() != null ? !getAccepted().equals(this)  ? getAccepted().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "sickness" + "=" + (getSickness() != null ? !getSickness().equals(this)  ? getSickness().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "team = "+(getTeam()!=null?Integer.toHexString(System.identityHashCode(getTeam())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "consultantDoctor = "+(getConsultantDoctor()!=null?Integer.toHexString(System.identityHashCode(getConsultantDoctor())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "ward = "+(getWard()!=null?Integer.toHexString(System.identityHashCode(getWard())):"null");
  }
}