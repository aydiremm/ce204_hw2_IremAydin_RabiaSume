//PLEASE DO NOT EDIT THIS CODE/

//This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!/
/**

@file DoctorWT.java
@brief This file contains the implementation of the DoctorWT class, which extends the Doctor class.
The DoctorWT class represents a doctor who works in a ward/team and has a specialty, locations, and treats one or more patients.
It has attributes such as specialty, locations, and a list of patients that are treated by the doctor.
It also has an association with the Team class.
*/

package ce204_hw2_wards_and_teams_lib;

import java.sql.Date;
import java.util.*;
import ce204_hw2_organization_lib.*;
import ce204_hw2_organization_lib.Address;
import ce204_hw2_organization_lib.Phone;

// line 66 "../../model.ump"
// line 148 "../../model.ump"
// line 153 "../../model.ump"
public class DoctorWT extends Doctor {

	public DoctorWT(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification,
			String aLanguages, Department aDepartment, String aSpecialty, String aLocations) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined,
				aEducation, aCertification, aLanguages, aDepartment, aSpecialty, aLocations);
		// TODO Auto-generated constructor stub
		specialty = aSpecialty;
		locations = aLocations;
		treats = new ArrayList<PatientWT>();
	}

//------------------------
	// MEMBER VARIABLES
	// ------------------------

	// DoctorWT Attributes
	private String specialty;
	private String locations;

	// DoctorWT Associations
	private List<PatientWT> treats;
	private Team team;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	// ------------------------
	// INTERFACE
	// ------------------------

	public boolean setSpecialty(String aSpecialty) {
		boolean wasSet = false;
		specialty = aSpecialty;
		wasSet = true;
		return wasSet;
	}

	public boolean setLocations(String aLocations) {
		boolean wasSet = false;
		locations = aLocations;
		wasSet = true;
		return wasSet;
	}

	public String getSpecialty() {
		return specialty;
	}

	public String getLocations() {
		return locations;
	}

	/* Code from template association_GetMany */
	public PatientWT getTreat(int index) {
		PatientWT aTreat = treats.get(index);
		return aTreat;
	}

	public List<PatientWT> getTreats() {
		List<PatientWT> newTreats = Collections.unmodifiableList(treats);
		return newTreats;
	}

	public int numberOfTreats() {
		int number = treats.size();
		return number;
	}

	public boolean hasTreats() {
		boolean has = treats.size() > 0;
		return has;
	}

	public int indexOfTreat(PatientWT aTreat) {
		int index = treats.indexOf(aTreat);
		return index;
	}

	/* Code from template association_GetOne */
	public Team getTeam() {
		return team;
	}

	public boolean hasTeam() {
		boolean has = team != null;
		return has;
	}

	/* Code from template association_MinimumNumberOfMethod */
	/**
	 * 
	 * @brief Returns the minimum number of treats.
	 * @return An integer representing the minimum number of treats.
	 */
	public static int minimumNumberOfTreats() {
		return 0;
	}

	/* Code from template association_AddManyToManyMethod */
	/**
	 * 
	 * @brief Adds a treat to the doctor's list of treats.
	 * @param aTreat A PatientWT object representing the treat to add.
	 * @return A boolean value indicating whether the treat was added.
	 */
	public boolean addTreat(PatientWT aTreat) {
		boolean wasAdded = false;
		if (treats.contains(aTreat)) {
			return false;
		}
		treats.add(aTreat);
		if (aTreat.indexOfDoctorWT(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aTreat.addDoctorWT(this);
			if (!wasAdded) {
				treats.remove(aTreat);
			}
		}
		return wasAdded;
	}

	/* Code from template association_RemoveMany */
	/**
	 * 
	 * @brief Removes a treat from the doctor's list of treats.
	 * @param aTreat A PatientWT object representing the treat to remove.
	 * @return A boolean value indicating whether the treat was removed.
	 */
	public boolean removeTreat(PatientWT aTreat) {
		boolean wasRemoved = false;
		if (!treats.contains(aTreat)) {
			return wasRemoved;
		}

		int oldIndex = treats.indexOf(aTreat);
		treats.remove(oldIndex);
		if (aTreat.indexOfDoctorWT(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aTreat.removeDoctorWT(this);
			if (!wasRemoved) {
				treats.add(oldIndex, aTreat);
			}
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * 
	 * @brief Adds a treat to the doctor's list of treats at the specified index.
	 * @param aTreat A PatientWT object representing the treat to add.
	 * @param index  An integer representing the index at which to add the treat.
	 * @return A boolean value indicating whether the treat was added.
	 */
	public boolean addTreatAt(PatientWT aTreat, int index) {
		boolean wasAdded = false;
		if (addTreat(aTreat)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfTreats()) {
				index = numberOfTreats() - 1;
			}
			treats.remove(aTreat);
			treats.add(index, aTreat);
			wasAdded = true;
		}
		return wasAdded;
	}

	/**
	 * 
	 * @brief Adds or moves a treat to the doctor's list of treats at the specified
	 *        index.
	 * @param aTreat A PatientWT object representing the treat to add or move.
	 * @param index  An integer representing the index at which to add or move the
	 *               treat.
	 * @return A boolean value indicating whether the treat was added or moved.
	 */
	public boolean addOrMoveTreatAt(PatientWT aTreat, int index) {
		boolean wasAdded = false;
		if (treats.contains(aTreat)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfTreats()) {
				index = numberOfTreats() - 1;
			}
			treats.remove(aTreat);
			treats.add(index, aTreat);
			wasAdded = true;
		} else {
			wasAdded = addTreatAt(aTreat, index);
		}
		return wasAdded;
	}

	/* Code from template association_SetOptionalOneToMany */
	public boolean setTeam(Team aTeam) {
		boolean wasSet = false;
		Team existingTeam = team;
		team = aTeam;
		if (existingTeam != null && !existingTeam.equals(aTeam)) {
			existingTeam.removeDoctorWT(this);
		}
		if (aTeam != null) {
			aTeam.addDoctorWT(this);
		}
		wasSet = true;
		return wasSet;
	}

	public void delete() {
		ArrayList<PatientWT> copyOfTreats = new ArrayList<PatientWT>(treats);
		treats.clear();
		for (PatientWT aTreat : copyOfTreats) {
			aTreat.removeDoctorWT(this);
		}
		if (team != null) {
			Team placeholderTeam = team;
			this.team = null;
			placeholderTeam.removeDoctorWT(this);
		}
	}

	public String toString() {
		return super.toString() + "[" + "specialty" + ":" + getSpecialty() + "," + "locations" + ":" + getLocations()
				+ "]" + System.getProperties().getProperty("line.separator") + "  " + "team = "
				+ (getTeam() != null ? Integer.toHexString(System.identityHashCode(getTeam())) : "null");
	}
}