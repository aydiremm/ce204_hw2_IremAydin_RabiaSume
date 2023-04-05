/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.util.*;
import java.sql.Date;

// line 66 "../../model.ump"
// line 169 "../../model.ump"
public class OperationsStaff extends Staff {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// OperationsStaff Associations
	private List<Patient> patients;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * @brief Constructs an OperationsStaff object with the given parameters.
	 * 
	 * @param aTitle         The staff member's title.
	 * @param aGivenName     The staff member's given name.
	 * @param aMiddleName    The staff member's middle name.
	 * @param aFamilyName    The staff member's family name.
	 * @param aBirthDate     The staff member's birth date.
	 * @param aGender        The staff member's gender.
	 * @param aHomeAddress   The staff member's home address.
	 * @param aPhone         The staff member's phone number.
	 * @param aJoined        The date when the staff member joined the department.
	 * @param aEducation     The staff member's education.
	 * @param aCertification The staff member's certification.
	 * @param aLanguages     The staff member's languages.
	 * @param aDepartment    The department to which the staff member belongs.
	 */
	public OperationsStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification,
			String aLanguages, Department aDepartment) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aJoined,
				aEducation, aCertification, aLanguages, aDepartment);
		patients = new ArrayList<Patient>();
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/* Code from template association_GetMany */
	/**
	 * @brief Returns the patient at the specified index in the list of patients.
	 * 
	 * @param index The index of the patient to retrieve.
	 * @return The patient at the specified index.
	 */
	public Patient getPatient(int index) {
		Patient aPatient = patients.get(index);
		return aPatient;
	}

	/**
	 * @brief Returns an unmodifiable list of all patients managed by this staff
	 *        member.
	 * 
	 * @return An unmodifiable list of all patients managed by this staff member.
	 */

	public List<Patient> getPatients() {
		List<Patient> newPatients = Collections.unmodifiableList(patients);
		return newPatients;
	}

	/**
	 * @brief Returns the number of patients managed by this staff member.
	 * 
	 * @return The number of patients managed by this staff member.
	 */

	public int numberOfPatients() {
		int number = patients.size();
		return number;
	}

	/**
	 * @brief Returns true if this staff member is currently managing patients,
	 *        false otherwise.
	 * 
	 * @return True if this staff member is currently managing patients, false
	 *         otherwise.
	 */

	public boolean hasPatients() {
		boolean has = patients.size() > 0;
		return has;
	}

	/**
	 * 
	 * Returns the index of the specified Patient object in the "patients" list.
	 * 
	 * @param aPatient The Patient object to search for in the "patients" list.
	 * @return The index of the specified Patient object, or -1 if it is not found.
	 */

	public int indexOfPatient(Patient aPatient) {
		int index = patients.indexOf(aPatient);
		return index;
	}

	/* Code from template association_MinimumNumberOfMethod */
	/**
	 * 
	 * Returns the minimum number of Patients allowed to be associated with this
	 * OperationsStaff object.
	 * 
	 * @return The minimum number of Patients (0 in this case).
	 */
	public static int minimumNumberOfPatients() {
		return 0;
	}

	/* Code from template association_AddManyToManyMethod */
	/**
	 * 
	 * Adds the specified Patient object to the "patients" list and creates a
	 * many-to-many association between the OperationsStaff and the Patient.
	 * 
	 * @param aPatient The Patient object to be added to the "patients" list.
	 * @return True if the Patient was successfully added to the "patients" list,
	 *         false if it is already present.
	 */
	public boolean addPatient(Patient aPatient) {
		boolean wasAdded = false;
		if (patients.contains(aPatient)) {
			return false;
		}
		patients.add(aPatient);
		if (aPatient.indexOfOperationsStaff(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aPatient.addOperationsStaff(this);
			if (!wasAdded) {
				patients.remove(aPatient);
			}
		}
		return wasAdded;
	}
	/* Code from template association_RemoveMany */

	/**
	 * 
	 * Removes the specified Patient object from the "patients" list and removes the
	 * many-to-many association between the OperationsStaff and the Patient.
	 * 
	 * @param aPatient The Patient object to be removed from the "patients" list.
	 * @return True if the Patient was successfully removed from the "patients" list
	 *         and the association was removed, false otherwise.
	 */
	public boolean removePatient(Patient aPatient) {
		boolean wasRemoved = false;
		if (!patients.contains(aPatient)) {
			return wasRemoved;
		}

		int oldIndex = patients.indexOf(aPatient);
		patients.remove(oldIndex);
		if (aPatient.indexOfOperationsStaff(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aPatient.removeOperationsStaff(this);
			if (!wasRemoved) {
				patients.add(oldIndex, aPatient);
			}
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * Inserts a new patient at the specified index in the patient list.
	 *
	 * @param aPatient The patient object to be inserted.
	 * @param index    The index at which to insert the patient.
	 * @return True if the patient was successfully inserted; false otherwise.
	 */

	public boolean addPatientAt(Patient aPatient, int index) {
		boolean wasAdded = false;
		if (addPatient(aPatient)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfPatients()) {
				index = numberOfPatients() - 1;
			}
			patients.remove(aPatient);
			patients.add(index, aPatient);
			wasAdded = true;
		}
		return wasAdded;
	}

	/**
	 * Adds the given patient to the patient list at the specified index, or moves
	 * it to that index if it already exists in the list.
	 *
	 * @param aPatient The patient to be added or moved.
	 * @param index    The index at which to insert the patient.
	 * @return True if the patient was successfully added or moved; false otherwise.
	 */
	public boolean addOrMovePatientAt(Patient aPatient, int index) {
		boolean wasAdded = false;
		if (patients.contains(aPatient)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfPatients()) {
				index = numberOfPatients() - 1;
			}
			patients.remove(aPatient);
			patients.add(index, aPatient);
			wasAdded = true;
		} else {
			wasAdded = addPatientAt(aPatient, index);
		}
		return wasAdded;
	}

	/**
	 * Deletes this OperationsStaff object and removes it from all associated
	 * Patient objects.
	 */
	public void delete() {
		ArrayList<Patient> copyOfPatients = new ArrayList<Patient>(patients);
		patients.clear();
		for (Patient aPatient : copyOfPatients) {
			aPatient.removeOperationsStaff(this);
		}
		super.delete();
	}

}