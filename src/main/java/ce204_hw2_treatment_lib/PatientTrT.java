/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_treatment_lib;

import java.sql.Date;
import java.util.*;
import ce204_hw2_organization_lib.*;

// line 4 "../../model.ump"
// line 87 "../../model.ump"
// line 92 "../../model.ump"
/**
 * 
 * @brief This class represents a patient who is receiving treatments.
 * @param aTitle         The title of the patient.
 * @param aGivenName     The given name of the patient.
 * @param aMiddleName    The middle name of the patient.
 * @param aFamilyName    The family name of the patient.
 * @param aBirthDate     The birth date of the patient.
 * @param aGender        The gender of the patient.
 * @param aHomeAddress   The home address of the patient.
 * @param aPhone         The phone number of the patient.
 * @param aId            The ID of the patient.
 * @param aAge           The age of the patient.
 * @param aAccepted      Whether the patient is accepted.
 * @param aSickness      The sickness of the patient.
 * @param aPrescriptions The prescriptions for the patient.
 * @param aAllergies     The allergies of the patient.
 * @param aSpecialReqs   The special requirements of the patient.
 */
public class PatientTrT extends Patient {

	public PatientTrT(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, String aId, int aAge, String aAccepted,
			String aSickness, String aPrescriptions, String aAllergies, String aSpecialReqs) {
		super(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone, aId, aAge,
				aAccepted, aSickness, aPrescriptions, aAllergies, aSpecialReqs);
		// TODO Auto-generated constructor stub
		prescriptions = new ArrayList<Prescription>();
		treatments = new ArrayList<Treatment>();
		doctorTrTs = new ArrayList<DoctorTrT>();
		examinations = new ArrayList<Examination>();
		diagnosis = new ArrayList<Diagnosis>();
	}

//------------------------
	// MEMBER VARIABLES
	// ------------------------

