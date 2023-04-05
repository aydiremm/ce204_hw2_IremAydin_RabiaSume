/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_treatment_lib;

import java.util.*;

// line 32 "../../model.ump"
// line 66 "../../model.ump"
public class Prescription {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Prescription Associations
	private List<Therapy> therapies;
	private PatientTrT patientTrT;
	private List<DoctorTrT> doctorTrTs;
	private List<Diagnosis> diagnosis;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * 
	 * Constructs a new Prescription object with the given patient and initializes
	 * its therapies list to an empty list.
	 * 
	 * @param aPatientTrT the patient associated with this prescription
	 * @throws RuntimeException if unable to create the prescription due to a
	 *                          violation of the patientTrT association multiplicity
	 *                          constraint
	 */

	public Prescription(PatientTrT aPatientTrT) {
		therapies = new ArrayList<Therapy>();
		boolean didAddPatientTrT = setPatientTrT(aPatientTrT);
		if (!didAddPatientTrT) {
			throw new RuntimeException(
					"Unable to create prescription due to patientTrT. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
		doctorTrTs = new ArrayList<DoctorTrT>();
		diagnosis = new ArrayList<Diagnosis>();
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/* Code from template association_GetMany */
	/**
	 * 
	 * Returns the therapy at the specified index in the list of therapies.
	 * 
	 * @param index the index of the therapy to retrieve.
	 * @return the therapy at the specified index.
	 * @throws IndexOutOfBoundsException if the index is out of range.
	 */
	public Therapy getTherapy(int index) {
		Therapy aTherapy = therapies.get(index);
		return aTherapy;
	}

	/**
	 * 
	 * Returns an unmodifiable view of the list of therapies.
	 * 
	 * @return an unmodifiable view of the list of therapies.
	 */
	public List<Therapy> getTherapies() {
		List<Therapy> newTherapies = Collections.unmodifiableList(therapies);
		return newTherapies;
	}

	/**
	 * 
	 * Returns the number of therapies in the list.
	 * 
	 * @return the number of therapies in the list.
	 */
	public int numberOfTherapies() {
		int number = therapies.size();
		return number;
	}

	/**
	 * 
	 * Returns true if the list of therapies is not empty.
	 * 
	 * @return true if the list of therapies is not empty.
	 */
	public boolean hasTherapies() {
		boolean has = therapies.size() > 0;
		return has;
	}

	/**
	 * 
	 * Returns the index of the specified therapy in the list of therapies.
	 * 
	 * @param aTherapy the therapy to search for.
	 * @return the index of the specified therapy, or -1 if it is not in the list.
	 */

	public int indexOfTherapy(Therapy aTherapy) {
		int index = therapies.indexOf(aTherapy);
		return index;
	}

	/* Code from template association_GetOne */
	/**
	 * 
	 * Returns the patient associated with this prescription.
	 * 
	 * @return the patient associated with this prescription.
	 */
	public PatientTrT getPatientTrT() {
		return patientTrT;
	}

	/* Code from template association_GetMany */
	/**
	 * 
	 * Returns the doctor at the specified index in the list of doctors.
	 * 
	 * @param index the index of the doctor to retrieve.
	 * @return the doctor at the specified index.
	 * @throws IndexOutOfBoundsException if the index is out of range.
	 */
	public DoctorTrT getDoctorTrT(int index) {
		DoctorTrT aDoctorTrT = doctorTrTs.get(index);
		return aDoctorTrT;
	}

	/**
	 * 
	 * Returns an unmodifiable view of the list of doctors.
	 * 
	 * @return an unmodifiable view of the list of doctors.
	 */
	public List<DoctorTrT> getDoctorTrTs() {
		List<DoctorTrT> newDoctorTrTs = Collections.unmodifiableList(doctorTrTs);
		return newDoctorTrTs;
	}

	/**
	 * 
	 * Returns the number of doctors in the list.
	 * 
	 * @return the number of doctors in the list.
	 */

	public int numberOfDoctorTrTs() {
		int number = doctorTrTs.size();
		return number;
	}

	/**
	 * 
	 * Returns true if there is at least one DoctorTrT object in the list of
	 * doctorTrTs, false otherwise.
	 * 
	 * @return true if there is at least one DoctorTrT object in the list of
	 *         doctorTrTs, false otherwise.
	 */
	public boolean hasDoctorTrTs() {
		boolean has = doctorTrTs.size() > 0;
		return has;
	}

	/**
	 * 
	 * Returns the index of the given DoctorTrT object in the list of doctorTrTs, or
	 * -1 if it is not found.
	 * 
	 * @param aDoctorTrT the DoctorTrT object to search for in the list of
	 *                   doctorTrTs.
	 * @return the index of the given DoctorTrT object in the list of doctorTrTs, or
	 *         -1 if it is not found.
	 */
	public int indexOfDoctorTrT(DoctorTrT aDoctorTrT) {
		int index = doctorTrTs.indexOf(aDoctorTrT);
		return index;
	}

	/* Code from template association_GetMany */
	/**
	 * 
	 * Returns the Diagnosis object at the given index in the list of diagnosis.
	 * 
	 * @param index the index of the Diagnosis object to return.
	 * @return the Diagnosis object at the given index in the list of diagnosis.
	 */
	public Diagnosis getDiagnosi(int index) {
		Diagnosis aDiagnosi = diagnosis.get(index);
		return aDiagnosi;
	}

	/**
	 * 
	 * Returns an unmodifiable list of Diagnosis objects associated with this
	 * Prescription object.
	 * 
	 * @return an unmodifiable list of Diagnosis objects associated with this
	 *         Prescription object.
	 */

	public List<Diagnosis> getDiagnosis() {
		List<Diagnosis> newDiagnosis = Collections.unmodifiableList(diagnosis);
		return newDiagnosis;
	}

	/**
	 * 
	 * Returns the number of Diagnosis objects associated with this Prescription
	 * object.
	 * 
	 * @return the number of Diagnosis objects associated with this Prescription
	 *         object.
	 */

	public int numberOfDiagnosis() {
		int number = diagnosis.size();
		return number;
	}

	/**
	 * 
	 * Returns true if there is at least one Diagnosis object associated with this
	 * Prescription object, false otherwise.
	 * 
	 * @return true if there is at least one Diagnosis object associated with this
	 *         Prescription object, false otherwise.
	 */
	public boolean hasDiagnosis() {
		boolean has = diagnosis.size() > 0;
		return has;
	}

	/**
	 * 
	 * Returns the index of the given Diagnosis object in the list of diagnosis, or
	 * -1 if it is not found.
	 * 
	 * @param aDiagnosi the Diagnosis object to search for in the list of diagnosis.
	 * @return the index of the given Diagnosis object in the list of diagnosis, or
	 *         -1 if it is not found.
	 */
	public int indexOfDiagnosi(Diagnosis aDiagnosi) {
		int index = diagnosis.indexOf(aDiagnosi);
		return index;
	}

	/* Code from template association_MinimumNumberOfMethod */
	/**
	 * 
	 * Returns the minimum number of Therapy objects associated with a Prescription
	 * object (which is 0).
	 * 
	 * @return the minimum number of Therapy objects associated with a Prescription
	 *         object (which is 0).
	 */
	public static int minimumNumberOfTherapies() {
		return 0;
	}

	/* Code from template association_AddManyToOne */
	/**
	 * 
	 * Adds a Therapy object associated with this Prescription object and a given
	 * PatientTrT object.
	 * 
	 * @param aPatientTrT the PatientTrT object to associate with the new Therapy
	 *                    object.
	 * @return the newly created Therapy object.
	 */
	public Therapy addTherapy(PatientTrT aPatientTrT) {
		return new Therapy(aPatientTrT, this);
	}

	/**
	 * 
	 * Adds the given Therapy object to the list of therapies associated with this
	 * Prescription object.
	 * 
	 * @param aTherapy the Therapy object to add to the list of therapies associated
	 *                 with this Prescription object.
	 * @return true if the Therapy object was successfully added to the list of
	 *         therapies associated with this Prescription object, false otherwise.
	 */

	public boolean addTherapy(Therapy aTherapy) {
		boolean wasAdded = false;
		if (therapies.contains(aTherapy)) {
			return false;
		}
		Prescription existingPrescription = aTherapy.getPrescription();
		boolean isNewPrescription = existingPrescription != null && !this.equals(existingPrescription);
		if (isNewPrescription) {
			aTherapy.setPrescription(this);
		} else {
			therapies.add(aTherapy);
		}
		wasAdded = true;
		return wasAdded;
	}

	/**
	 * 
	 * Removes a therapy from the list of therapies associated with this
	 * prescription. The therapy can only be removed if it is not associated with
	 * any other prescription.
	 * 
	 * @param aTherapy the therapy to be removed from the list of therapies
	 * @return true if the therapy was removed, false otherwise
	 */

	public boolean removeTherapy(Therapy aTherapy) {
		boolean wasRemoved = false;
		// Unable to remove aTherapy, as it must always have a prescription
		if (!this.equals(aTherapy.getPrescription())) {
			therapies.remove(aTherapy);
			wasRemoved = true;
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * 
	 * Adds a therapy at a specified index in the list of therapies associated with
	 * this prescription. The therapy can only be added if it is not already
	 * associated with any other prescription.
	 * 
	 * @param aTherapy the therapy to be added to the list of therapies
	 * @param index    the index at which the therapy should be added
	 * @return true if the therapy was added at the specified index, false otherwise
	 */
	public boolean addTherapyAt(Therapy aTherapy, int index) {
		boolean wasAdded = false;
		if (addTherapy(aTherapy)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfTherapies()) {
				index = numberOfTherapies() - 1;
			}
			therapies.remove(aTherapy);
			therapies.add(index, aTherapy);
			wasAdded = true;
		}
		return wasAdded;
	}

	/**
	 * 
	 * Adds or moves a therapy to a specified index in the list of therapies
	 * associated with this prescription. The therapy can only be added or moved if
	 * it is not already associated with any other prescription.
	 * 
	 * @param aTherapy the therapy to be added or moved to the list of therapies
	 * @param index    the index at which the therapy should be added or moved
	 * @return true if the therapy was added or moved to the specified index, false
	 *         otherwise
	 */
	public boolean addOrMoveTherapyAt(Therapy aTherapy, int index) {
		boolean wasAdded = false;
		if (therapies.contains(aTherapy)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfTherapies()) {
				index = numberOfTherapies() - 1;
			}
			therapies.remove(aTherapy);
			therapies.add(index, aTherapy);
			wasAdded = true;
		} else {
			wasAdded = addTherapyAt(aTherapy, index);
		}
		return wasAdded;
	}

	/* Code from template association_SetOneToMany */
	/**
	 * 
	 * Sets the patient associated with this prescription to a given patient.
	 * 
	 * @param aPatientTrT the patient to be associated with this prescription
	 * @return true if the patient was successfully associated with this
	 *         prescription, false otherwise
	 */
	public boolean setPatientTrT(PatientTrT aPatientTrT) {
		boolean wasSet = false;
		if (aPatientTrT == null) {
			return wasSet;
		}

		PatientTrT existingPatientTrT = patientTrT;
		patientTrT = aPatientTrT;
		if (existingPatientTrT != null && !existingPatientTrT.equals(aPatientTrT)) {
			existingPatientTrT.removePrescription(this);
		}
		patientTrT.addPrescription(this);
		wasSet = true;
		return wasSet;
	}

	/* Code from template association_MinimumNumberOfMethod */
	/**
	 * 
	 * Returns the minimum number of doctor TrTs associated with a prescription.
	 * 
	 * @return the minimum number of doctor TrTs associated with a prescription
	 */
	public static int minimumNumberOfDoctorTrTs() {
		return 0;
	}

	/* Code from template association_AddManyToManyMethod */
	/**
	 * 
	 * Adds a doctor TrT to the list of doctor TrTs associated with this
	 * prescription. The doctor TrT can only be added if it is not already
	 * associated with this prescription.
	 * 
	 * @param aDoctorTrT the doctor TrT to be added to the list of doctor TrTs
	 * @return true if the doctor TrT was added to the list of doctor TrTs, false
	 *         otherwise
	 */
	public boolean addDoctorTrT(DoctorTrT aDoctorTrT) {
		boolean wasAdded = false;
		if (doctorTrTs.contains(aDoctorTrT)) {
			return false;
		}
		doctorTrTs.add(aDoctorTrT);
		if (aDoctorTrT.indexOfPrescription(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aDoctorTrT.addPrescription(this);
			if (!wasAdded) {
				doctorTrTs.remove(aDoctorTrT);
			}
		}
		return wasAdded;
	}

	/* Code from template association_RemoveMany */
	/**
	 * 
	 * Removes a doctor TrT from the list of doctor TrTs associated with this
	 * prescription. The doctor TrT can only be removed if it is associated with
	 * this prescription.
	 * 
	 * @param aDoctorTrT the doctor TrT to be removed from the list of doctor TrTs
	 * @return true if the doctor TrT was removed from the list of doctor TrTs,
	 *         false otherwise
	 */
	public boolean removeDoctorTrT(DoctorTrT aDoctorTrT) {
		boolean wasRemoved = false;
		if (!doctorTrTs.contains(aDoctorTrT)) {
			return wasRemoved;
		}

		int oldIndex = doctorTrTs.indexOf(aDoctorTrT);
		doctorTrTs.remove(oldIndex);
		if (aDoctorTrT.indexOfPrescription(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aDoctorTrT.removePrescription(this);
			if (!wasRemoved) {
				doctorTrTs.add(oldIndex, aDoctorTrT);
			}
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * 
	 * Adds a doctor TrT at a specified index in the list of doctor TrTs associated
	 * with this prescription. The doctor TrT can only be added if it is not already
	 * associated with this prescription.
	 * 
	 * @param aDoctorTrT the doctor TrT to be added to the list of doctor TrTs
	 * @param index      the index at which the doctor TrT should be added
	 * @return true if the doctor TrT was added at the specified index, false
	 *         otherwise
	 */
	public boolean addDoctorTrTAt(DoctorTrT aDoctorTrT, int index) {
		boolean wasAdded = false;
		if (addDoctorTrT(aDoctorTrT)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfDoctorTrTs()) {
				index = numberOfDoctorTrTs() - 1;
			}
			doctorTrTs.remove(aDoctorTrT);
			doctorTrTs.add(index, aDoctorTrT);
			wasAdded = true;
		}
		return wasAdded;
	}

	/**
	 * 
	 * Adds the given DoctorTrT object to this Prescription's list of DoctorTrTs, or
	 * moves it to the specified index if it is already present.
	 * 
	 * @param aDoctorTrT The DoctorTrT object to be added or moved
	 * @param index      The index to which the DoctorTrT object should be moved
	 * @return true if the DoctorTrT object was added or moved successfully, false
	 *         otherwise
	 */

	public boolean addOrMoveDoctorTrTAt(DoctorTrT aDoctorTrT, int index) {
		boolean wasAdded = false;
		if (doctorTrTs.contains(aDoctorTrT)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfDoctorTrTs()) {
				index = numberOfDoctorTrTs() - 1;
			}
			doctorTrTs.remove(aDoctorTrT);
			doctorTrTs.add(index, aDoctorTrT);
			wasAdded = true;
		} else {
			wasAdded = addDoctorTrTAt(aDoctorTrT, index);
		}
		return wasAdded;
	}

	/* Code from template association_MinimumNumberOfMethod */
	/**
	 * 
	 * Returns the minimum number of Diagnosis objects that must be associated with
	 * this Prescription.
	 * 
	 * @return The minimum number of Diagnosis objects required
	 */
	public static int minimumNumberOfDiagnosis() {
		return 0;
	}

	/* Code from template association_AddManyToManyMethod */
	/**
	 * 
	 * Adds the given Diagnosis object to this Prescription's list of Diagnosis
	 * objects, if it is not already present.
	 * 
	 * @param aDiagnosi The Diagnosis object to be added
	 * @return true if the Diagnosis object was added successfully, false otherwise
	 */
	public boolean addDiagnosi(Diagnosis aDiagnosi) {
		boolean wasAdded = false;
		if (diagnosis.contains(aDiagnosi)) {
			return false;
		}
		diagnosis.add(aDiagnosi);
		if (aDiagnosi.indexOfPrescription(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aDiagnosi.addPrescription(this);
			if (!wasAdded) {
				diagnosis.remove(aDiagnosi);
			}
		}
		return wasAdded;
	}

	/* Code from template association_RemoveMany */
	/**
	 * 
	 * Removes the given Diagnosis object from this Prescription's list of Diagnosis
	 * objects, if it is present.
	 * 
	 * @param aDiagnosi The Diagnosis object to be removed
	 * @return true if the Diagnosis object was removed successfully, false
	 *         otherwise
	 */
	public boolean removeDiagnosi(Diagnosis aDiagnosi) {
		boolean wasRemoved = false;
		if (!diagnosis.contains(aDiagnosi)) {
			return wasRemoved;
		}

		int oldIndex = diagnosis.indexOf(aDiagnosi);
		diagnosis.remove(oldIndex);
		if (aDiagnosi.indexOfPrescription(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aDiagnosi.removePrescription(this);
			if (!wasRemoved) {
				diagnosis.add(oldIndex, aDiagnosi);
			}
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * 
	 * Adds the given Diagnosis object to this Prescription's list of Diagnosis
	 * objects at the specified index, if it is not already present.
	 * 
	 * @param aDiagnosi The Diagnosis object to be added
	 * @param index     The index at which the Diagnosis object should be added
	 * @return true if the Diagnosis object was added successfully, false otherwise
	 */
	public boolean addDiagnosiAt(Diagnosis aDiagnosi, int index) {
		boolean wasAdded = false;
		if (addDiagnosi(aDiagnosi)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfDiagnosis()) {
				index = numberOfDiagnosis() - 1;
			}
			diagnosis.remove(aDiagnosi);
			diagnosis.add(index, aDiagnosi);
			wasAdded = true;
		}
		return wasAdded;
	}

	/**
	 * 
	 * Adds the given Diagnosis object to this Prescription's list of Diagnosis
	 * objects, or moves it to the specified index if it is already present.
	 * 
	 * @param aDiagnosi The Diagnosis object to be added or moved
	 * @param index     The index to which the Diagnosis object should be moved
	 * @return true if the Diagnosis object was added or moved successfully, false
	 *         otherwise
	 */
	public boolean addOrMoveDiagnosiAt(Diagnosis aDiagnosi, int index) {
		boolean wasAdded = false;
		if (diagnosis.contains(aDiagnosi)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfDiagnosis()) {
				index = numberOfDiagnosis() - 1;
			}
			diagnosis.remove(aDiagnosi);
			diagnosis.add(index, aDiagnosi);
			wasAdded = true;
		} else {
			wasAdded = addDiagnosiAt(aDiagnosi, index);
		}
		return wasAdded;
	}

	/**
	 * 
	 * Deletes this Prescription object and removes all its associations with
	 * Therapy, DoctorTrT, Diagnosis, and PatientTrT objects.
	 */

	public void delete() {
		for (int i = therapies.size(); i > 0; i--) {
			Therapy aTherapy = therapies.get(i - 1);
			aTherapy.delete();
		}
		PatientTrT placeholderPatientTrT = patientTrT;
		this.patientTrT = null;
		if (placeholderPatientTrT != null) {
			placeholderPatientTrT.removePrescription(this);
		}
		ArrayList<DoctorTrT> copyOfDoctorTrTs = new ArrayList<DoctorTrT>(doctorTrTs);
		doctorTrTs.clear();
		for (DoctorTrT aDoctorTrT : copyOfDoctorTrTs) {
			aDoctorTrT.removePrescription(this);
		}
		ArrayList<Diagnosis> copyOfDiagnosis = new ArrayList<Diagnosis>(diagnosis);
		diagnosis.clear();
		for (Diagnosis aDiagnosi : copyOfDiagnosis) {
			aDiagnosi.removePrescription(this);
		}
	}

}