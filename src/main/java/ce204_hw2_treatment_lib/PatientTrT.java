/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_treatment_lib;
import java.sql.Date;
import java.util.*;
import ce204_hw2_organization_lib.*;

// line 4 "../../model.ump"
// line 87 "../../model.ump"
// line 92 "../../model.ump"
public class PatientTrT extends Patient
{

 

public PatientTrT(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, String aId, int aAge, String aAccepted,
			String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aId, aAge, aAccepted,
				aSickness, aPrescriptions, aAllergies, aSpecialReqs);
		// TODO Auto-generated constructor stub
		prescriptions = new ArrayList<Prescription>();
	    treatments = new ArrayList<Treatment>();
	    doctorTrTs = new ArrayList<DoctorTrT>();
	    examinations = new ArrayList<Examination>();
	    diagnosis = new ArrayList<Diagnosis>();
	}

//------------------------
  // MEMBER VARIABLES
  //------------------------

  //PatientTrT Associations
  private List<Prescription> prescriptions;
  private List<Treatment> treatments;
  private List<DoctorTrT> doctorTrTs;
  private List<Examination> examinations;
  private List<Diagnosis> diagnosis;

  //------------------------
  // CONSTRUCTOR
  //------------------------

 
  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Prescription getPrescription(int index)
  {
    Prescription aPrescription = prescriptions.get(index);
    return aPrescription;
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

  public int indexOfPrescription(Prescription aPrescription)
  {
    int index = prescriptions.indexOf(aPrescription);
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
  /* Code from template association_GetMany */
  public DoctorTrT getDoctorTrT(int index)
  {
    DoctorTrT aDoctorTrT = doctorTrTs.get(index);
    return aDoctorTrT;
  }

  public List<DoctorTrT> getDoctorTrTs()
  {
    List<DoctorTrT> newDoctorTrTs = Collections.unmodifiableList(doctorTrTs);
    return newDoctorTrTs;
  }

  public int numberOfDoctorTrTs()
  {
    int number = doctorTrTs.size();
    return number;
  }

  public boolean hasDoctorTrTs()
  {
    boolean has = doctorTrTs.size() > 0;
    return has;
  }

  public int indexOfDoctorTrT(DoctorTrT aDoctorTrT)
  {
    int index = doctorTrTs.indexOf(aDoctorTrT);
    return index;
  }
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
  public static int minimumNumberOfPrescriptions()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Prescription addPrescription()
  {
    return new Prescription(this);
  }

  public boolean addPrescription(Prescription aPrescription)
  {
    boolean wasAdded = false;
    if (prescriptions.contains(aPrescription)) { return false; }
    PatientTrT existingPatientTrT = aPrescription.getPatientTrT();
    boolean isNewPatientTrT = existingPatientTrT != null && !this.equals(existingPatientTrT);
    if (isNewPatientTrT)
    {
      aPrescription.setPatientTrT(this);
    }
    else
    {
      prescriptions.add(aPrescription);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePrescription(Prescription aPrescription)
  {
    boolean wasRemoved = false;
    //Unable to remove aPrescription, as it must always have a patientTrT
    if (!this.equals(aPrescription.getPatientTrT()))
    {
      prescriptions.remove(aPrescription);
      wasRemoved = true;
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
  /* Code from template association_AddManyToOne */
  public Treatment addTreatment()
  {
    return new Treatment(this);
  }

  public boolean addTreatment(Treatment aTreatment)
  {
    boolean wasAdded = false;
    if (treatments.contains(aTreatment)) { return false; }
    PatientTrT existingPatientTrT = aTreatment.getPatientTrT();
    boolean isNewPatientTrT = existingPatientTrT != null && !this.equals(existingPatientTrT);
    if (isNewPatientTrT)
    {
      aTreatment.setPatientTrT(this);
    }
    else
    {
      treatments.add(aTreatment);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTreatment(Treatment aTreatment)
  {
    boolean wasRemoved = false;
    //Unable to remove aTreatment, as it must always have a patientTrT
    if (!this.equals(aTreatment.getPatientTrT()))
    {
      treatments.remove(aTreatment);
      wasRemoved = true;
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
  public static int minimumNumberOfDoctorTrTs()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDoctorTrT(DoctorTrT aDoctorTrT)
  {
    boolean wasAdded = false;
    if (doctorTrTs.contains(aDoctorTrT)) { return false; }
    doctorTrTs.add(aDoctorTrT);
    if (aDoctorTrT.indexOfPatientTrT(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDoctorTrT.addPatientTrT(this);
      if (!wasAdded)
      {
        doctorTrTs.remove(aDoctorTrT);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDoctorTrT(DoctorTrT aDoctorTrT)
  {
    boolean wasRemoved = false;
    if (!doctorTrTs.contains(aDoctorTrT))
    {
      return wasRemoved;
    }

    int oldIndex = doctorTrTs.indexOf(aDoctorTrT);
    doctorTrTs.remove(oldIndex);
    if (aDoctorTrT.indexOfPatientTrT(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDoctorTrT.removePatientTrT(this);
      if (!wasRemoved)
      {
        doctorTrTs.add(oldIndex,aDoctorTrT);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDoctorTrTAt(DoctorTrT aDoctorTrT, int index)
  {  
    boolean wasAdded = false;
    if(addDoctorTrT(aDoctorTrT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorTrTs()) { index = numberOfDoctorTrTs() - 1; }
      doctorTrTs.remove(aDoctorTrT);
      doctorTrTs.add(index, aDoctorTrT);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDoctorTrTAt(DoctorTrT aDoctorTrT, int index)
  {
    boolean wasAdded = false;
    if(doctorTrTs.contains(aDoctorTrT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorTrTs()) { index = numberOfDoctorTrTs() - 1; }
      doctorTrTs.remove(aDoctorTrT);
      doctorTrTs.add(index, aDoctorTrT);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDoctorTrTAt(aDoctorTrT, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfExaminations()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Examination addExamination(DoctorTrT aDoctorTrT)
  {
    return new Examination(this, aDoctorTrT);
  }

  public boolean addExamination(Examination aExamination)
  {
    boolean wasAdded = false;
    if (examinations.contains(aExamination)) { return false; }
    PatientTrT existingPatientTrT = aExamination.getPatientTrT();
    boolean isNewPatientTrT = existingPatientTrT != null && !this.equals(existingPatientTrT);
    if (isNewPatientTrT)
    {
      aExamination.setPatientTrT(this);
    }
    else
    {
      examinations.add(aExamination);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeExamination(Examination aExamination)
  {
    boolean wasRemoved = false;
    //Unable to remove aExamination, as it must always have a patientTrT
    if (!this.equals(aExamination.getPatientTrT()))
    {
      examinations.remove(aExamination);
      wasRemoved = true;
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
  public static int minimumNumberOfDiagnosis()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Diagnosis addDiagnosi()
  {
    return new Diagnosis(this);
  }

  public boolean addDiagnosi(Diagnosis aDiagnosi)
  {
    boolean wasAdded = false;
    if (diagnosis.contains(aDiagnosi)) { return false; }
    PatientTrT existingPatientTrT = aDiagnosi.getPatientTrT();
    boolean isNewPatientTrT = existingPatientTrT != null && !this.equals(existingPatientTrT);
    if (isNewPatientTrT)
    {
      aDiagnosi.setPatientTrT(this);
    }
    else
    {
      diagnosis.add(aDiagnosi);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDiagnosi(Diagnosis aDiagnosi)
  {
    boolean wasRemoved = false;
    //Unable to remove aDiagnosi, as it must always have a patientTrT
    if (!this.equals(aDiagnosi.getPatientTrT()))
    {
      diagnosis.remove(aDiagnosi);
      wasRemoved = true;
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
    for(int i=prescriptions.size(); i > 0; i--)
    {
      Prescription aPrescription = prescriptions.get(i - 1);
      aPrescription.delete();
    }
    for(int i=treatments.size(); i > 0; i--)
    {
      Treatment aTreatment = treatments.get(i - 1);
      aTreatment.delete();
    }
    ArrayList<DoctorTrT> copyOfDoctorTrTs = new ArrayList<DoctorTrT>(doctorTrTs);
    doctorTrTs.clear();
    for(DoctorTrT aDoctorTrT : copyOfDoctorTrTs)
    {
      aDoctorTrT.removePatientTrT(this);
    }
    for(int i=examinations.size(); i > 0; i--)
    {
      Examination aExamination = examinations.get(i - 1);
      aExamination.delete();
    }
    for(int i=diagnosis.size(); i > 0; i--)
    {
      Diagnosis aDiagnosi = diagnosis.get(i - 1);
      aDiagnosi.delete();
    }
  }

}