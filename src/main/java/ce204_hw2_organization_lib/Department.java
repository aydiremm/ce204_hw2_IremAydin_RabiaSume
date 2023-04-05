/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

import java.util.*;
import java.sql.Date;

// line 61 "../../model.ump"
// line 163 "../../model.ump"
public class Department {

	// ------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Department Associations
	private List<Staff> staffs;
	private Hospital hospital;

	// ------------------------
	// CONSTRUCTOR
	// ------------------------
	/**
	 * @brief Constructs a new Department with the given Hospital.
	 * 
	 * @param aHospital The Hospital associated with the Department.
	 */

	public Department(Hospital aHospital) {
		staffs = new ArrayList<Staff>();
		boolean didAddHospital = setHospital(aHospital);
		if (!didAddHospital) {
			throw new RuntimeException(
					"Unable to create department due to hospital. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
		}
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	/* Code from template association_GetMany */

	/**
	 * @brief Gets the Staff at the specified index in the list of Staff.
	 * 
	 * @param index The index of the Staff to get.
	 * @return The Staff at the specified index.
	 */

	public Staff getStaff(int index) {
		Staff aStaff = staffs.get(index);
		return aStaff;
	}

	public List<Staff> getStaffs() {
		List<Staff> newStaffs = Collections.unmodifiableList(staffs);
		return newStaffs;
	}

	/**
	 * @brief Gets the number of Staff associated with the Department.
	 * 
	 * @return The number of Staff.
	 */
	public int numberOfStaffs() {
		int number = staffs.size();
		return number;
	}

	/**
	 * @brief Checks if there are any Staff associated with the Department.
	 * 
	 * @return True if there are Staff, false otherwise.
	 */
	public boolean hasStaffs() {
		boolean has = staffs.size() > 0;
		return has;
	}

	/**
	 * @brief Gets the index of the specified Staff in the list of Staff.
	 * 
	 * @param aStaff The Staff to search for.
	 * @return The index of the Staff, or -1 if not found.
	 */
	public int indexOfStaff(Staff aStaff) {
		int index = staffs.indexOf(aStaff);
		return index;
	}
	/* Code from template association_GetOne */

	public Hospital getHospital() {
		return hospital;
	}
	/* Code from template association_MinimumNumberOfMethod */

	public static int minimumNumberOfStaffs() {
		return 0;
	}
	/* Code from template association_AddManyToOne */

	/**
	 * @brief Adds a new Staff with the specified parameters to the Department.
	 * 
	 * @param aTitle         The title of the Staff.
	 * @param aGivenName     The given name of the Staff.
	 * @param aMiddleName    The middle name of the Staff.
	 * @param aFamilyName    The family name of the Staff.
	 * @param aBirthDate     The birth date of the Staff.
	 * @param aGender        The gender of the Staff.
	 * @param aHomeAddress   The home address of the Staff.
	 * @param aPhone         The phone number of the Staff.
	 * @param aJoined        The date the Staff joined the Department.
	 * @param aEducation     The education level of the Staff.
	 * @param aCertification The certifications held by the Staff.
	 * @param aLanguages     The languages spoken by the Staff.
	 * @return A pointer to the newly created Staff.
	 */

	public Staff addStaff(String aTitle, String aGivenName, String aMiddleName, String aFamilyName, Date aBirthDate,
			String aGender, String aHomeAddress, String aPhone, Date aJoined, String aEducation, String aCertification,
			String aLanguages) {
		return new Staff(aTitle, aGivenName, aMiddleName, aFamilyName, aBirthDate, aGender, aHomeAddress, aPhone,
				aJoined, aEducation, aCertification, aLanguages, this);
	}

	/**
	 * @brief Adds the specified Staff to the Department.
	 * 
	 * @param aStaff The Staff to add.
	 * @return True if the Staff was added, false if it was already associated with
	 *         the Department.
	 */
	public boolean addStaff(Staff aStaff) {
		boolean wasAdded = false;
		if (staffs.contains(aStaff)) {
			return false;
		}
		Department existingDepartment = aStaff.getDepartment();
		boolean isNewDepartment = existingDepartment != null && !this.equals(existingDepartment);
		if (isNewDepartment) {
			aStaff.setDepartment(this);
		} else {
			staffs.add(aStaff);
		}
		wasAdded = true;
		return wasAdded;
	}

	/**
	 * Removes a staff from the department.
	 *
	 * @param aStaff The staff to remove.
	 * @return True if the staff was successfully removed, false otherwise.
	 */

	public boolean removeStaff(Staff aStaff) {
		boolean wasRemoved = false;
		// Unable to remove aStaff, as it must always have a department
		if (!this.equals(aStaff.getDepartment())) {
			staffs.remove(aStaff);
			wasRemoved = true;
		}
		return wasRemoved;
	}
	/* Code from template association_AddIndexControlFunctions */

	/**
	 * Adds a staff to the department at the specified index.
	 *
	 * @param aStaff The staff to add.
	 * @param index  The index at which to add the staff.
	 * @return True if the staff was successfully added, false otherwise.
	 */
	public boolean addStaffAt(Staff aStaff, int index) {
		boolean wasAdded = false;
		if (addStaff(aStaff)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfStaffs()) {
				index = numberOfStaffs() - 1;
			}
			staffs.remove(aStaff);
			staffs.add(index, aStaff);
			wasAdded = true;
		}
		return wasAdded;
	}

	/**
	 * Adds or moves a staff to the department at the specified index.
	 *
	 * @param aStaff The staff to add or move.
	 * @param index  The index at which to add or move the staff.
	 * @return True if the staff was successfully added or moved, false otherwise.
	 */

	public boolean addOrMoveStaffAt(Staff aStaff, int index) {
		boolean wasAdded = false;
		if (staffs.contains(aStaff)) {
			if (index < 0) {
				index = 0;
			}
			if (index > numberOfStaffs()) {
				index = numberOfStaffs() - 1;
			}
			staffs.remove(aStaff);
			staffs.add(index, aStaff);
			wasAdded = true;
		} else {
			wasAdded = addStaffAt(aStaff, index);
		}
		return wasAdded;
	}
	/* Code from template association_SetOneToMany */

	/**
	 * Sets the hospital to which the department belongs.
	 *
	 * @param aHospital The hospital to set.
	 * @return True if the hospital was successfully set, false otherwise.
	 */

	public boolean setHospital(Hospital aHospital) {
		boolean wasSet = false;
		if (aHospital == null) {
			return wasSet;
		}

		Hospital existingHospital = hospital;
		hospital = aHospital;
		if (existingHospital != null && !existingHospital.equals(aHospital)) {
			existingHospital.removeDepartment(this);
		}
		hospital.addDepartment(this);
		wasSet = true;
		return wasSet;
	}

	/**
	 * 
	 * @brief Deletes this Department object from the system. This function removes
	 *        all staff members belonging to this department and sets its hospital
	 *        reference to null. If the department is associated with a hospital, it
	 *        is also removed from the hospital's department list.
	 */

	public void delete() {
		while (staffs.size() > 0) {
			Staff aStaff = staffs.get(staffs.size() - 1);
			aStaff.delete();
			staffs.remove(aStaff);
		}

		Hospital placeholderHospital = hospital;
		this.hospital = null;
		if (placeholderHospital != null) {
			placeholderHospital.removeDepartment(this);
		}
	}

}