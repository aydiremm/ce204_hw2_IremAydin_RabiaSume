/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;
import java.util.*;
import java.sql.Date;

// line 45 "../organization.ump"
// line 157 "../organization.ump"
public class Patient extends Person
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Patient> patientsById = new HashMap<String, Patient>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Patient Attributes
  private String id;
  private Date accepted;
  private History sickness;
  private List<String> prescriptions;
  private List<String> allergies;
  private List<String> specialReqs;

  //Patient Associations
  private List<OperationsStaff> operationsStaffs;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  /**
	 * Constructs a new Patient object with the specified details.
	 *
	 * @param aTitle         The patient's title.
	 * @param aGivenName     The patient's given name.
	 * @param aMiddleName    The patient's middle name.
	 * @param aFamilyName    The patient's family name.
	 * @param aBirthDate     The patient's date of birth.
	 * @param aGender        The patient's gender.
	 * @param aHomeAddress   The patient's home address.
	 * @param aPhone         The patient's phone number.
	 * @param aId            The patient's ID.
	 * @param aAge           The patient's age.
	 * @param aAccepted      The patient's accepted status.
	 * @param aSickness      The patient's sickness.
	 * @param aPrescriptions The patient's prescriptions.
	 * @param aAllergies     The patient's allergies.
	 * @param aSpecialReqs   The patient's special requirements.
	 */

  public Patient(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate, Gender aGender, Address aHomeAddress, Phone aPhone, String aId, Date aAccepted, History aSickness)
  {
    super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone);
    accepted = aAccepted;
    sickness = aSickness;
    prescriptions = new ArrayList<String>();
    allergies = new ArrayList<String>();
    specialReqs = new ArrayList<String>();
    if (!setId(aId))
    {
      throw new RuntimeException("Cannot create due to duplicate id. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    operationsStaffs = new ArrayList<OperationsStaff>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /**
	 * 
	 * Sets the ID of the patient.
	 * 
	 * @param aId the new ID of the patient
	 * @return true if the ID was successfully set
	 */

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
  /**
	 * 
	 * Sets the acceptance status of the patient.
	 * 
	 * @param aAccepted the new acceptance status of the patient
	 * @return true if the acceptance status was successfully set
	 */
  public boolean setAccepted(Date aAccepted)
  {
    boolean wasSet = false;
    accepted = aAccepted;
    wasSet = true;
    return wasSet;
  }
  /**
	 * 
	 * Sets the sickness of the patient.
	 * 
	 * @param aSickness the new sickness of the patient
	 * @return true if the sickness was successfully set
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
	 * 
	 * Sets the prescriptions of the patient.
	 * 
	 * @param aPrescriptions the new prescriptions of the patient
	 * @return true if the prescriptions were successfully set
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
	 * 
	 * Adds allergies to the patient.
	 * 
	 * @param aAllergy the new allergy of the patient
	 * @return true if the allergies were successfully set
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

	/**
	 * 
	 * Adds special requirement to the patient.
	 * 
	 * @param aSpecialReqs the new special requirements of the patient
	 * @return true if the special requirements were successfully set
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
	 * 
	 * Gets the ID of the patient.
	 * 
	 * @return the ID of the patient
	 */
  public String getId()
  {
    return id;
  }
  /* Code from template attribute_GetUnique */
  public static Patient getWithId(String aId)
  {
    return patientsById.get(aId);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithId(String aId)
  {
    return getWithId(aId) != null;
  }
  /**
	 * 
	 * Gets the age of the patient.
	 * 
	 * @return the age of the patient
	 */
  public int getAge()
  {
    return new Date(System.currentTimeMillis()).getYear() - getBirthDate().getYear();
  }
  /**
	 * 
	 * Gets the acceptance status of the patient.
	 * 
	 * @return the acceptance status of the patient
	 */
  public Date getAccepted()
  {
    return accepted;
  }
  /**
	 * 
	 * Gets the sickness of the patient.
	 * 
	 * @return the sickness of the patient
	 */
  public History getSickness()
  {
    return sickness;
  }
  /* Code from template attribute_GetMany */
  /**
	 * 
	 * Gets the prescriptions of the patient.
	 * 
	 * @return the prescriptions of the patient
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
	 * 
	 * Gets the allergies of the patient.
	 * 
	 * @return the allergies of the patient
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
  /**
	 * 
	 * Gets the special requirements of the patient.
	 * 
	 * @return the special requirements of the patient
	 */
  public String getSpecialReq(int index)
  {
    String aSpecialReq = specialReqs.get(index);
    return aSpecialReq;
  }

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
  /* Code from template association_GetMany */
  /**
	 * 
	 * Returns the OperationsStaff object at the specified index in the list of
	 * OperationsStaffs.
	 * 
	 * @param index The index of the desired OperationsStaff object.
	 * @return The OperationsStaff object at the specified index.
	 */
  public OperationsStaff getOperationsStaff(int index)
  {
    OperationsStaff aOperationsStaff = operationsStaffs.get(index);
    return aOperationsStaff;
  }
  /**
	 * 
	 * Returns an unmodifiable list of all the OperationsStaffs associated with this
	 * Patient.
	 * 
	 * @return An unmodifiable list of OperationsStaffs.
	 */

  public List<OperationsStaff> getOperationsStaffs()
  {
    List<OperationsStaff> newOperationsStaffs = Collections.unmodifiableList(operationsStaffs);
    return newOperationsStaffs;
  }

  public int numberOfOperationsStaffs()
  {
    int number = operationsStaffs.size();
    return number;
  }
  /**
	 * 
	 * Returns true if this Patient has one or more OperationsStaffs associated with
	 * it.
	 * 
	 * @return True if this Patient has one or more OperationsStaffs.
	 */
  public boolean hasOperationsStaffs()
  {
    boolean has = operationsStaffs.size() > 0;
    return has;
  }
  /**
	 * 
	 * Returns the index of the specified OperationsStaff object in the list of
	 * OperationsStaffs, or -1 if it is not found.
	 * 
	 * @param aOperationsStaff The OperationsStaff object to find the index of.
	 * @return The index of the OperationsStaff object, or -1 if it is not found.
	 */
  public int indexOfOperationsStaff(OperationsStaff aOperationsStaff)
  {
    int index = operationsStaffs.indexOf(aOperationsStaff);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  /**
	 * 
	 * Returns the minimum number of OperationsStaffs that a Patient can have (which
	 * is zero).
	 * 
	 * @return The minimum number of OperationsStaffs.
	 */
  public static int minimumNumberOfOperationsStaffs()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  /**
	 * 
	 * Adds an OperationsStaff to this Patient's list of operations staffs.
	 * 
	 * @param aOperationsStaff the OperationsStaff to add
	 * @return true if the OperationsStaff was added, false otherwise
	 */
  public boolean addOperationsStaff(OperationsStaff aOperationsStaff)
  {
    boolean wasAdded = false;
    if (operationsStaffs.contains(aOperationsStaff)) { return false; }
    operationsStaffs.add(aOperationsStaff);
    if (aOperationsStaff.indexOfPatient(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aOperationsStaff.addPatient(this);
      if (!wasAdded)
      {
        operationsStaffs.remove(aOperationsStaff);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  /**
	 * 
	 * Removes an OperationsStaff from this Patient's list of operations staffs.
	 * 
	 * @param aOperationsStaff the OperationsStaff to remove
	 * @return true if the OperationsStaff was removed, false otherwise
	 */
  public boolean removeOperationsStaff(OperationsStaff aOperationsStaff)
  {
    boolean wasRemoved = false;
    if (!operationsStaffs.contains(aOperationsStaff))
    {
      return wasRemoved;
    }

    int oldIndex = operationsStaffs.indexOf(aOperationsStaff);
    operationsStaffs.remove(oldIndex);
    if (aOperationsStaff.indexOfPatient(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aOperationsStaff.removePatient(this);
      if (!wasRemoved)
      {
        operationsStaffs.add(oldIndex,aOperationsStaff);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  /**
	 * Adds an OperationsStaff object at the specified index in the list of
	 * OperationsStaffs.
	 * 
	 * @param aOperationsStaff the OperationsStaff object to be added
	 * @param index            the index at which the OperationsStaff object should
	 *                         be added
	 * @return true if the OperationsStaff object was successfully added at the
	 *         specified index; false otherwise
	 */
  public boolean addOperationsStaffAt(OperationsStaff aOperationsStaff, int index)
  {  
    boolean wasAdded = false;
    if(addOperationsStaff(aOperationsStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOperationsStaffs()) { index = numberOfOperationsStaffs() - 1; }
      operationsStaffs.remove(aOperationsStaff);
      operationsStaffs.add(index, aOperationsStaff);
      wasAdded = true;
    }
    return wasAdded;
  }
  /**
	 * Adds an OperationsStaff object at the specified index in the list of
	 * OperationsStaffs or moves it to that index if it is already present in the
	 * list.
	 * 
	 * @param aOperationsStaff the OperationsStaff object to be added or moved
	 * @param index            the index at which the OperationsStaff object should
	 *                         be added or moved
	 * @return true if the OperationsStaff object was successfully added or moved to
	 *         the specified index; false otherwise
	 */

  public boolean addOrMoveOperationsStaffAt(OperationsStaff aOperationsStaff, int index)
  {
    boolean wasAdded = false;
    if(operationsStaffs.contains(aOperationsStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOperationsStaffs()) { index = numberOfOperationsStaffs() - 1; }
      operationsStaffs.remove(aOperationsStaff);
      operationsStaffs.add(index, aOperationsStaff);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOperationsStaffAt(aOperationsStaff, index);
    }
    return wasAdded;
  }
  /**
	 * Removes this Patient object from the system by removing all references to it
	 * in the list of OperationsStaff objects that have this Patient object
	 * associated with them, and then calling the delete method of the superclass.
	 */
  public void delete()
  {
    patientsById.remove(getId());
    ArrayList<OperationsStaff> copyOfOperationsStaffs = new ArrayList<OperationsStaff>(operationsStaffs);
    operationsStaffs.clear();
    for(OperationsStaff aOperationsStaff : copyOfOperationsStaffs)
    {
      aOperationsStaff.removePatient(this);
    }
    super.delete();
  }
  /**
	 * Returns a string representation of this Patient object in the following
	 * format: Patient[id:<id>, age:<age>, accepted:<accepted>, sickness:<sickness>,
	 * prescriptions:<prescriptions>, allergies:<allergies>,
	 * specialReqs:<specialReqs>]
	 *
	 * @return a string representation of this Patient object
	 */

  public String toString()
  {
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "age" + ":" + getAge()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "accepted" + "=" + (getAccepted() != null ? !getAccepted().equals(this)  ? getAccepted().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "sickness" + "=" + (getSickness() != null ? !getSickness().equals(this)  ? getSickness().toString().replaceAll("  ","    ") : "this" : "null");
  }
}