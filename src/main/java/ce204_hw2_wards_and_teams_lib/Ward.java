/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_wards_and_teams_lib;
import java.util.*;
import java.sql.Date;

// line 35 "../../model.ump"
// line 127 "../../model.ump"
public class Ward
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Ward> wardsById = new HashMap<String, Ward>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ward Attributes
  private String id;
  private String patientsGender;
  private int capacity;

  //Ward Associations
  private HospitalWT hospitalWT;
  private List<PatientWT> patient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ward(String aId, String aPatientsGender, int aCapacity, HospitalWT aHospitalWT)
  {
    patientsGender = aPatientsGender;
    capacity = aCapacity;
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddHospitalWT = setHospitalWT(aHospitalWT);
    if (!didAddHospitalWT)
    {
      throw new RuntimeException("Unable to create ward due to hospitalWT. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    patient = new ArrayList<PatientWT>();
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
      wardsById.remove(anOldId);
    }
    wardsById.put(aId, this);
    return wasSet;
  }

  public boolean setPatientsGender(String aPatientsGender)
  {
    boolean wasSet = false;
    patientsGender = aPatientsGender;
    wasSet = true;
    return wasSet;
  }

  public boolean setCapacity(int aCapacity)
  {
    boolean wasSet = false;
    capacity = aCapacity;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }
  /* Code from template attribute_GetUnique */
  public static Ward getWithId(String aId)
  {
    return wardsById.get(aId);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithId(String aId)
  {
    return getWithId(aId) != null;
  }

  public String getPatientsGender()
  {
    return patientsGender;
  }

  public int getCapacity()
  {
    return capacity;
  }
  /* Code from template association_GetOne */
  public HospitalWT getHospitalWT()
  {
    return hospitalWT;
  }
  /* Code from template association_GetMany */
  public PatientWT getPatient(int index)
  {
    PatientWT aPatient = patient.get(index);
    return aPatient;
  }

  public List<PatientWT> getPatient()
  {
    List<PatientWT> newPatient = Collections.unmodifiableList(patient);
    return newPatient;
  }

  public int numberOfPatient()
  {
    int number = patient.size();
    return number;
  }

  public boolean hasPatient()
  {
    boolean has = patient.size() > 0;
    return has;
  }

  public int indexOfPatient(PatientWT aPatient)
  {
    int index = patient.indexOf(aPatient);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setHospitalWT(HospitalWT aHospitalWT)
  {
    boolean wasSet = false;
    if (aHospitalWT == null)
    {
      return wasSet;
    }

    HospitalWT existingHospitalWT = hospitalWT;
    hospitalWT = aHospitalWT;
    if (existingHospitalWT != null && !existingHospitalWT.equals(aHospitalWT))
    {
      existingHospitalWT.removeWard(this);
    }
    hospitalWT.addWard(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatient()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public PatientWT addPatient(String aId, String aGender, Date aBirthDate, Date aAccepted, String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs, Team aTeam, ConsultantDoctor aConsultantDoctor)
  {
    return new PatientWT(aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aAccepted, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, capacity, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aSpecialReqs, aTeam, null);
  }

  public boolean addPatient(PatientWT aPatient)
  {
    boolean wasAdded = false;
    if (patient.contains(aPatient)) { return false; }
    Ward existingWard = aPatient.getWard();
    boolean isNewWard = existingWard != null && !this.equals(existingWard);
    if (isNewWard)
    {
      aPatient.setWard(this);
    }
    else
    {
      patient.add(aPatient);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePatient(PatientWT aPatient)
  {
    boolean wasRemoved = false;
    //Unable to remove aPatient, as it must always have a ward
    if (!this.equals(aPatient.getWard()))
    {
      patient.remove(aPatient);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPatientAt(PatientWT aPatient, int index)
  {  
    boolean wasAdded = false;
    if(addPatient(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatient()) { index = numberOfPatient() - 1; }
      patient.remove(aPatient);
      patient.add(index, aPatient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePatientAt(PatientWT aPatient, int index)
  {
    boolean wasAdded = false;
    if(patient.contains(aPatient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatient()) { index = numberOfPatient() - 1; }
      patient.remove(aPatient);
      patient.add(index, aPatient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientAt(aPatient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    wardsById.remove(getId());
    HospitalWT placeholderHospitalWT = hospitalWT;
    this.hospitalWT = null;
    if(placeholderHospitalWT != null)
    {
      placeholderHospitalWT.removeWard(this);
    }
    for(int i=patient.size(); i > 0; i--)
    {
      PatientWT aPatient = patient.get(i - 1);
      aPatient.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "patientsGender" + ":" + getPatientsGender()+ "," +
            "capacity" + ":" + getCapacity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "hospitalWT = "+(getHospitalWT()!=null?Integer.toHexString(System.identityHashCode(getHospitalWT())):"null");
  }
}