/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_treatment_lib;
import java.sql.Date;
import java.util.*;
import ce204_hw2_organization_lib.*;

// line 10 "../../model.ump"
// line 97 "../../model.ump"
/**

Creates a new instance of DoctorTrT with the specified attributes and initializes the DoctorTrT's lists of associated
PatientTrTs, Examinations, Prescriptions, Treatments, and Diagnoses.
@param aTitle the title of the doctor
@param aGivenName the given name of the doctor
@param aMiddleName the middle name of the doctor
@param aFamilyName the family name of the doctor
@param aBirthDate the birth date of the doctor
@param aGender the gender of the doctor
@param aHomeAddress the home address of the doctor
@param aPhone the phone number of the doctor
@param aJoined the date when the doctor joined the medical institution
@param aEducation the education of the doctor
@param aCertification the certification of the doctor
@param aLanguages the languages spoken by the doctor
@param aDepartment the department of the doctor
@param aSpecialty the specialty of the doctor
@param aLocations the locations where the doctor practices
*/
public class DoctorTrT extends Doctor
{

public DoctorTrT(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification,
			String aLanguages, Department aDepartment, String aSpecialty, String aLocations) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined, aEducation,
				aCertification, aLanguages, aDepartment, aSpecialty, aLocations);
		// TODO Auto-generated constructor stub
		patientTrTs = new ArrayList<PatientTrT>();
	    examinations = new ArrayList<Examination>();
	    prescriptions = new ArrayList<Prescription>();
	    treatments = new ArrayList<Treatment>();
	    diagnosis = new ArrayList<Diagnosis>();
	}

