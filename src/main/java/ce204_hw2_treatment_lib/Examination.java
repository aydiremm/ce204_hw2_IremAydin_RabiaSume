/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_treatment_lib;

import java.util.*;

// line 18 "../../model.ump"
// line 55 "../../model.ump"
public class Examination {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Examination Associations
	private PatientTrT patientTrT;
	private DoctorTrT doctorTrT;
	private List<Diagnosis> diagnosis;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	/**
	 * Constructor for Examination class.
	 * 
	 * @param aPatientTrT the patient associated with the examination
	 * @param aDoctorTrT  the doctor associated with the examination
	 * @throws RuntimeException if unable to create examination due to a violation
	 *                          of association multiplicity for either patient or
	 *                          doctor
	 */

	public Examination(PatientTrT aPatientTrT, DoctorTrT aDoctorTrT) {
		boolean didAddPatientTrT = setPatientTrT(aPatientTrT);
		if (!didAddPatientTrT) {
			throw new RuntimeException(
					"Unable to create examination due to patientTrT. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
		boolean didAddDoctorTrT = setDoctorTrT(aDoctorTrT);
		if (!didAddDoctorTrT) {
			throw new RuntimeException(
					"Unable to create examination due to doctorTrT. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
		diagnosis = new ArrayList<Diagnosis>();
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/* Code from template association_GetOne */
	public PatientTrT getPatientTrT() {
		return patientTrT;
	}

	/* Code from template association_GetOne */
	public DoctorTrT getDoctorTrT() {
		return doctorTrT;
	}

	/* Code from template association_GetMany */
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

	public int indexOfDiagnosi(Diagnosis aDiagnosi) {
		int index = diagnosis.indexOf(aDiagnosi);
		return index;
	}

	/* Code from template association_SetOneToMany */
	/**
	 * 
	 * Sets the patient associated with this examination.
	 * 
	 * @param aPatientTrT the patient to associate with this examination
	 * @return true if the patient was set successfully, false otherwise
	 */
	public boolean setPatientTrT(PatientTrT aPatientTrT) {
		boolean wasSet = false;
		if (aPatientTrT == null) {
			return wasSet;
		}

		PatientTrT existingPatientTrT = patientTrT;
		patientTrT = aPatientTrT;
		if (existingPatientTrT != null && !existingPatientTrT.equals(aPatientTrT)) {
			existingPatientTrT.removeExamination(this);
		}
		patientTrT.addExamination(this);
		wasSet = true;
		return wasSet;
	}

	/* Code from template association_SetOneToMany */
	/**
	 * 
	 * Sets the doctor associated with this examination.
	 * 
	 * @param aDoctorTrT the doctor to associate with this examination
	 * @return true if the doctor was set successfully, false otherwise
	 */
	public boolean setDoctorTrT(DoctorTrT aDoctorTrT) {
		boolean wasSet = false;
		if (aDoctorTrT == null) {
			return wasSet;
		}

		DoctorTrT existingDoctorTrT = doctorTrT;
		doctorTrT = aDoctorTrT;
		if (existingDoctorTrT != null && !existingDoctorTrT.equals(aDoctorTrT)) {
			existingDoctorTrT.removeExamination(this);
		}
		doctorTrT.addExamination(this);
		wasSet = true;
		return wasSet;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfDiagnosis() {
		return 0;
	}

	/* Code from template association_AddManyToManyMethod */
	public boolean addDiagnosi(Diagnosis aDiagnosi) {
		boolean wasAdded = false;
		if (diagnosis.contains(aDiagnosi)) {
			return false;
		}
		diagnosis.add(aDiagnosi);
		if (aDiagnosi.indexOfExamination(this) != -1) {
			wasAdded = true;
		} else {
			wasAdded = aDiagnosi.addExamination(this);
			if (!wasAdded) {
				diagnosis.remove(aDiagnosi);
			}
		}
		return wasAdded;
	}

	/* Code from template association_RemoveMany */
	public boolean removeDiagnosi(Diagnosis aDiagnosi) {
		boolean wasRemoved = false;
		if (!diagnosis.contains(aDiagnosi)) {
			return wasRemoved;
		}

		int oldIndex = diagnosis.indexOf(aDiagnosi);
		diagnosis.remove(oldIndex);
		if (aDiagnosi.indexOfExamination(this) == -1) {
			wasRemoved = true;
		} else {
			wasRemoved = aDiagnosi.removeExamination(this);
			if (!wasRemoved) {
				diagnosis.add(oldIndex, aDiagnosi);
			}
		}
		return wasRemoved;
	}

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * 
	 * Adds the given diagnosis at the specified index in the list of diagnosis for
	 * this examination.
	 * 
	 * @param aDiagnosi the diagnosis to be added
	 * @param index     the index at which the diagnosis should be added
	 * @return true if the diagnosis was added successfully, false otherwise
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
	 * Adds or moves the given diagnosis at the specified index in the list of
	 * diagnosis for this examination. If the diagnosis is already in the list, it
	 * is moved to the specified index.
	 * 
	 * @param aDiagnosi the diagnosis to be added or moved
	 * @param index     the index at which the diagnosis should be added or moved
	 * @return true if the diagnosis was added or moved successfully, false
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

	public void delete() {
		PatientTrT placeholderPatientTrT = patientTrT;
		this.patientTrT = null;
		if (placeholderPatientTrT != null) {
			placeholderPatientTrT.removeExamination(this);
		}
		DoctorTrT placeholderDoctorTrT = doctorTrT;
		this.doctorTrT = null;
		if (placeholderDoctorTrT != null) {
			placeholderDoctorTrT.removeExamination(this);
		}
		ArrayList<Diagnosis> copyOfDiagnosis = new ArrayList<Diagnosis>(diagnosis);
		diagnosis.clear();
		for (Diagnosis aDiagnosi : copyOfDiagnosis) {
			aDiagnosi.removeExamination(this);
		}
	}

}