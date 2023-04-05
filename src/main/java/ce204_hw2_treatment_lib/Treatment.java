/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_treatment_lib;
import java.util.*;

// line 37 "../../model.ump"
// line 72 "../../model.ump"
public class Treatment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Treatment Associations
  private PatientTrT patientTrT;
  private List<DoctorTrT> doctorTrTs;
  private List<Diagnosis> diagnosis;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Treatment(PatientTrT aPatientTrT)
  {
    boolean didAddPatientTrT = setPatientTrT(aPatientTrT);
    if (!didAddPatientTrT)
    {
      throw new RuntimeException("Unable to create treatment due to patientTrT. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    doctorTrTs = new ArrayList<DoctorTrT>();
    diagnosis = new ArrayList<Diagnosis>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public PatientTrT getPatientTrT()
  {
    return patientTrT;
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
  /* Code from template association_SetOneToMany */
  public boolean setPatientTrT(PatientTrT aPatientTrT)
  {
    boolean wasSet = false;
    if (aPatientTrT == null)
    {
      return wasSet;
    }

    PatientTrT existingPatientTrT = patientTrT;
    patientTrT = aPatientTrT;
    if (existingPatientTrT != null && !existingPatientTrT.equals(aPatientTrT))
    {
      existingPatientTrT.removeTreatment(this);
    }
    patientTrT.addTreatment(this);
    wasSet = true;
    return wasSet;
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
    if (aDoctorTrT.indexOfTreatment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDoctorTrT.addTreatment(this);
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
    if (aDoctorTrT.indexOfTreatment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDoctorTrT.removeTreatment(this);
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
    if (aDiagnosi.indexOfTreatment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDiagnosi.addTreatment(this);
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
    if (aDiagnosi.indexOfTreatment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDiagnosi.removeTreatment(this);
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
    PatientTrT placeholderPatientTrT = patientTrT;
    this.patientTrT = null;
    if(placeholderPatientTrT != null)
    {
      placeholderPatientTrT.removeTreatment(this);
    }
    ArrayList<DoctorTrT> copyOfDoctorTrTs = new ArrayList<DoctorTrT>(doctorTrTs);
    doctorTrTs.clear();
    for(DoctorTrT aDoctorTrT : copyOfDoctorTrTs)
    {
      aDoctorTrT.removeTreatment(this);
    }
    ArrayList<Diagnosis> copyOfDiagnosis = new ArrayList<Diagnosis>(diagnosis);
    diagnosis.clear();
    for(Diagnosis aDiagnosi : copyOfDiagnosis)
    {
      aDiagnosi.removeTreatment(this);
    }
  }

}