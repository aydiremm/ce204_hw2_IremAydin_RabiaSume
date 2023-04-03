/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package ce204_hw2_treatment_lib;
import java.util.*;

// line 9 "../treatment.ump"
// line 61 "../treatment.ump"
public class Doctor
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Doctor Associations
  private List<Patient> patients;
  private List<Prescription> write;
  private List<Treatment> treatments;
  private Examination examination;
  private List<Diagnosis> diagnosis;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Doctor(Examination aExamination)
  {
    patients = new ArrayList<Patient>();
    write = new ArrayList<Prescription>();
    treatments = new ArrayList<Treatment>();
    boolean didAddExamination = setExamination(aExamination);
    if (!didAddExamination)
    {
      throw new RuntimeException("Unable to create doctor due to examination. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    diagnosis = new ArrayList<Diagnosis>();
  }

  //------------------------
  // INTERFACE
  //------------------------
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
  public Prescription getWrite(int index)
  {
    Prescription aWrite = write.get(index);
    return aWrite;
  }

  public List<Prescription> getWrite()
  {
    List<Prescription> newWrite = Collections.unmodifiableList(write);
    return newWrite;
  }

  public int numberOfWrite()
  {
    int number = write.size();
    return number;
  }

  public boolean hasWrite()
  {
    boolean has = write.size() > 0;
    return has;
  }

  public int indexOfWrite(Prescription aWrite)
  {
    int index = write.indexOf(aWrite);
    return index;
  }
  /* Code from template association_GetMany */
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

  public int indexOfTreatment(Treatment aTreatment)
  {
    int index = treatments.indexOf(aTreatment);
    return index;
  }
  /* Code from template association_GetOne */
  public Examination getExamination()
  {
    return examination;
  }
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

  public int indexOfDiagnosi(Diagnosis aDiagnosi)
  {
    int index = diagnosis.indexOf(aDiagnosi);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPatients()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPatient(Patient aPatient)
  {
    boolean wasAdded = false;
    if (patients.contains(aPatient)) { return false; }
    patients.add(aPatient);
    if (aPatient.indexOfDoctor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPatient.addDoctor(this);
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
    if (aPatient.indexOfDoctor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPatient.removeDoctor(this);
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
  public static int minimumNumberOfWrite()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addWrite(Prescription aWrite)
  {
    boolean wasAdded = false;
    if (write.contains(aWrite)) { return false; }
    write.add(aWrite);
    if (aWrite.indexOfDoctor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aWrite.addDoctor(this);
      if (!wasAdded)
      {
        write.remove(aWrite);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeWrite(Prescription aWrite)
  {
    boolean wasRemoved = false;
    if (!write.contains(aWrite))
    {
      return wasRemoved;
    }

    int oldIndex = write.indexOf(aWrite);
    write.remove(oldIndex);
    if (aWrite.indexOfDoctor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aWrite.removeDoctor(this);
      if (!wasRemoved)
      {
        write.add(oldIndex,aWrite);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addWriteAt(Prescription aWrite, int index)
  {  
    boolean wasAdded = false;
    if(addWrite(aWrite))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWrite()) { index = numberOfWrite() - 1; }
      write.remove(aWrite);
      write.add(index, aWrite);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWriteAt(Prescription aWrite, int index)
  {
    boolean wasAdded = false;
    if(write.contains(aWrite))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWrite()) { index = numberOfWrite() - 1; }
      write.remove(aWrite);
      write.add(index, aWrite);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWriteAt(aWrite, index);
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
    if (aTreatment.indexOfDoctor(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTreatment.addDoctor(this);
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
    if (aTreatment.indexOfDoctor(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTreatment.removeDoctor(this);
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
  /* Code from template association_SetOneToMany */
  public boolean setExamination(Examination aExamination)
  {
    boolean wasSet = false;
    if (aExamination == null)
    {
      return wasSet;
    }

    Examination existingExamination = examination;
    examination = aExamination;
    if (existingExamination != null && !existingExamination.equals(aExamination))
    {
      existingExamination.removeDoctor(this);
    }
    examination.addDoctor(this);
    wasSet = true;
    return wasSet;
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
    if (aDiagnosi.indexOfMake(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDiagnosi.addMake(this);
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
    if (aDiagnosi.indexOfMake(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDiagnosi.removeMake(this);
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
    ArrayList<Patient> copyOfPatients = new ArrayList<Patient>(patients);
    patients.clear();
    for(Patient aPatient : copyOfPatients)
    {
      aPatient.removeDoctor(this);
    }
    ArrayList<Prescription> copyOfWrite = new ArrayList<Prescription>(write);
    write.clear();
    for(Prescription aWrite : copyOfWrite)
    {
      aWrite.removeDoctor(this);
    }
    ArrayList<Treatment> copyOfTreatments = new ArrayList<Treatment>(treatments);
    treatments.clear();
    for(Treatment aTreatment : copyOfTreatments)
    {
      aTreatment.removeDoctor(this);
    }
    Examination placeholderExamination = examination;
    this.examination = null;
    if(placeholderExamination != null)
    {
      placeholderExamination.removeDoctor(this);
    }
    ArrayList<Diagnosis> copyOfDiagnosis = new ArrayList<Diagnosis>(diagnosis);
    diagnosis.clear();
    for(Diagnosis aDiagnosi : copyOfDiagnosis)
    {
      aDiagnosi.removeMake(this);
    }
  }

}