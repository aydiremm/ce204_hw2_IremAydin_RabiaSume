/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_treatment_lib;
import java.util.*;

// line 22 "../treatment.ump"
// line 72 "../treatment.ump"
public class Diagnosis
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Diagnosis Associations
  private List<Examination> examinations;
  private List<Prescription> results_prescription;
  private List<Patient> patients;
  private List<Doctor> make;
  private List<Treatment> results_diagnosis;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  /**
	 * @brief Constructor for creating a Diagnosis object with the given patientTrT
	 *        attribute.
	 * @param aPatientTrT The PatientTrT object associated with the diagnosis.
	 * @throw RuntimeException If unable to create a diagnosis due to a violation of
	 *        the patientTrT association multiplicity constraint.
	 */

  public Diagnosis()
  {
    examinations = new ArrayList<Examination>();
    results_prescription = new ArrayList<Prescription>();
    patients = new ArrayList<Patient>();
    make = new ArrayList<Doctor>();
    results_diagnosis = new ArrayList<Treatment>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
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

  public int indexOfExamination(Examination aExamination)
  {
    int index = examinations.indexOf(aExamination);
    return index;
  }
  /* Code from template association_GetMany */
  public Prescription getResults_prescription(int index)
  {
    Prescription aResults_prescription = results_prescription.get(index);
    return aResults_prescription;
  }

  public List<Prescription> getResults_prescription()
  {
    List<Prescription> newResults_prescription = Collections.unmodifiableList(results_prescription);
    return newResults_prescription;
  }

  public int numberOfResults_prescription()
  {
    int number = results_prescription.size();
    return number;
  }

  public boolean hasResults_prescription()
  {
    boolean has = results_prescription.size() > 0;
    return has;
  }

  public int indexOfResults_prescription(Prescription aResults_prescription)
  {
    int index = results_prescription.indexOf(aResults_prescription);
    return index;
  }
  /* Code from template association_GetMany */
  public Patient getPatient(int index)
  {
    Patient aPatient = patients.get(index);
    return aPatient;
  }

  public List<Patient> getPatients()
  {
    List<Patient> newPatients = Collections.unmodifiableList(patients);
    return newPatients;
  }

  public int numberOfPatients()
  {
    int number = patients.size();
    return number;
  }

  public boolean hasPatients()
  {
    boolean has = patients.size() > 0;
    return has;
  }

  public int indexOfPatient(Patient aPatient)
  {
    int index = patients.indexOf(aPatient);
    return index;
  }
  /* Code from template association_GetMany */
  public Doctor getMake(int index)
  {
    Doctor aMake = make.get(index);
    return aMake;
  }

  public List<Doctor> getMake()
  {
    List<Doctor> newMake = Collections.unmodifiableList(make);
    return newMake;
  }

  public int numberOfMake()
  {
    int number = make.size();
    return number;
  }

  public boolean hasMake()
  {
    boolean has = make.size() > 0;
    return has;
  }

  public int indexOfMake(Doctor aMake)
  {
    int index = make.indexOf(aMake);
    return index;
  }
  /* Code from template association_GetMany */
  public Treatment getResults_diagnosi(int index)
  {
    Treatment aResults_diagnosi = results_diagnosis.get(index);
    return aResults_diagnosi;
  }

  public List<Treatment> getResults_diagnosis()
  {
    List<Treatment> newResults_diagnosis = Collections.unmodifiableList(results_diagnosis);
    return newResults_diagnosis;
  }

  public int numberOfResults_diagnosis()
  {
    int number = results_diagnosis.size();
    return number;
  }

  public boolean hasResults_diagnosis()
  {
    boolean has = results_diagnosis.size() > 0;
    return has;
  }
	/**
	 * @brief Returns the index of the given treatment in the treatments list.
	 * @param aTreatment The Treatment object to search for.
	 * @return The index of the treatment in the treatments list, or -1 if the
	 *         treatment is not found.
	 */
  public int indexOfResults_diagnosi(Treatment aResults_diagnosi)
  {
    int index = results_diagnosis.indexOf(aResults_diagnosi);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfExaminations()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addExamination(Examination aExamination)
  {
    boolean wasAdded = false;
    if (examinations.contains(aExamination)) { return false; }
    examinations.add(aExamination);
    if (aExamination.indexOfDiagnosi(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aExamination.addDiagnosi(this);
      if (!wasAdded)
      {
        examinations.remove(aExamination);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeExamination(Examination aExamination)
  {
    boolean wasRemoved = false;
    if (!examinations.contains(aExamination))
    {
      return wasRemoved;
    }

    int oldIndex = examinations.indexOf(aExamination);
    examinations.remove(oldIndex);
    if (aExamination.indexOfDiagnosi(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aExamination.removeDiagnosi(this);
      if (!wasRemoved)
      {
        examinations.add(oldIndex,aExamination);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
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
  public static int minimumNumberOfResults_prescription()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addResults_prescription(Prescription aResults_prescription)
  {
    boolean wasAdded = false;
    if (results_prescription.contains(aResults_prescription)) { return false; }
    results_prescription.add(aResults_prescription);
    if (aResults_prescription.indexOfDiagnosi(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aResults_prescription.addDiagnosi(this);
      if (!wasAdded)
      {
        results_prescription.remove(aResults_prescription);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeResults_prescription(Prescription aResults_prescription)
  {
    boolean wasRemoved = false;
    if (!results_prescription.contains(aResults_prescription))
    {
      return wasRemoved;
    }

    int oldIndex = results_prescription.indexOf(aResults_prescription);
    results_prescription.remove(oldIndex);
    if (aResults_prescription.indexOfDiagnosi(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aResults_prescription.removeDiagnosi(this);
      if (!wasRemoved)
      {
        results_prescription.add(oldIndex,aResults_prescription);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addResults_prescriptionAt(Prescription aResults_prescription, int index)
  {  
    boolean wasAdded = false;
    if(addResults_prescription(aResults_prescription))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfResults_prescription()) { index = numberOfResults_prescription() - 1; }
      results_prescription.remove(aResults_prescription);
      results_prescription.add(index, aResults_prescription);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveResults_prescriptionAt(Prescription aResults_prescription, int index)
  {
    boolean wasAdded = false;
    if(results_prescription.contains(aResults_prescription))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfResults_prescription()) { index = numberOfResults_prescription() - 1; }
      results_prescription.remove(aResults_prescription);
      results_prescription.add(index, aResults_prescription);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addResults_prescriptionAt(aResults_prescription, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatients()
  {
    return 0;
  }	/* Code from template association_SetOneToMany */
	/**
	 * @brief Adds patient to the attribute of the Diagnosis object
	 *        Patient object.
	 * @param aPatientTrT The PatientTrT object to set as the patientTrT attribute.
	 * @return True if the patientTrT attribute was successfully set, false
	 *         otherwise.
	 */
  public boolean addPatient(Patient aPatient)
  {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) { return false; }
    patients.add(aPatient);
    if (aPatient.indexOfDiagnosi(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPatient.addDiagnosi(this);
      if (!wasAdded)
      {
        patients.remove(aPatient);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePatient(Patient aPatient)
  {
    boolean wasRemoved = false;
    if (!patients.contains(aPatient))
    {
      return wasRemoved;
    }

    int oldIndex = patients.indexOf(aPatient);
    patients.remove(oldIndex);
    if (aPatient.indexOfDiagnosi(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPatient.removeDiagnosi(this);
      if (!wasRemoved)
      {
        patients.add(oldIndex,aPatient);
      }
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
  public static int minimumNumberOfMake()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addMake(Doctor aMake)
  {
    boolean wasAdded = false;
    if (make.contains(aMake)) { return false; }
    make.add(aMake);
    if (aMake.indexOfDiagnosi(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aMake.addDiagnosi(this);
      if (!wasAdded)
      {
        make.remove(aMake);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeMake(Doctor aMake)
  {
    boolean wasRemoved = false;
    if (!make.contains(aMake))
    {
      return wasRemoved;
    }

    int oldIndex = make.indexOf(aMake);
    make.remove(oldIndex);
    if (aMake.indexOfDiagnosi(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aMake.removeDiagnosi(this);
      if (!wasRemoved)
      {
        make.add(oldIndex,aMake);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMakeAt(Doctor aMake, int index)
  {  
    boolean wasAdded = false;
    if(addMake(aMake))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMake()) { index = numberOfMake() - 1; }
      make.remove(aMake);
      make.add(index, aMake);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMakeAt(Doctor aMake, int index)
  {
    boolean wasAdded = false;
    if(make.contains(aMake))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMake()) { index = numberOfMake() - 1; }
      make.remove(aMake);
      make.add(index, aMake);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMakeAt(aMake, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfResults_diagnosis()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addResults_diagnosi(Treatment aResults_diagnosi)
  {
    boolean wasAdded = false;
    if (results_diagnosis.contains(aResults_diagnosi)) { return false; }
    results_diagnosis.add(aResults_diagnosi);
    if (aResults_diagnosi.indexOfDiagnosi(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aResults_diagnosi.addDiagnosi(this);
      if (!wasAdded)
      {
        results_diagnosis.remove(aResults_diagnosi);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeResults_diagnosi(Treatment aResults_diagnosi)
  {
    boolean wasRemoved = false;
    if (!results_diagnosis.contains(aResults_diagnosi))
    {
      return wasRemoved;
    }

    int oldIndex = results_diagnosis.indexOf(aResults_diagnosi);
    results_diagnosis.remove(oldIndex);
    if (aResults_diagnosi.indexOfDiagnosi(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aResults_diagnosi.removeDiagnosi(this);
      if (!wasRemoved)
      {
        results_diagnosis.add(oldIndex,aResults_diagnosi);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addResults_diagnosiAt(Treatment aResults_diagnosi, int index)
  {  
    boolean wasAdded = false;
    if(addResults_diagnosi(aResults_diagnosi))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfResults_diagnosis()) { index = numberOfResults_diagnosis() - 1; }
      results_diagnosis.remove(aResults_diagnosi);
      results_diagnosis.add(index, aResults_diagnosi);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveResults_diagnosiAt(Treatment aResults_diagnosi, int index)
  {
    boolean wasAdded = false;
    if(results_diagnosis.contains(aResults_diagnosi))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfResults_diagnosis()) { index = numberOfResults_diagnosis() - 1; }
      results_diagnosis.remove(aResults_diagnosi);
      results_diagnosis.add(index, aResults_diagnosi);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addResults_diagnosiAt(aResults_diagnosi, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Examination> copyOfExaminations = new ArrayList<Examination>(examinations);
    examinations.clear();
    for(Examination aExamination : copyOfExaminations)
    {
      aExamination.removeDiagnosi(this);
    }
    ArrayList<Prescription> copyOfResults_prescription = new ArrayList<Prescription>(results_prescription);
    results_prescription.clear();
    for(Prescription aResults_prescription : copyOfResults_prescription)
    {
      aResults_prescription.removeDiagnosi(this);
    }
    ArrayList<Patient> copyOfPatients = new ArrayList<Patient>(patients);
    patients.clear();
    for(Patient aPatient : copyOfPatients)
    {
      aPatient.removeDiagnosi(this);
    }
    ArrayList<Doctor> copyOfMake = new ArrayList<Doctor>(make);
    make.clear();
    for(Doctor aMake : copyOfMake)
    {
      aMake.removeDiagnosi(this);
    }
    ArrayList<Treatment> copyOfResults_diagnosis = new ArrayList<Treatment>(results_diagnosis);
    results_diagnosis.clear();
    for(Treatment aResults_diagnosi : copyOfResults_diagnosis)
    {
      aResults_diagnosi.removeDiagnosi(this);
    }
  }

}