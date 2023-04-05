/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_treatment_lib;

import java.util.*;

// line 41 "../../model.ump"
// line 77 "../../model.ump"
public class Therapy extends Treatment {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Therapy Associations
	private Prescription prescription;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * @brief Constructs a Therapy object with the given PatientTrT and Prescription
	 *        objects.
	 *
	 * @param aPatientTrT   The PatientTrT object associated with this Therapy.
	 * @param aPrescription The Prescription object associated with this Therapy.
	 *
	 *                      This constructor initializes a Therapy object with the
	 *                      given PatientTrT and Prescription objects. It also calls
	 *                      the base class constructor with the PatientTrT object.
	 *
	 * @throw std::runtime_error if unable to create therapy due to prescription
	 *        (see
	 *        http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html).
	 */

	public Therapy(PatientTrT aPatientTrT, Prescription aPrescription) {
		super(aPatientTrT);
		boolean didAddPrescription = setPrescription(aPrescription);
		if (!didAddPrescription) {
			throw new RuntimeException(
					"Unable to create therapy due to prescription. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/* Code from template association_GetOne */
	/**
	 * @brief Returns the Prescription object associated with this Therapy.
	 *
	 * @return The Prescription object associated with this Therapy.
	 */
	public Prescription getPrescription() {
		return prescription;
	}

	/* Code from template association_SetOneToMany */
	/**
	 * @brief Sets the Prescription object associated with this Therapy.
	 *
	 * @param aPrescription The Prescription object to associate with this Therapy.
	 * @return True if the Prescription object was set successfully, false
	 *         otherwise.
	 *
	 *         This method sets the Prescription object associated with this
	 *         Therapy. If the given Prescription object is null, the method returns
	 *         false without changing the object. If the Prescription object is not
	 *         null, the method removes any existing association between the Therapy
	 *         and the old Prescription (if any) and creates a new association
	 *         between the Therapy and the new Prescription.
	 */
	public boolean setPrescription(Prescription aPrescription) {
		boolean wasSet = false;
		if (aPrescription == null) {
			return wasSet;
		}

		Prescription existingPrescription = prescription;
		prescription = aPrescription;
		if (existingPrescription != null && !existingPrescription.equals(aPrescription)) {
			existingPrescription.removeTherapy(this);
		}
		prescription.addTherapy(this);
		wasSet = true;
		return wasSet;
	}

	/**
	 * @brief Deletes this Therapy object from the system.
	 *
	 *        This method deletes the current Therapy object from the system. It
	 *        also removes the association between the Prescription object and the
	 *        Therapy object, if any. If there is no associated Prescription object,
	 *        this method only calls the base class's delete method.
	 */
	public void delete() {
		Prescription placeholderPrescription = prescription;
		this.prescription = null;
		if (placeholderPrescription != null) {
			placeholderPrescription.removeTherapy(this);
		}
		super.delete();
	}

}