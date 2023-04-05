/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.util.*;
import java.sql.Date;

// line 46 "../../model.ump"
// line 158 "../../model.ump"
public class Patient extends Person {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Patient Attributes
	private String id;
	private int age;
	private String accepted;
	private String sickness;
	private String prescriptions;
	private String allergies;
	private String specialReqs;

	// Patient Associations
	private List<OperationsStaff> operationsStaffs;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
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

	public Patient(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, String aId, int aAge, String aAccepted,
			String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone);
		id = aId;
		age = aAge;
		accepted = aAccepted;
		sickness = aSickness;
		prescriptions = aPrescriptions;
		allergies = aAllergies;
		specialReqs = aSpecialReqs;
		operationsStaffs = new ArrayList<OperationsStaff>();
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/**
	 * 
	 * Sets the ID of the patient.
	 * 
	 * @param aId the new ID of the patient
	 * @return true if the ID was successfully set
	 */
	public boolean setId(String aId) {
		boolean wasSet = false;
		id = aId;
		wasSet = true;
		return wasSet;
	}

	/**
	 * 
	 * Sets the age of the patient.
	 * 
	 * @param aAge the new age of the patient
	 * @return true if the age was successfully set
	 */
	public boolean setAge(int aAge) {
		boolean wasSet = false;
		age = aAge;
		wasSet = true;
		return wasSet;
	}

	/**
	 * 
	 * Sets the acceptance status of the patient.
	 * 
	 * @param aAccepted the new acceptance status of the patient
	 * @return true if the acceptance status was successfully set
	 */
	public boolean setAccepted(String aAccepted) {
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

	public boolean setSickness(String aSickness) {
		boolean wasSet = false;
		sickness = aSickness;
		wasSet = true;
		return wasSet;
	}

	/**
	 * 
	 * Sets the prescriptions of the patient.
	 * 
	 * @param aPrescriptions the new prescriptions of the patient
	 * @return true if the prescriptions were successfully set
	 */

	public boolean setPrescriptions(String aPrescriptions) {
		boolean wasSet = false;
		prescriptions = aPrescriptions;
		wasSet = true;
		return wasSet;
	}

	/**
	 * 
	 * Sets the allergies of the patient.
	 * 
	 * @param aAllergies the new allergies of the patient
	 * @return true if the allergies were successfully set
	 */
	public boolean setAllergies(String aAllergies) {
		boolean wasSet = false;
		allergies = aAllergies;
		wasSet = true;
		return wasSet;
	}

	/**
	 * 
	 * Sets the special requirements of the patient.
	 * 
	 * @param aSpecialReqs the new special requirements of the patient
	 * @return true if the special requirements were successfully set
	 */
	public boolean setSpecialReqs(String aSpecialReqs) {
		boolean wasSet = false;
		specialReqs = aSpecialReqs;
		wasSet = true;
		return wasSet;
	}

	/**
	 * 
	 * Gets the ID of the patient.
	 * 
	 * @return the ID of the patient
	 */

	public String getId() {
		return id;
	}

	/**
	 * 
	 * Gets the age of the patient.
	 * 
	 * @return the age of the patient
	 */

	public int getAge() {
		return age;
	}

	/**
	 * 
	 * Gets the acceptance status of the patient.
	 * 
	 * @return the acceptance status of the patient
	 */

	public String getAccepted() {
		return accepted;
	}

	/**
	 * 
	 * Gets the sickness of the patient.
	 * 
	 * @return the sickness of the patient
	 */

	public String getSickness() {
		return sickness;
	}

	/**
	 * 
	 * Gets the prescriptions of the patient.
	 * 
	 * @return the prescriptions of the patient
	 */

	public String getPrescriptions() {
		return prescriptions;
	}

	/**
	 * 
	 * Gets the allergies of the patient.
	 * 
	 * @return the allergies of the patient
	 */

	public String getAllergies() {
		return allergies;
	}

	/**
	 * 
	 * Gets the special requirements of the patient.
	 * 
	 * @return the special requirements of the patient
	 */

	public String getSpecialReqs() {
		return specialReqs;
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
	public OperationsStaff getOperationsStaff(int index) {
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

	public List<OperationsStaff> getOperationsStaffs() {
		List<OperationsStaff> newOperationsStaffs = Collections.unmodifiableList(operationsStaffs);
		return newOperationsStaffs;
	}

	public int numberOfOperationsStaffs() {
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

	public boolean hasOperationsStaffs() {
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

	public int indexOfOperationsStaff(OperationsStaff aOperationsStaff) {
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
	public static int minimumNumberOfOperationsStaffs() {
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
	public boolean addOperationsStaff(OperationsStaff aOperationsStaff) {
		boolean wasAdded = false;
		if (operationsStaffs.contains(aOperationsStaff)) {
			return false;
		}
		operationsStaffs.add(aOperationsStaff);
		if (aOperationsStaff.indexOfPatient(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aOperationsStaff.addPatient(this);
			if (!wasAdded) {
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
	public boolean removeOperationsStaff(OperationsStaff aOperationsStaff) {
		boolean wasRemoved = false;
		if (!operationsStaffs.contains(aOperationsStaff)) {
			return wasRemoved;
		}

		int oldIndex = operationsStaffs.indexOf(aOperationsStaff);
		operationsStaffs.remove(oldIndex);
		if (aOperationsStaff.indexOfPatient(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aOperationsStaff.removePatient(this);
			if (!wasRemoved) {
				operationsStaffs.add(oldIndex, aOperationsStaff);
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
	public boolean addOperationsStaffAt(OperationsStaff aOperationsStaff, int index) {
		boolean wasAdded = false;
		if (addOperationsStaff(aOperationsStaff)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfOperationsStaffs()) {
				index = numberOfOperationsStaffs() - 1;
			}
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

	public boolean addOrMoveOperationsStaffAt(OperationsStaff aOperationsStaff, int index) {
		boolean wasAdded = false;
		if (operationsStaffs.contains(aOperationsStaff)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfOperationsStaffs()) {
				index = numberOfOperationsStaffs() - 1;
			}
			operationsStaffs.remove(aOperationsStaff);
			operationsStaffs.add(index, aOperationsStaff);
			wasAdded = true;
		} else {
			wasAdded = addOperationsStaffAt(aOperationsStaff, index);
		}
		return wasAdded;
	}

	/**
	 * Removes this Patient object from the system by removing all references to it
	 * in the list of OperationsStaff objects that have this Patient object
	 * associated with them, and then calling the delete method of the superclass.
	 */

	public void delete() {
		ArrayList<OperationsStaff> copyOfOperationsStaffs = new ArrayList<OperationsStaff>(operationsStaffs);
		operationsStaffs.clear();
		for (OperationsStaff aOperationsStaff : copyOfOperationsStaffs) {
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

	public String toString() {
		return super.toString() + "[" + "id" + ":" + getId() + "," + "age" + ":" + getAge() + "," + "accepted" + ":"
				+ getAccepted() + "," + "sickness" + ":" + getSickness() + "," + "prescriptions" + ":"
				+ getPrescriptions() + "," + "allergies" + ":" + getAllergies() + "," + "specialReqs" + ":"
				+ getSpecialReqs() + "]";
	}
}