//------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoctorTrT Associations
  private List<PatientTrT> patientTrTs;
  private List<Examination> examinations;
  private List<Prescription> prescriptions;
  private List<Treatment> treatments;
  private List<Diagnosis> diagnosis;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  /**
   * @brief Get the PatientTrT object at the specified index in the patientTrTs list.
   * 
   * @param index The index of the PatientTrT object to retrieve.
   * @return The PatientTrT object at the specified index.
   */
  public PatientTrT getPatientTrT(int index)
  {
    PatientTrT aPatientTrT = patientTrTs.get(index);
    return aPatientTrT;
  }

  public List<PatientTrT> getPatientTrTs()
  {
    List<PatientTrT> newPatientTrTs = Collections.unmodifiableList(patientTrTs);
    return newPatientTrTs;
  }

  public int numberOfPatientTrTs()
  {
    int number = patientTrTs.size();
    return number;
  }

  public boolean hasPatientTrTs()
  {
    boolean has = patientTrTs.size() > 0;
    return has;
  }
  /**
   * @brief Get the index of the specified PatientTrT object in the patientTrTs list.
   * 
   * @param aPatientTrT The PatientTrT object to search for in the patientTrTs list.
   * @return The index of the specified PatientTrT object in the patientTrTs list, or -1 if it is not found.
   */

  public int indexOfPatientTrT(PatientTrT aPatientTrT)
  {
    int index = patientTrTs.indexOf(aPatientTrT);
    return index;
  }
  /* Code from template association_GetMany */
  /**
   * @brief Get the Examination object at the specified index in the examinations list.
   * 
   * @param index The index of the Examination object to retrieve.
   * @return The Examination object at the specified index.
   */
  public Examination getExamination(int index)
  {
    Examination aExamination = examinations.get(index);
    return aExamination;
  }

  public List<Examination> getExaminations()
  {
    List<Examination> newExaminations = Collections.unmodifiableList(examinations);
    return newExaminations;
  }

  public int numberOfExaminations()
  {
    int number = examinations.size();
    return number;
  }

  public boolean hasExaminations()
  {
    boolean has = examinations.size() > 0;
    return has;
  }
  /**
   * @brief Get the index of the specified Examination object in the examinations list.
   * 
   * @param aExamination The Examination object to search for in the examinations list.
   * @return The index of the specified Examination object in the examinations list, or -1 if it is not found.
   */
  public int indexOfExamination(Examination aExamination)
  {
    int index = examinations.indexOf(aExamination);
    return index;
  }
  /* Code from template association_GetMany */
  /**
   * @brief Get the Prescription object at the specified index in the prescriptions list.
   * 
   * @param index The index of the Prescription object to retrieve.
   * @return The Prescription object at the specified index.
   */
  public Prescription getPrescription(int index)
  {
    Prescription aPrescription = prescriptions.get(index);
    return aPrescription;
  }

  public List<Prescription> getPrescriptions()
  {
    List<Prescription> newPrescriptions = Collections.unmodifiableList(prescriptions);
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
  /**
   * @brief Get the index of the specified Prescription object in the prescriptions list.
   * 
   * @param aPrescription The Prescription object to search for in the prescriptions list.
   * @return The index of the specified Prescription object in the prescriptions list, or -1 if it is not found.
   */

  public int indexOfPrescription(Prescription aPrescription)
  {
    int index = prescriptions.indexOf(aPrescription);
    return index;
  }
  /* Code from template association_GetMany */
  /**
   * @brief Get the Treatment object at the specified index in the treatments list.
   * 
   * @param index The index of the Treatment object to retrieve.
   * @return The Treatment object at the specified index.
   */
  public Treatment getTreatment(int index)
  {
    Treatment aTreatment = treatments.get(index);
    return aTreatment;
  }

  public List<Treatment> getTreatments()
  {
    List<Treatment> newTreatments = Collections.unmodifiableList(treatments);
    return newTreatments;
  }

  public int numberOfTreatments()
  {
    int number = treatments.size();
    return number;
  }

  public boolean hasTreatments()
  {
    boolean has = treatments.size() > 0;
    return has;
  }
  /**
   * @brief Get the index of the specified Treatment object in the treatments list.
   * 
   * @param aTreatment The Treatment object to search for in the treatments list.
   * @return The index of the specified Treatment object in the treatments list, or -1 if it is not found.
   */

  public int indexOfTreatment(Treatment aTreatment)
  {
    int index = treatments.indexOf(aTreatment);
    return index;
  }
  /**
   * @brief Get the Diagnosis object at the specified index in the diagnosis list.
   * 
   * @param index The index of the Diagnosis object to retrieve.
   * @return The Diagnosis object at the specified index.
   */
  /* Code from template association_GetMany */
  public Diagnosis getDiagnosi(int index)
  {
    Diagnosis aDiagnosi = diagnosis.get(index);
    return aDiagnosi;
  }

  public List<Diagnosis> getDiagnosis()
  {
    List<Diagnosis> newDiagnosis = Collections.unmodifiableList(diagnosis);
    return newDiagnosis;
  }

  public int numberOfDiagnosis()
  {
    int number = diagnosis.size();
    return number;
  }

  public boolean hasDiagnosis()
  {
    boolean has = diagnosis.size() > 0;
    return has;
  }
  /**
   * @brief Get the index of the specified Diagnosis object in the diagnosis list.
   * 
   * @param aDiagnosi The Diagnosis object to search for in the diagnosis list.
   * @return The index of the specified Diagnosis object in the diagnosis list, or -1 if it is not found.
   */
  public int indexOfDiagnosi(Diagnosis aDiagnosi)
  {
    int index = diagnosis.indexOf(aDiagnosi);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatientTrTs()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  /**
   * @brief Add the specified PatientTrT object to the patientTrTs list and associate it with this DoctorTrT object.
   * 
   * @param aPatientTrT The PatientTrT object to add and associate with this DoctorTrT object.
   * @return true if the PatientTrT object was added and associated with this DoctorTrT object, false otherwise.
   */
  public boolean addPatientTrT(PatientTrT aPatientTrT)
  {
    boolean wasAdded = false;
    if (patientTrTs.contains(aPatientTrT)) { return false; }
    patientTrTs.add(aPatientTrT);
    if (aPatientTrT.indexOfDoctorTrT(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPatientTrT.addDoctorTrT(this);
      if (!wasAdded)
      {
        patientTrTs.remove(aPatientTrT);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  /**
   * @brief Remove the specified PatientTrT object from the patientTrTs list and dissociate it from this DoctorTrT object.
   * 
   * @param aPatientTrT The PatientTrT object to remove and dissociate from this DoctorTrT object.
   * @return true if the PatientTrT object was removed and dissociated from this DoctorTrT object, false otherwise.
   */
  public boolean removePatientTrT(PatientTrT aPatientTrT)
  {
    boolean wasRemoved = false;
    if (!patientTrTs.contains(aPatientTrT))
    {
      return wasRemoved;
    }

    int oldIndex = patientTrTs.indexOf(aPatientTrT);
    patientTrTs.remove(oldIndex);
    if (aPatientTrT.indexOfDoctorTrT(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPatientTrT.removeDoctorTrT(this);
      if (!wasRemoved)
      {
        patientTrTs.add(oldIndex,aPatientTrT);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  /**

  Add aPatientTrT to the DoctorTrT's list of PatientTrTs at the specified index.
  If the given aPatientTrT is already in the list, it will not be added again.
  If the index is out of range, the aPatientTrT will be added to the beginning or end of the list.
  @param aPatientTrT The PatientTrT to add.
  @param index The index at which to add the PatientTrT.
  @return true if the PatientTrT was successfully added or moved, false otherwise.
  */
  public boolean addPatientTrTAt(PatientTrT aPatientTrT, int index)
  {  
    boolean wasAdded = false;
    if(addPatientTrT(aPatientTrT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatientTrTs()) { index = numberOfPatientTrTs() - 1; }
      patientTrTs.remove(aPatientTrT);
      patientTrTs.add(index, aPatientTrT);
      wasAdded = true;
    }
    return wasAdded;
  }
  /**

  Add aPatientTrT to the DoctorTrT's list of PatientTrTs at the specified index.
  If the given aPatientTrT is already in the list, it will be moved to the specified index.
  If the index is out of range, the aPatientTrT will be added to the beginning or end of the list.
  @param aPatientTrT The PatientTrT to add or move.
  @param index The index at which to add or move the PatientTrT.
  @return true if the PatientTrT was successfully added or moved, false otherwise.
  */
  public boolean addOrMovePatientTrTAt(PatientTrT aPatientTrT, int index)
  {
    boolean wasAdded = false;
    if(patientTrTs.contains(aPatientTrT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPatientTrTs()) { index = numberOfPatientTrTs() - 1; }
      patientTrTs.remove(aPatientTrT);
      patientTrTs.add(index, aPatientTrT);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPatientTrTAt(aPatientTrT, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfExaminations()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  /**

  Adds a new examination to the DoctorTrT's list of examinations.
  @param aPatientTrT The patient to create an examination for.
  @return A new Examination object.
  */
  
  public Examination addExamination(PatientTrT aPatientTrT)
  {
    return new Examination(aPatientTrT, this);
  }
  /**

  Adds an existing examination to the DoctorTrT's list of examinations.
  @param aExamination The examination to be added.
  @return True if the examination was successfully added, false otherwise.
  */
  public boolean addExamination(Examination aExamination)
  {
    boolean wasAdded = false;
    if (examinations.contains(aExamination)) { return false; }
    DoctorTrT existingDoctorTrT = aExamination.getDoctorTrT();
    boolean isNewDoctorTrT = existingDoctorTrT != null && !this.equals(existingDoctorTrT);
    if (isNewDoctorTrT)
    {
      aExamination.setDoctorTrT(this);
    }
    else
    {
      examinations.add(aExamination);
    }
    wasAdded = true;
    return wasAdded;
  }
  /**

  Removes an examination from the DoctorTrT's list of examinations.
  @param aExamination The examination to be removed.
  @return True if the examination was successfully removed, false otherwise.
  */
  public boolean removeExamination(Examination aExamination)
  {
    boolean wasRemoved = false;
    //Unable to remove aExamination, as it must always have a doctorTrT
    if (!this.equals(aExamination.getDoctorTrT()))
    {
      examinations.remove(aExamination);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  /**

  Adds an examination at a specific index in the DoctorTrT's list of examinations.
  @param aExamination The examination to be added.
  @param index The index where the examination should be added.
  @return True if the examination was successfully added, false otherwise.
  */
  public boolean addExaminationAt(Examination aExamination, int index)
  {  
    boolean wasAdded = false;
    if(addExamination(aExamination))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExaminations()) { index = numberOfExaminations() - 1; }
      examinations.remove(aExamination);
      examinations.add(index, aExamination);
      wasAdded = true;
    }
    return wasAdded;
  }
  /**

  Adds a new Examination object to the list of examinations for this DoctorTrT object, with the given PatientTrT.
  @param aPatientTrT the patient to be examined
  @return the new Examination object that was added
  */

  public boolean addOrMoveExaminationAt(Examination aExamination, int index)
  {
    boolean wasAdded = false;
    if(examinations.contains(aExamination))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExaminations()) { index = numberOfExaminations() - 1; }
      examinations.remove(aExamination);
      examinations.add(index, aExamination);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addExaminationAt(aExamination, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  
  public static int minimumNumberOfPrescriptions()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  
  public boolean addPrescription(Prescription aPrescription)
  {
    boolean wasAdded = false;
    if (prescriptions.contains(aPrescription)) { return false; }
    prescriptions.add(aPrescription);
    if (aPrescription.indexOfDoctorTrT(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPrescription.addDoctorTrT(this);
      if (!wasAdded)
      {
        prescriptions.remove(aPrescription);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePrescription(Prescription aPrescription)
  {
    boolean wasRemoved = false;
    if (!prescriptions.contains(aPrescription))
    {
      return wasRemoved;
    }

    int oldIndex = prescriptions.indexOf(aPrescription);
    prescriptions.remove(oldIndex);
    if (aPrescription.indexOfDoctorTrT(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPrescription.removeDoctorTrT(this);
      if (!wasRemoved)
      {
        prescriptions.add(oldIndex,aPrescription);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPrescriptionAt(Prescription aPrescription, int index)
  {  
    boolean wasAdded = false;
    if(addPrescription(aPrescription))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPrescriptions()) { index = numberOfPrescriptions() - 1; }
      prescriptions.remove(aPrescription);
      prescriptions.add(index, aPrescription);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePrescriptionAt(Prescription aPrescription, int index)
  {
    boolean wasAdded = false;
    if(prescriptions.contains(aPrescription))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPrescriptions()) { index = numberOfPrescriptions() - 1; }
      prescriptions.remove(aPrescription);
      prescriptions.add(index, aPrescription);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPrescriptionAt(aPrescription, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTreatments()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTreatment(Treatment aTreatment)
  {
    boolean wasAdded = false;
    if (treatments.contains(aTreatment)) { return false; }
    treatments.add(aTreatment);
    if (aTreatment.indexOfDoctorTrT(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTreatment.addDoctorTrT(this);
      if (!wasAdded)
      {
        treatments.remove(aTreatment);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTreatment(Treatment aTreatment)
  {
    boolean wasRemoved = false;
    if (!treatments.contains(aTreatment))
    {
      return wasRemoved;
    }

    int oldIndex = treatments.indexOf(aTreatment);
    treatments.remove(oldIndex);
    if (aTreatment.indexOfDoctorTrT(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTreatment.removeDoctorTrT(this);
      if (!wasRemoved)
      {
        treatments.add(oldIndex,aTreatment);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTreatmentAt(Treatment aTreatment, int index)
  {  
    boolean wasAdded = false;
    if(addTreatment(aTreatment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreatments()) { index = numberOfTreatments() - 1; }
      treatments.remove(aTreatment);
      treatments.add(index, aTreatment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTreatmentAt(Treatment aTreatment, int index)
  {
    boolean wasAdded = false;
    if(treatments.contains(aTreatment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTreatments()) { index = numberOfTreatments() - 1; }
      treatments.remove(aTreatment);
      treatments.add(index, aTreatment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTreatmentAt(aTreatment, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDiagnosis()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDiagnosi(Diagnosis aDiagnosi)
  {
    boolean wasAdded = false;
    if (diagnosis.contains(aDiagnosi)) { return false; }
    diagnosis.add(aDiagnosi);
    if (aDiagnosi.indexOfDoctorTrT(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDiagnosi.addDoctorTrT(this);
      if (!wasAdded)
      {
        diagnosis.remove(aDiagnosi);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDiagnosi(Diagnosis aDiagnosi)
  {
    boolean wasRemoved = false;
    if (!diagnosis.contains(aDiagnosi))
    {
      return wasRemoved;
    }

    int oldIndex = diagnosis.indexOf(aDiagnosi);
    diagnosis.remove(oldIndex);
    if (aDiagnosi.indexOfDoctorTrT(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDiagnosi.removeDoctorTrT(this);
      if (!wasRemoved)
      {
        diagnosis.add(oldIndex,aDiagnosi);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDiagnosiAt(Diagnosis aDiagnosi, int index)
  {  
    boolean wasAdded = false;
    if(addDiagnosi(aDiagnosi))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDiagnosis()) { index = numberOfDiagnosis() - 1; }
      diagnosis.remove(aDiagnosi);
      diagnosis.add(index, aDiagnosi);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDiagnosiAt(Diagnosis aDiagnosi, int index)
  {
    boolean wasAdded = false;
    if(diagnosis.contains(aDiagnosi))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDiagnosis()) { index = numberOfDiagnosis() - 1; }
      diagnosis.remove(aDiagnosi);
      diagnosis.add(index, aDiagnosi);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDiagnosiAt(aDiagnosi, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<PatientTrT> copyOfPatientTrTs = new ArrayList<PatientTrT>(patientTrTs);
    patientTrTs.clear();
    for(PatientTrT aPatientTrT : copyOfPatientTrTs)
    {
      aPatientTrT.removeDoctorTrT(this);
    }
    for(int i=examinations.size(); i > 0; i--)
    {
      Examination aExamination = examinations.get(i - 1);
      aExamination.delete();
    }
    ArrayList<Prescription> copyOfPrescriptions = new ArrayList<Prescription>(prescriptions);
    prescriptions.clear();
    for(Prescription aPrescription : copyOfPrescriptions)
    {
      aPrescription.removeDoctorTrT(this);
    }
    ArrayList<Treatment> copyOfTreatments = new ArrayList<Treatment>(treatments);
    treatments.clear();
    for(Treatment aTreatment : copyOfTreatments)
    {
      aTreatment.removeDoctorTrT(this);
    }
    ArrayList<Diagnosis> copyOfDiagnosis = new ArrayList<Diagnosis>(diagnosis);
    diagnosis.clear();
    for(Diagnosis aDiagnosi : copyOfDiagnosis)
    {
      aDiagnosi.removeDoctorTrT(this);
    }
  }

}