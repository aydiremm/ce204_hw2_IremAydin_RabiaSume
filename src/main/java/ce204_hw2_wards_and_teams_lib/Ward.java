/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package ce204_hw2_wards_and_teams_lib;
import java.util.*;
import java.sql.Date;

// line 34 "../wards_and_teams.ump"
// line 112 "../wards_and_teams.ump"
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
  private Patient.Gender patientsGender;
  private int capacity;

  //Ward Associations
  private Hospital hospital;
  private List<Patient> patient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ward(String aId, Patient.Gender aPatientsGender, int aCapacity, Hospital aHospital)
  {
    patientsGender = aPatientsGender;
    capacity = aCapacity;
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    boolean didAddHospital = setHospital(aHospital);
    if (!didAddHospital)
    {
      throw new RuntimeException("Unable to create ward due to hospital. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    patient = new ArrayList<Patient>();
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

  public boolean setPatientsGender(Patient.Gender aPatientsGender)
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

  public Patient.Gender getPatientsGender()
  {
    return patientsGender;
  }

  public int getCapacity()
  {
    return capacity;
  }
  /* Code from template association_GetOne */
  public Hospital getHospital()
  {
    return hospital;
  }
  /* Code from template association_GetMany */
  public Patient getPatient(int index)
  {
    Patient aPatient = patient.get(index);
    return aPatient;
  }

  public List<Patient> getPatient()
  {
    List<Patient> newPatient = Collections.unmodifiableList(patient);
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

  public int indexOfPatient(Patient aPatient)
  {
    int index = patient.indexOf(aPatient);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setHospital(Hospital aHospital)
  {
    boolean wasSet = false;
    if (aHospital == null)
    {
      return wasSet;
    }

    Hospital existingHospital = hospital;
    hospital = aHospital;
    if (existingHospital != null && !existingHospital.equals(aHospital))
    {
      existingHospital.removeWard(this);
    }
    hospital.addWard(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatient()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Patient addPatient(String aId, Patient.Gender aGender, Date aBirthDate, Date aAccepted, History aSickness, Team aTeam, ConsultantDoctor aConsultantDoctor)
  {
    return new Patient(aId, aGender, aBirthDate, aAccepted, aSickness, aTeam, aConsultantDoctor, this);
  }

  public boolean addPatient(Patient aPatient)
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

  public boolean removePatient(Patient aPatient)
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
  public boolean addPatientAt(Patient aPatient, int index)
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

  public boolean addOrMovePatientAt(Patient aPatient, int index)
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
    Hospital placeholderHospital = hospital;
    this.hospital = null;
    if(placeholderHospital != null)
    {
      placeholderHospital.removeWard(this);
    }
    for(int i=patient.size(); i > 0; i--)
    {
      Patient aPatient = patient.get(i - 1);
      aPatient.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "capacity" + ":" + getCapacity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "patientsGender" + "=" + (getPatientsGender() != null ? !getPatientsGender().equals(this)  ? getPatientsGender().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "hospital = "+(getHospital()!=null?Integer.toHexString(System.identityHashCode(getHospital())):"null");
  }
}