	// PatientTrT Associations
	private List<Prescription> prescriptions;
	private List<Treatment> treatments;
	private List<DoctorTrT> doctorTrTs;
	private List<Examination> examinations;
	private List<Diagnosis> diagnosis;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	// ------------------------
	// INTERFACE
	// ------------------------
	/* Code from template association_GetMany */
	public Prescription getPrescription(int index) {
		Prescription aPrescription = prescriptions.get(index);
		return aPrescription;
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
	 * 
	 * @brief Returns the index of a specified treatment in the list of treatments.
	 * @param aTreatment The treatment to find the index of.
	 * @return The index of the specified treatment in the list of treatments.
	 */

	public int indexOfTreatment(Treatment aTreatment) {
		int index = treatments.indexOf(aTreatment);
		return index;
	}

	/* Code from template association_GetMany */
	/**
	 * 
	 * @brief Returns the DoctorTrT object at the specified index in the list of
	 *        doctorTrTs.
	 * @param index The index of the DoctorTrT object to retrieve.
	 * @return The DoctorTrT object at the specified index in the list of
	 *         doctorTrTs.
	 */
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

	/**
	 * 
	 * @brief Returns the index of a specified DoctorTrT object in the list of
	 *        doctorTrTs.
	 * @param aDoctorTrT The DoctorTrT object to find the index of.
	 * @return The index of the specified DoctorTrT object in the list of
	 *         doctorTrTs.
	 */
	public int indexOfDoctorTrT(DoctorTrT aDoctorTrT) {
		int index = doctorTrTs.indexOf(aDoctorTrT);
		return index;
	}

	/* Code from template association_GetMany */
	/**
	 * 
	 * @brief Returns the Examination object at the specified index in the list of
	 *        examinations.
	 * @param index The index of the Examination object to retrieve.
	 * @return The Examination object at the specified index in the list of
	 *         examinations.
	 */
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

	/**
	 * 
	 * @brief Returns the index of a specified Examination object in the list of
	 *        examinations.
	 * @param aExamination The Examination object to find the index of.
	 * @return The index of the specified Examination object in the list of
	 *         examinations.
	 */

	public int indexOfExamination(Examination aExamination) {
		int index = examinations.indexOf(aExamination);
		return index;
	}

	/* Code from template association_GetMany */
	/**
	 * 
	 * @brief Returns the Diagnosis object at the specified index in the list of
	 *        diagnosis.
	 * @param index The index of the Diagnosis object to retrieve.
	 * @return The Diagnosis object at the specified index in the list of diagnosis.
	 */
	public Diagnosis getDiagnosi(int index) {
		Diagnosis aDiagnosi = diagnosis.get(index);
		return aDiagnosi;
	}

	public List<Diagnosis> getDiagnosis() {
		List<Diagnosis> newDiagnosis = Collections.unmodifiableList(diagnosis);
		return newDiagnosis;
	}

	public int numberOfDiagnosis() {
		int number = diagnosis.size();
		return number;
	}

	public boolean hasDiagnosis() {
		boolean has = diagnosis.size() > 0;
		return has;
	}

	/**
	 * 
	 * @brief Returns the index of a specified Diagnosis object in the list of
	 *        diagnosis.
	 * @param aDiagnosi The Diagnosis object to find the index of.
	 * @return The index of the specified Diagnosis object in the list of diagnosis.
	 */

	public int indexOfDiagnosi(Diagnosis aDiagnosi) {
		int index = diagnosis.indexOf(aDiagnosi);
		return index;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfPrescriptions() {
		return 0;
	}

	/* Code from template association_AddManyToOne */
	public Prescription addPrescription() {
		return new Prescription(this);
	}

	/**
	 * 
	 * @brief Adds a Prescription object to the list of prescriptions.
	 * @param aPrescription The Prescription object to add.
	 * @return true if the Prescription was added successfully, false if the
	 *         Prescription already exists in the list.
	 */
	public boolean addPrescription(Prescription aPrescription) {
		boolean wasAdded = false;
		if (prescriptions.contains(aPrescription)) {
			return false;
		}
		PatientTrT existingPatientTrT = aPrescription.getPatientTrT();
		boolean isNewPatientTrT = existingPatientTrT != null && !this.equals(existingPatientTrT);
		if (isNewPatientTrT) {
			aPrescription.setPatientTrT(this);
		} else {
			prescriptions.add(aPrescription);
		}
		wasAdded = true;
		return wasAdded;
	}

	/**
	 * 
	 * @brief Removes a Prescription object from the list of prescriptions.
	 * @param aPrescription The Prescription object to remove.
	 * @return true if the Prescription was removed successfully, false if the
	 *         Prescription is not associated with this PatientTrT object.
	 */

	public boolean removePrescription(Prescription aPrescription) {
		boolean wasRemoved = false;
		// Unable to remove aPrescription, as it must always have a patientTrT
		if (!this.equals(aPrescription.getPatientTrT())) {
			prescriptions.remove(aPrescription);
			wasRemoved = true;
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * 
	 * @brief Adds a Prescription object to the list of prescriptions at the
	 *        specified index.
	 * @param aPrescription The Prescription object to add.
	 * @param index         The index at which to add the Prescription object.
	 * @return true if the Prescription was added successfully, false if the
	 *         Prescription already exists in the list.
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
	 * 
	 * Adds or moves the given prescription to the specified index in the
	 * prescriptions list. If the prescription is already in the list, it will be
	 * moved to the new index. If the prescription is not in the list, it will be
	 * added at the specified index. If the specified index is out of bounds, the
	 * prescription will be added to the beginning or end of the list.
	 * 
	 * @param aPrescription The prescription to add or move.
	 * @param index         The index to add or move the prescription to.
	 * @return True if the prescription was added or moved successfully, false
	 *         otherwise.
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

	/* Code from template association_AddManyToOne */
	public Treatment addTreatment() {
		return new Treatment(this);
	}

	/**
	 * Adds a treatment to the patient's treatment history.
	 *
	 * @param aTreatment The treatment to add.
	 * @return True if the treatment was added successfully, false if the treatment
	 *         is already in the history.
	 */
	public boolean addTreatment(Treatment aTreatment) {
		boolean wasAdded = false;
		if (treatments.contains(aTreatment)) {
			return false;
		}
		PatientTrT existingPatientTrT = aTreatment.getPatientTrT();
		boolean isNewPatientTrT = existingPatientTrT != null && !this.equals(existingPatientTrT);
		if (isNewPatientTrT) {
			aTreatment.setPatientTrT(this);
		} else {
			treatments.add(aTreatment);
		}
		wasAdded = true;
		return wasAdded;
	}

	/**
	 * Removes a treatment from the patient's treatment history.
	 *
	 * @param aTreatment The treatment to remove.
	 * @return True if the treatment was removed successfully, false if the
	 *         treatment is not in the history or is not associated with this
	 *         patient.
	 */
	public boolean removeTreatment(Treatment aTreatment) {
		boolean wasRemoved = false;
		// Unable to remove aTreatment, as it must always have a patientTrT
		if (!this.equals(aTreatment.getPatientTrT())) {
			treatments.remove(aTreatment);
			wasRemoved = true;
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * Adds a treatment to the patient's treatment history at a specified index.
	 *
	 * @param aTreatment The treatment to add.
	 * @param index      The index at which to add the treatment.
	 * @return True if the treatment was added successfully, false if the treatment
	 *         is already in the history.
	 */
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

	/**
	 * Adds a treatment to the patient's treatment history at a specified index, or
	 * moves the treatment to the specified index if it is already in the history.
	 *
	 * @param aTreatment The treatment to add or move.
	 * @param index      The index at which to add or move the treatment.
	 * @return True if the treatment was added or moved successfully, false
	 *         otherwise.
	 */
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

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfDoctorTrTs() {
		return 0;
	}

	/* Code from template association_AddManyToManyMethod */
	/**
	 * 
	 * Adds a Treatment object to the treatments list of this PatientTrT object.
	 * 
	 * @param aTreatment the Treatment object to be added to the list
	 * @return true if the Treatment object was added successfully, false otherwise
	 */
	public boolean addDoctorTrT(DoctorTrT aDoctorTrT) {
		boolean wasAdded = false;
		if (doctorTrTs.contains(aDoctorTrT)) {
			return false;
		}
		doctorTrTs.add(aDoctorTrT);
		if (aDoctorTrT.indexOfPatientTrT(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aDoctorTrT.addPatientTrT(this);
			if (!wasAdded) {
				doctorTrTs.remove(aDoctorTrT);
			}
		}
		return wasAdded;
	}

	/* Code from template association_RemoveMany */
	/**
	 * 
	 * Removes a Treatment object from the treatments list of this PatientTrT
	 * object.
	 * 
	 * @param aTreatment the Treatment object to be removed from the list
	 * @return true if the Treatment object was removed successfully, false
	 *         otherwise
	 */
	public boolean removeDoctorTrT(DoctorTrT aDoctorTrT) {
		boolean wasRemoved = false;
		if (!doctorTrTs.contains(aDoctorTrT)) {
			return wasRemoved;
		}

		int oldIndex = doctorTrTs.indexOf(aDoctorTrT);
		doctorTrTs.remove(oldIndex);
		if (aDoctorTrT.indexOfPatientTrT(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aDoctorTrT.removePatientTrT(this);
			if (!wasRemoved) {
				doctorTrTs.add(oldIndex, aDoctorTrT);
			}
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * 
	 * Adds a DoctorTrT object to the doctorTrTs list of this PatientTrT object.
	 * 
	 * @param aDoctorTrT the DoctorTrT object to be added to the list
	 * @return true if the DoctorTrT object was added successfully, false otherwise
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
	public static int minimumNumberOfExaminations() {
		return 0;
	}

	/* Code from template association_AddManyToOne */
	public Examination addExamination(DoctorTrT aDoctorTrT) {
		return new Examination(this, aDoctorTrT);
	}

	/**
	 * Adds an examination to the patient's list of examinations.
	 *
	 * @param aExamination the examination to be added.
	 * @return true if the examination was successfully added, false if it already
	 *         exists in the list.
	 */

	public boolean addExamination(Examination aExamination) {
		boolean wasAdded = false;
		if (examinations.contains(aExamination)) {
			return false;
		}
		PatientTrT existingPatientTrT = aExamination.getPatientTrT();
		boolean isNewPatientTrT = existingPatientTrT != null && !this.equals(existingPatientTrT);
		if (isNewPatientTrT) {
			aExamination.setPatientTrT(this);
		} else {
			examinations.add(aExamination);
		}
		wasAdded = true;
		return wasAdded;
	}

	/**
	 * Removes an examination from the patient's list of examinations.
	 *
	 * @param aExamination the examination to be removed.
	 * @return true if the examination was successfully removed, false if it was not
	 *         found or could not be removed.
	 */
	public boolean removeExamination(Examination aExamination) {
		boolean wasRemoved = false;
		// Unable to remove aExamination, as it must always have a patientTrT
		if (!this.equals(aExamination.getPatientTrT())) {
			examinations.remove(aExamination);
			wasRemoved = true;
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * Adds an examination to the patient's list of examinations at a specific
	 * index.
	 *
	 * @param aExamination the examination to be added.
	 * @param index        the index at which to add the examination.
	 * @return true if the examination was successfully added, false if it already
	 *         exists in the list or the index is out of range.
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
	 * Adds an examination to the patient's list of examinations at a specific
	 * index, or moves it to that index if it already exists in the list.
	 *
	 * @param aExamination the examination to be added or moved.
	 * @param index        the index at which to add or move the examination.
	 * @return true if the examination was successfully added or moved, false if it
	 *         already exists in the list and could not be moved or the index is out
	 *         of range.
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
	public static int minimumNumberOfDiagnosis() {
		return 0;
	}

	/* Code from template association_AddManyToOne */
	public Diagnosis addDiagnosi() {
		return new Diagnosis(this);
	}

	/**
	 * Adds a diagnosis to the patient's list of diagnoses.
	 *
	 * @param aDiagnosi the diagnosis to be added.
	 * @return true if the diagnosis was successfully added, false if it already
	 *         exists in the list.
	 */
	public boolean addDiagnosi(Diagnosis aDiagnosi) {
		boolean wasAdded = false;
		if (diagnosis.contains(aDiagnosi)) {
			return false;
		}
		PatientTrT existingPatientTrT = aDiagnosi.getPatientTrT();
		boolean isNewPatientTrT = existingPatientTrT != null && !this.equals(existingPatientTrT);
		if (isNewPatientTrT) {
			aDiagnosi.setPatientTrT(this);
		} else {
			diagnosis.add(aDiagnosi);
		}
		wasAdded = true;
		return wasAdded;
	}

	/**
	 * Removes a diagnosis from the patient's list of diagnoses.
	 *
	 * @param aDiagnosi the diagnosis to be removed.
	 * @return true if the diagnosis was successfully removed, false if it was not
	 *         found or could not be removed.
	 */
	public boolean removeDiagnosi(Diagnosis aDiagnosi) {
		boolean wasRemoved = false;
		// Unable to remove aDiagnosi, as it must always have a patientTrT
		if (!this.equals(aDiagnosi.getPatientTrT())) {
			diagnosis.remove(aDiagnosi);
			wasRemoved = true;
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * Adds a diagnosis to the patient's list of diagnoses at a specified index.
	 *
	 * @param aDiagnosi the diagnosis to be added.
	 * @param index     the index at which the diagnosis should be inserted.
	 * @return true if the diagnosis was successfully added, false if it already
	 *         exists in the list.
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
	 * Adds a diagnosis to the patient's list of diagnoses at a specified index, or
	 * moves it to the index if it already exists in the list.
	 *
	 * @param aDiagnosi the diagnosis to be added or moved.
	 * @param index     the index at which the diagnosis should be inserted.
	 * @return true if the diagnosis was successfully added or moved, false if it
	 *         could not be added or moved.
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

	public void delete() {
		for (int i = prescriptions.size(); i > 0; i--) {
			Prescription aPrescription = prescriptions.get(i - 1);
			aPrescription.delete();
		}
		for (int i = treatments.size(); i > 0; i--) {
			Treatment aTreatment = treatments.get(i - 1);
			aTreatment.delete();
		}
		ArrayList<DoctorTrT> copyOfDoctorTrTs = new ArrayList<DoctorTrT>(doctorTrTs);
		doctorTrTs.clear();
		for (DoctorTrT aDoctorTrT : copyOfDoctorTrTs) {
			aDoctorTrT.removePatientTrT(this);
		}
		for (int i = examinations.size(); i > 0; i--) {
			Examination aExamination = examinations.get(i - 1);
			aExamination.delete();
		}
		for (int i = diagnosis.size(); i > 0; i--) {
			Diagnosis aDiagnosi = diagnosis.get(i - 1);
			aDiagnosi.delete();
		}
	}

}