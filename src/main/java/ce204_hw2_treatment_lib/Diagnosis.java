/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_treatment_lib;

import java.util.*;

// line 23 "../../model.ump"
// line 60 "../../model.ump"
public class Diagnosis {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Diagnosis Associations
	private PatientTrT patientTrT;
	private List<DoctorTrT> doctorTrTs;
	private List<Examination> examinations;
	private List<Prescription> prescriptions;
	private List<Treatment> treatments;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * @brief Constructor for creating a Diagnosis object with the given patientTrT
	 *        attribute.
	 * @param aPatientTrT The PatientTrT object associated with the diagnosis.
	 * @throw RuntimeException If unable to create a diagnosis due to a violation of
	 *        the patientTrT association multiplicity constraint.
	 */

	public Diagnosis(PatientTrT aPatientTrT) {
		boolean didAddPatientTrT = setPatientTrT(aPatientTrT);
		if (!didAddPatientTrT) {
			throw new RuntimeException(
					"Unable to create diagnosi due to patientTrT. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
		doctorTrTs = new ArrayList<DoctorTrT>();
		examinations = new ArrayList<Examination>();
		prescriptions = new ArrayList<Prescription>();
		treatments = new ArrayList<Treatment>();
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/* Code from template association_GetOne */
	public PatientTrT getPatientTrT() {
		return patientTrT;
	}

	/* Code from template association_GetMany */
	public DoctorTrT getDoctorTrT(int index) {
		DoctorTrT aDoctorTrT = doctorTrTs.get(index);
		return aDoctorTrT;
	}

	public List<DoctorTrT> getDoctorTrTs() {
		List<DoctorTrT> newDoctorTrTs = Collections.unmodifiableList(doctorTrTs);
		return newDoctorTrTs;
	}

	public int numberOfDoctorTrTs() {
		int number = doctorTrTs.size();
		return number;
	}

	public boolean hasDoctorTrTs() {
		boolean has = doctorTrTs.size() > 0;
		return has;
	}

	public int indexOfDoctorTrT(DoctorTrT aDoctorTrT) {
		int index = doctorTrTs.indexOf(aDoctorTrT);
		return index;
	}

	/* Code from template association_GetMany */
	public Examination getExamination(int index) {
		Examination aExamination = examinations.get(index);
		return aExamination;
	}

	public List<Examination> getExaminations() {
		List<Examination> newExaminations = Collections.unmodifiableList(examinations);
		return newExaminations;
	}

	public int numberOfExaminations() {
		int number = examinations.size();
		return number;
	}

	public boolean hasExaminations() {
		boolean has = examinations.size() > 0;
		return has;
	}

	public int indexOfExamination(Examination aExamination) {
		int index = examinations.indexOf(aExamination);
		return index;
	}

	/* Code from template association_GetMany */
	public Prescription getPrescription(int index) {
		Prescription aPrescription = prescriptions.get(index);
		return aPrescription;
	}

	public List<Prescription> getPrescriptions() {
		List<Prescription> newPrescriptions = Collections.unmodifiableList(prescriptions);
		return newPrescriptions;
	}

	public int numberOfPrescriptions() {
		int number = prescriptions.size();
		return number;
	}

	public boolean hasPrescriptions() {
		boolean has = prescriptions.size() > 0;
		return has;
	}

	public int indexOfPrescription(Prescription aPrescription) {
		int index = prescriptions.indexOf(aPrescription);
		return index;
	}

	/* Code from template association_GetMany */
	public Treatment getTreatment(int index) {
		Treatment aTreatment = treatments.get(index);
		return aTreatment;
	}

	public List<Treatment> getTreatments() {
		List<Treatment> newTreatments = Collections.unmodifiableList(treatments);
		return newTreatments;
	}

	public int numberOfTreatments() {
		int number = treatments.size();
		return number;
	}

	public boolean hasTreatments() {
		boolean has = treatments.size() > 0;
		return has;
	}

	/**
	 * @brief Returns the index of the given treatment in the treatments list.
	 * @param aTreatment The Treatment object to search for.
	 * @return The index of the treatment in the treatments list, or -1 if the
	 *         treatment is not found.
	 */

	public int indexOfTreatment(Treatment aTreatment) {
		int index = treatments.indexOf(aTreatment);
		return index;
	}

	/* Code from template association_SetOneToMany */
	/**
	 * @brief Sets the patientTrT attribute of the Diagnosis object to the given
	 *        PatientTrT object.
	 * @param aPatientTrT The PatientTrT object to set as the patientTrT attribute.
	 * @return True if the patientTrT attribute was successfully set, false
	 *         otherwise.
	 */
	public boolean setPatientTrT(PatientTrT aPatientTrT) {
		boolean wasSet = false;
		if (aPatientTrT == null) {
			return wasSet;
		}

		PatientTrT existingPatientTrT = patientTrT;
		patientTrT = aPatientTrT;
		if (existingPatientTrT != null && !existingPatientTrT.equals(aPatientTrT)) {
			existingPatientTrT.removeDiagnosi(this);
		}
		patientTrT.addDiagnosi(this);
		wasSet = true;
		return wasSet;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfDoctorTrTs() {
		return 0;
	}

	/* Code from template association_AddManyToManyMethod */
	/**
	 * Adds a DoctorTrT to the list of doctors associated with this Diagnosis.
	 * 
	 * @param aDoctorTrT the DoctorTrT to be added
	 * @return true if the DoctorTrT was added successfully, false otherwise
	 */
	public boolean addDoctorTrT(DoctorTrT aDoctorTrT) {
		boolean wasAdded = false;
		if (doctorTrTs.contains(aDoctorTrT)) {
			return false;
		}
		doctorTrTs.add(aDoctorTrT);
		if (aDoctorTrT.indexOfDiagnosi(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aDoctorTrT.addDiagnosi(this);
			if (!wasAdded) {
				doctorTrTs.remove(aDoctorTrT);
			}
		}
		return wasAdded;
	}

	/* Code from template association_RemoveMany */
	/**
	 * Removes a DoctorTrT from the list of doctors associated with this Diagnosis.
	 * 
	 * @param aDoctorTrT the DoctorTrT to be removed
	 * @return true if the DoctorTrT was removed successfully, false otherwise
	 */
	public boolean removeDoctorTrT(DoctorTrT aDoctorTrT) {
		boolean wasRemoved = false;
		if (!doctorTrTs.contains(aDoctorTrT)) {
			return wasRemoved;
		}

		int oldIndex = doctorTrTs.indexOf(aDoctorTrT);
		doctorTrTs.remove(oldIndex);
		if (aDoctorTrT.indexOfDiagnosi(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aDoctorTrT.removeDiagnosi(this);
			if (!wasRemoved) {
				doctorTrTs.add(oldIndex, aDoctorTrT);
			}
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * 
	 * Adds the given DoctorTrT to the list of DoctorTrTs at the specified index.
	 * 
	 * @param aDoctorTrT The DoctorTrT to be added to the list.
	 * @param index      The index at which to add the DoctorTrT to the list.
	 * @return True if the DoctorTrT was successfully added at the specified index,
	 *         false otherwise.
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
	 * Adds the given DoctorTrT to the list of DoctorTrTs at the specified index, or
	 * moves it to that index if it is already in the list.
	 * 
	 * @param aDoctorTrT The DoctorTrT to be added or moved to the list.
	 * @param index      The index at which to add or move the DoctorTrT to in the
	 *                   list.
	 * @return True if the DoctorTrT was successfully added or moved to the
	 *         specified index, false otherwise.
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
	 * Returns the minimum number of examinations for this class.
	 * 
	 * @return The minimum number of examinations, which is 0.
	 */
	public static int minimumNumberOfExaminations() {
		return 0;
	}

	/* Code from template association_AddManyToManyMethod */
	/**
	 * 
	 * Adds the given Examination to the list of Examinations associated with this
	 * Diagnosi.
	 * 
	 * @param aExamination The Examination to add to the list of Examinations.
	 * @return True if the Examination was successfully added to the list, false
	 *         otherwise.
	 */
	public boolean addExamination(Examination aExamination) {
		boolean wasAdded = false;
		if (examinations.contains(aExamination)) {
			return false;
		}
		examinations.add(aExamination);
		if (aExamination.indexOfDiagnosi(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aExamination.addDiagnosi(this);
			if (!wasAdded) {
				examinations.remove(aExamination);
			}
		}
		return wasAdded;
	}

	/**
	 * 
	 * Removes the given Examination from the list of Examinations associated with
	 * this Diagnosi.
	 * 
	 * @param aExamination The Examination to remove from the list of Examinations.
	 * @return True if the Examination was successfully removed from the list, false
	 *         otherwise.
	 */
	/* Code from template association_RemoveMany */
	public boolean removeExamination(Examination aExamination) {
		boolean wasRemoved = false;
		if (!examinations.contains(aExamination)) {
			return wasRemoved;
		}

		int oldIndex = examinations.indexOf(aExamination);
		examinations.remove(oldIndex);
		if (aExamination.indexOfDiagnosi(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aExamination.removeDiagnosi(this);
			if (!wasRemoved) {
				examinations.add(oldIndex, aExamination);
			}
		}
		return wasRemoved;
	}
	/* Code from template association_AddIndexControlFunctions */

	/**
	 * 
	 * Adds the given Examination object at the specified index in the list of
	 * examinations associated with this Diagnosi object. If the Examination is
	 * successfully added, the method returns true; otherwise, it returns false. If
	 * the specified index is negative, the Examination is added at index 0. If the
	 * specified index is greater than the number of examinations, the Examination
	 * is added at index numberOfExaminations() - 1.
	 * 
	 * @param aExamination The Examination object to add to the list of
	 *                     examinations.
	 * @param index        The index at which to add the Examination object.
	 * @return true if the Examination is successfully added; false otherwise.
	 */
	public boolean addExaminationAt(Examination aExamination, int index) {
		boolean wasAdded = false;
		if (addExamination(aExamination)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfExaminations()) {
				index = numberOfExaminations() - 1;
			}
			examinations.remove(aExamination);
			examinations.add(index, aExamination);
			wasAdded = true;
		}
		return wasAdded;
	}

	/**
	 * 
	 * Adds the given Examination object at the specified index in the list of
	 * examinations associated with this Diagnosi object, or moves it to the
	 * specified index if it is already in the list. If the Examination is
	 * successfully added or moved, the method returns true; otherwise, it returns
	 * false. If the specified index is negative, the Examination is added or moved
	 * to index 0. If the specified index is greater than the number of
	 * examinations, the Examination is added or moved to index
	 * numberOfExaminations() - 1.
	 * 
	 * @param aExamination The Examination object to add or move in the list of
	 *                     examinations.
	 * @param index        The index at which to add or move the Examination object.
	 * @return true if the Examination is successfully added or moved; false
	 *         otherwise.
	 */
	public boolean addOrMoveExaminationAt(Examination aExamination, int index) {
		boolean wasAdded = false;
		if (examinations.contains(aExamination)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfExaminations()) {
				index = numberOfExaminations() - 1;
			}
			examinations.remove(aExamination);
			examinations.add(index, aExamination);
			wasAdded = true;
		} else {
			wasAdded = addExaminationAt(aExamination, index);
		}
		return wasAdded;
	}

	/* Code from template association_MinimumNumberOfMethod */
	/**
	 * 
	 * Returns the minimum number of Prescription objects associated with this
	 * Diagnosi object, which is 0.
	 * 
	 * @return 0, the minimum number of Prescription objects.
	 */
	public static int minimumNumberOfPrescriptions() {
		return 0;
	}

	/* Code from template association_AddManyToManyMethod */
	/**
	 * 
	 * Adds the given Prescription object to the list of prescriptions associated
	 * with this Diagnosi object. If the Prescription is successfully added, the
	 * method returns true; otherwise, it returns false. If the Prescription is
	 * already associated with this Diagnosi object, the method returns false. If
	 * the Prescription is not associated with this Diagnosi object, it is added to
	 * the list and its addDiagnosi method is called to add this Diagnosi object to
	 * its list of associated Diagnosi objects. If the addDiagnosi method call
	 * fails, the Prescription is removed from the list.
	 * 
	 * @param aPrescription The Prescription object to add to the list of
	 *                      prescriptions.
	 * @return true if the Prescription is successfully added; false otherwise.
	 */
	public boolean addPrescription(Prescription aPrescription) {
		boolean wasAdded = false;
		if (prescriptions.contains(aPrescription)) {
			return false;
		}
		prescriptions.add(aPrescription);
		if (aPrescription.indexOfDiagnosi(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aPrescription.addDiagnosi(this);
			if (!wasAdded) {
				prescriptions.remove(aPrescription);
			}
		}
		return wasAdded;
	}

	/* Code from template association_RemoveMany */
	/**
	 * 
	 * Removes the given Prescription object from the list of prescriptions
	 * associated with this Diagnosi object. If the Prescription is successfully
	 * removed, the method returns true; otherwise, it returns false. If the
	 * Prescription is not associated with this Diagnosi object, the method returns
	 * false. If the Prescription is associated with this Diagnosi object, it is
	 * removed from the list and its removeDiagnosi method is called to remove this
	 * Diagnosi object from its list of associated Diagnosi objects. If the
	 * removeDiagnosi method call fails, the Prescription is added back to the list.
	 * 
	 * @param aPrescription The Prescription object to remove from the list of
	 *                      prescriptions.
	 * @return true if the Prescription is successfully removed; false otherwise.
	 */
	public boolean removePrescription(Prescription aPrescription) {
		boolean wasRemoved = false;
		if (!prescriptions.contains(aPrescription)) {
			return wasRemoved;
		}

		int oldIndex = prescriptions.indexOf(aPrescription);
		prescriptions.remove(oldIndex);
		if (aPrescription.indexOfDiagnosi(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aPrescription.removeDiagnosi(this);
			if (!wasRemoved) {
				prescriptions.add(oldIndex, aPrescription);
			}
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * Adds the given prescription to the list of prescriptions at the specified
	 * index. If the prescription was added successfully, returns true; otherwise,
	 * returns false.
	 * 
	 * @param aPrescription the prescription to add
	 * @param index         the index at which to add the prescription
	 * @return true if the prescription was added successfully; false otherwise
	 */
	public boolean addPrescriptionAt(Prescription aPrescription, int index) {
		boolean wasAdded = false;
		if (addPrescription(aPrescription)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfPrescriptions()) {
				index = numberOfPrescriptions() - 1;
			}
			prescriptions.remove(aPrescription);
			prescriptions.add(index, aPrescription);
			wasAdded = true;
		}
		return wasAdded;
	}

	/**
	 * Adds the given prescription to the list of prescriptions at the specified
	 * index, or moves it to that index if it's already in the list. If the
	 * prescription was added or moved successfully, returns true; otherwise,
	 * returns false.
	 * 
	 * @param aPrescription the prescription to add or move
	 * @param index         the index at which to add or move the prescription
	 * @return true if the prescription was added or moved successfully; false
	 *         otherwise
	 */

	public boolean addOrMovePrescriptionAt(Prescription aPrescription, int index) {
		boolean wasAdded = false;
		if (prescriptions.contains(aPrescription)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfPrescriptions()) {
				index = numberOfPrescriptions() - 1;
			}
			prescriptions.remove(aPrescription);
			prescriptions.add(index, aPrescription);
			wasAdded = true;
		} else {
			wasAdded = addPrescriptionAt(aPrescription, index);
		}
		return wasAdded;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfTreatments() {
		return 0;
	}
	/* Code from template association_AddManyToManyMethod */

	public boolean addTreatment(Treatment aTreatment) {
		boolean wasAdded = false;
		if (treatments.contains(aTreatment)) {
			return false;
		}
		treatments.add(aTreatment);
		if (aTreatment.indexOfDiagnosi(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aTreatment.addDiagnosi(this);
			if (!wasAdded) {
				treatments.remove(aTreatment);
			}
		}
		return wasAdded;
	}

	/* Code from template association_RemoveMany */
	public boolean removeTreatment(Treatment aTreatment) {
		boolean wasRemoved = false;
		if (!treatments.contains(aTreatment)) {
			return wasRemoved;
		}

		int oldIndex = treatments.indexOf(aTreatment);
		treatments.remove(oldIndex);
		if (aTreatment.indexOfDiagnosi(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aTreatment.removeDiagnosi(this);
			if (!wasRemoved) {
				treatments.add(oldIndex, aTreatment);
			}
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	public boolean addTreatmentAt(Treatment aTreatment, int index) {
		boolean wasAdded = false;
		if (addTreatment(aTreatment)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfTreatments()) {
				index = numberOfTreatments() - 1;
			}
			treatments.remove(aTreatment);
			treatments.add(index, aTreatment);
			wasAdded = true;
		}
		return wasAdded;
	}

	public boolean addOrMoveTreatmentAt(Treatment aTreatment, int index) {
		boolean wasAdded = false;
		if (treatments.contains(aTreatment)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfTreatments()) {
				index = numberOfTreatments() - 1;
			}
			treatments.remove(aTreatment);
			treatments.add(index, aTreatment);
			wasAdded = true;
		} else {
			wasAdded = addTreatmentAt(aTreatment, index);
		}
		return wasAdded;
	}

	public void delete() {
		PatientTrT placeholderPatientTrT = patientTrT;
		this.patientTrT = null;
		if (placeholderPatientTrT != null) {
			placeholderPatientTrT.removeDiagnosi(this);
		}
		ArrayList<DoctorTrT> copyOfDoctorTrTs = new ArrayList<DoctorTrT>(doctorTrTs);
		doctorTrTs.clear();
		for (DoctorTrT aDoctorTrT : copyOfDoctorTrTs) {
			aDoctorTrT.removeDiagnosi(this);
		}
		ArrayList<Examination> copyOfExaminations = new ArrayList<Examination>(examinations);
		examinations.clear();
		for (Examination aExamination : copyOfExaminations) {
			aExamination.removeDiagnosi(this);
		}
		ArrayList<Prescription> copyOfPrescriptions = new ArrayList<Prescription>(prescriptions);
		prescriptions.clear();
		for (Prescription aPrescription : copyOfPrescriptions) {
			aPrescription.removeDiagnosi(this);
		}
		ArrayList<Treatment> copyOfTreatments = new ArrayList<Treatment>(treatments);
		treatments.clear();
		for (Treatment aTreatment : copyOfTreatments) {
			aTreatment.removeDiagnosi(this);
		}
	}

}