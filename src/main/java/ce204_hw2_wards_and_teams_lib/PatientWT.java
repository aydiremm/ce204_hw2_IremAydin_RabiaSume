/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_wards_and_teams_lib;
import java.util.*;
import ce204_hw2_organization_lib.*;
import ce204_hw2_organization_lib.Address;
import ce204_hw2_organization_lib.History;
import ce204_hw2_organization_lib.Phone;

import java.sql.Date;

// line 43 "../../model.ump"
// line 97 "../../model.ump"
// line 132 "../../model.ump"
public class PatientWT extends Patient
{




public PatientWT(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, String aId, int aAge, String aAccepted,
			String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs,Team aTeam,Ward aWard) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aId, aAge, aAccepted,
				aSickness, aPrescriptions, aAllergies, aSpecialReqs);
		// TODO Auto-generated constructor stub
		gender = aGender;
	    birthDate = aBirthDate;
	    accepted = aAccepted;
	    sickness = aSickness;

	    if (!setId(aId))
	    {
	      throw new RuntimeException("Cannot create due to duplicate id. See http://manual.umple.org?RE003ViolationofUniqueness.html");
	    }
	    boolean didAddTeam = setTeam(aTeam);
	    if (!didAddTeam)
	    {
	      throw new RuntimeException("Unable to create patientWT due to team. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
	    }
	    doctorWTs = new ArrayList<DoctorWT>();
	    boolean didAddConsultantDoctor = setConsultantDoctor(null);
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
  // ENUMERATIONS
  //------------------------

  public enum Gender { Male, Female }

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, PatientWT> patientwtsById = new HashMap<String, PatientWT>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PatientWT Attributes
  private String id;
  private String gender;
  private Date birthDate;
  private String accepted;
  private String sickness;
  private String prescriptions;
  private String allergies;
  private String specialReqs;

  //PatientWT Associations
  private Team team;
  private List<DoctorWT> doctorWTs;
  private ConsultantDoctor consultantDoctor;
  private Ward ward;

  //------------------------
  // CONSTRUCTOR
  //------------------------


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
      patientwtsById.remove(anOldId);
    }
    patientwtsById.put(aId, this);
    return wasSet;
  }

  public boolean setGender(String aGender)
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

  public boolean setAccepted(String aAccepted)
  {
    boolean wasSet = false;
    accepted = aAccepted;
    wasSet = true;
    return wasSet;
  }

  public boolean setSickness(String aSickness)
  {
    boolean wasSet = false;
    sickness = aSickness;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrescriptions(String aPrescriptions)
  {
    boolean wasSet = false;
    prescriptions = aPrescriptions;
    wasSet = true;
    return wasSet;
  }

  public boolean setAllergies(String aAllergies)
  {
    boolean wasSet = false;
    allergies = aAllergies;
    wasSet = true;
    return wasSet;
  }

  public boolean setSpecialReqs(String aSpecialReqs)
  {
    boolean wasSet = false;
    specialReqs = aSpecialReqs;
    wasSet = true;
    return wasSet;
  }

  public String getId()
  {
    return id;
  }
  /* Code from template attribute_GetUnique */
  public static PatientWT getWithId(String aId)
  {
    return patientwtsById.get(aId);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithId(String aId)
  {
    return getWithId(aId) != null;
  }

  public String getGender()
  {
    return gender;
  }

  public Date getBirthDate()
  {
    return birthDate;
  }

  public int getAge()
  {
    return new Date(System.currentTimeMillis()).getYear() - birthDate.getYear();
  }

  public String getAccepted()
  {
    return accepted;
  }

  public String getSickness()
  {
    return sickness;
  }

  public String getPrescriptions()
  {
    return prescriptions;
  }

  public String getAllergies()
  {
    return allergies;
  }

  public String getSpecialReqs()
  {
    return specialReqs;
  }
  /* Code from template association_GetOne */
  public Team getTeam()
  {
    return team;
  }
  /* Code from template association_GetMany */
  public DoctorWT getDoctorWT(int index)
  {
    DoctorWT aDoctorWT = doctorWTs.get(index);
    return aDoctorWT;
  }

  public List<DoctorWT> getDoctorWTs()
  {
    List<DoctorWT> newDoctorWTs = Collections.unmodifiableList(doctorWTs);
    return newDoctorWTs;
  }

  public int numberOfDoctorWTs()
  {
    int number = doctorWTs.size();
    return number;
  }

  public boolean hasDoctorWTs()
  {
    boolean has = doctorWTs.size() > 0;
    return has;
  }

  public int indexOfDoctorWT(DoctorWT aDoctorWT)
  {
    int index = doctorWTs.indexOf(aDoctorWT);
    return index;
  }
  /* Code from template association_GetOne */
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
      existingTeam.removePatientWT(this);
    }
    team.addPatientWT(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDoctorWTs()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addDoctorWT(DoctorWT aDoctorWT)
  {
    boolean wasAdded = false;
    if (doctorWTs.contains(aDoctorWT)) { return false; }
    doctorWTs.add(aDoctorWT);
    if (aDoctorWT.indexOfTreat(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aDoctorWT.addTreat(this);
      if (!wasAdded)
      {
        doctorWTs.remove(aDoctorWT);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeDoctorWT(DoctorWT aDoctorWT)
  {
    boolean wasRemoved = false;
    if (!doctorWTs.contains(aDoctorWT))
    {
      return wasRemoved;
    }

    int oldIndex = doctorWTs.indexOf(aDoctorWT);
    doctorWTs.remove(oldIndex);
    if (aDoctorWT.indexOfTreat(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aDoctorWT.removeTreat(this);
      if (!wasRemoved)
      {
        doctorWTs.add(oldIndex,aDoctorWT);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDoctorWTAt(DoctorWT aDoctorWT, int index)
  {  
    boolean wasAdded = false;
    if(addDoctorWT(aDoctorWT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorWTs()) { index = numberOfDoctorWTs() - 1; }
      doctorWTs.remove(aDoctorWT);
      doctorWTs.add(index, aDoctorWT);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDoctorWTAt(DoctorWT aDoctorWT, int index)
  {
    boolean wasAdded = false;
    if(doctorWTs.contains(aDoctorWT))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDoctorWTs()) { index = numberOfDoctorWTs() - 1; }
      doctorWTs.remove(aDoctorWT);
      doctorWTs.add(index, aDoctorWT);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDoctorWTAt(aDoctorWT, index);
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
    patientwtsById.remove(getId());
    Team placeholderTeam = team;
    this.team = null;
    if(placeholderTeam != null)
    {
      placeholderTeam.removePatientWT(this);
    }
    ArrayList<DoctorWT> copyOfDoctorWTs = new ArrayList<DoctorWT>(doctorWTs);
    doctorWTs.clear();
    for(DoctorWT aDoctorWT : copyOfDoctorWTs)
    {
      aDoctorWT.removeTreat(this);
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
            "gender" + ":" + getGender()+ "," +
            "age" + ":" + getAge()+ "," +
            "sickness" + ":" + getSickness()+ "," +
            "prescriptions" + ":" + getPrescriptions()+ "," +
            "allergies" + ":" + getAllergies()+ "," +
            "specialReqs" + ":" + getSpecialReqs()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "birthDate" + "=" + (getBirthDate() != null ? !getBirthDate().equals(this)  ? getBirthDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "accepted" + "=" + (getAccepted() != null ? !getAccepted().equals(this)  ? getAccepted().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "team = "+(getTeam()!=null?Integer.toHexString(System.identityHashCode(getTeam())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "consultantDoctor = "+(getConsultantDoctor()!=null?Integer.toHexString(System.identityHashCode(getConsultantDoctor())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "ward = "+(getWard()!=null?Integer.toHexString(System.identityHashCode(getWard())):"null");
  }
}