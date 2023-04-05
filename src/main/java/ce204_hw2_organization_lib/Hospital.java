/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;
import java.util.*;

// line 35 "../organization.ump"
// line 152 "../organization.ump"
public class Hospital
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Map<String, Hospital> hospitalsByName = new HashMap<String, Hospital>();

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Hospital Attributes
  private String name;
  private Address address;
  private Phone phone;

  //Hospital Associations
  private List<Person> persons;
  private List<Department> departments;

  //------------------------
  // CONSTRUCTOR
  //------------------------
	/**
	 * @brief Constructor for the Hospital class.
	 * 
	 * @param aName    The name of the hospital.
	 * @param aAddress The address of the hospital.
	 * @param aPhone   The phone number of the hospital.
	 */

  public Hospital(String aName, Address aAddress, Phone aPhone)
  {
    address = aAddress;
    phone = aPhone;
    if (!setName(aName))
    {
      throw new RuntimeException("Cannot create due to duplicate name. See http://manual.umple.org?RE003ViolationofUniqueness.html");
    }
    persons = new ArrayList<Person>();
    departments = new ArrayList<Department>();
  }

  //------------------------
  // INTERFACE
  //------------------------
	/**
	 * @brief Sets the name of the hospital.
	 * 
	 * @param aName The new name of the hospital.
	 * @return True if the name was successfully set, false otherwise.
	 */

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    String anOldName = getName();
    if (anOldName != null && anOldName.equals(aName)) {
      return true;
    }
    if (hasWithName(aName)) {
      return wasSet;
    }
    name = aName;
    wasSet = true;
    if (anOldName != null) {
      hospitalsByName.remove(anOldName);
    }
    hospitalsByName.put(aName, this);
    return wasSet;
  }


	/**
	 * @brief Sets the address of the hospital.
	 *
	 * @param aAddress The new address of the hospital.
	 * @return True if the address was successfully set, false otherwise.
	 */
  public boolean setAddress(Address aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

	/**
	 * @brief Sets the phone number of the hospital.
	 *
	 * @param aPhone The new phone number of the hospital.
	 * @return True if the phone number was successfully set, false otherwise.
	 */
  public boolean setPhone(Phone aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

	/**
	 * @brief Gets the name of the hospital.
	 *
	 * @return The name of the hospital.
	 */
  public String getName()
  {
    return name;
  }
  /* Code from template attribute_GetUnique */
  public static Hospital getWithName(String aName)
  {
    return hospitalsByName.get(aName);
  }
  /* Code from template attribute_HasUnique */
  public static boolean hasWithName(String aName)
  {
    return getWithName(aName) != null;
  }


	/**
	 * @brief Gets the address of the hospital.
	 *
	 * @return The address of the hospital.
	 */
  public Address getAddress()
  {
    return address;
  }

	/**
	 * @brief Gets the phone number of the hospital.
	 *
	 * @return The phone number of the hospital.
	 */

  public Phone getPhone()
  {
    return phone;
  }

	/* Code from template association_GetMany */
	/**
	 * @brief Gets a specific Person from the hospital's list of persons.
	 *
	 * @param index The index of the Person to retrieve.
	 * @return The Person at the specified index.
	 */
  public Person getPerson(int index)
  {
    Person aPerson = persons.get(index);
    return aPerson;
  }

	/**
	 * @brief Gets an unmodifiable List of all Persons associated with the hospital.
	 *
	 * @return An unmodifiable List of all Persons associated with the hospital.
	 */

  public List<Person> getPersons()
  {
    List<Person> newPersons = Collections.unmodifiableList(persons);
    return newPersons;
  }


	/**
	 * @brief Gets the number of Persons associated with the hospital.
	 *
	 * @return The number of Persons associated with the hospital.
	 */

  public int numberOfPersons()
  {
    int number = persons.size();
    return number;
  }

	/**
	 * Check if this hospital has any persons.
	 * 
	 * @return true if this hospital has one or more persons, false otherwise.
	 */

  public boolean hasPersons()
  {
    boolean has = persons.size() > 0;
    return has;
  }


	/**
	 * Get the index of the specified person in the list of persons associated with
	 * this hospital.
	 * 
	 * @param aPerson The person to look for.
	 * @return The index of the person in the list, or -1 if the person is not
	 *         found.
	 */

  public int indexOfPerson(Person aPerson)
  {
    int index = persons.indexOf(aPerson);
    return index;
  }

	/* Code from template association_GetMany */
	/**
	 * Get the department at the specified index in the list of departments
	 * associated with this hospital.
	 * 
	 * @param index The index of the department to get.
	 * @return The department at the specified index.
	 * @throws IndexOutOfBoundsException if the index is out of range (index < 0 ||
	 *                                   index >= numberOfDepartments()).
	 */
  public Department getDepartment(int index)
  {
    Department aDepartment = departments.get(index);
    return aDepartment;
  }

	/**
	 * Get an unmodifiable view of the list of departments associated with this
	 * hospital.
	 * 
	 * @return An unmodifiable list of departments.
	 */
  public List<Department> getDepartments()
  {
    List<Department> newDepartments = Collections.unmodifiableList(departments);
    return newDepartments;
  }

	/**
	 * Get the number of departments associated with this hospital.
	 * 
	 * @return The number of departments.
	 */

  public int numberOfDepartments()
  {
    int number = departments.size();
    return number;
  }

	/**
	 * Check if this hospital has any departments.
	 * 
	 * @return true if this hospital has one or more departments, false otherwise.
	 */

  public boolean hasDepartments()
  {
    boolean has = departments.size() > 0;
    return has;
  }


	/**
	 * Get the index of the specified department in the list of departments
	 * associated with this hospital.
	 * 
	 * @param aDepartment The department to look for.
	 * @return The index of the department in the list, or -1 if the department is
	 *         not found.
	 */

  public int indexOfDepartment(Department aDepartment)
  {
    int index = departments.indexOf(aDepartment);
    return index;
  }
	/* Code from template association_MinimumNumberOfMethod */

	/**
	 * Get the minimum number of persons that can be associated with a hospital.
	 * 
	 * @return The minimum number of persons.
	 */
  public static int minimumNumberOfPersons()
  {
    return 0;
  }

	/* Code from template association_AddManyToManyMethod */
	/**
	 * Add the specified person to the list of persons associated with this
	 * hospital.
	 * 
	 * @param aPerson The person to add.
	 * @return true if the person was added to the list, false otherwise.
	 */
  public boolean addPerson(Person aPerson)
  {
    boolean wasAdded = false;
    if (persons.contains(aPerson)) { return false; }
    persons.add(aPerson);
    if (aPerson.indexOfHospital(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPerson.addHospital(this);
      if (!wasAdded)
      {
        persons.remove(aPerson);
      }
    }
    return wasAdded;
  }

	/* Code from template association_RemoveMany */
	/**
	 * Removes a Person from the list of persons associated with this Hospital. If
	 * the Person was not in the list, nothing is changed.
	 *
	 * @param aPerson the Person to be removed
	 * @return true if the Person was successfully removed, false otherwise
	 */
  public boolean removePerson(Person aPerson)
  {
    boolean wasRemoved = false;
    if (!persons.contains(aPerson))
    {
      return wasRemoved;
    }

    int oldIndex = persons.indexOf(aPerson);
    persons.remove(oldIndex);
    if (aPerson.indexOfHospital(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPerson.removeHospital(this);
      if (!wasRemoved)
      {
        persons.add(oldIndex,aPerson);
      }
    }
    return wasRemoved;
  }

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * Adds a Person to the list of persons associated with this Hospital at a given
	 * index.
	 *
	 * @param aPerson the Person to be added
	 * @param index   the index at which to add the Person
	 * @return true if the Person was successfully added, false otherwise
	 */
  public boolean addPersonAt(Person aPerson, int index)
  {  
    boolean wasAdded = false;
    if(addPerson(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersons()) { index = numberOfPersons() - 1; }
      persons.remove(aPerson);
      persons.add(index, aPerson);
      wasAdded = true;
    }
    return wasAdded;
  }

	/**
	 * Adds a Person to the list of persons associated with this Hospital at a given
	 * index, or moves it to the index if it already exists in the list.
	 *
	 * @param aPerson the Person to be added or moved
	 * @param index   the index at which to add or move the Person
	 * @return true if the Person was successfully added or moved, false otherwise
	 */
  public boolean addOrMovePersonAt(Person aPerson, int index)
  {
    boolean wasAdded = false;
    if(persons.contains(aPerson))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPersons()) { index = numberOfPersons() - 1; }
      persons.remove(aPerson);
      persons.add(index, aPerson);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPersonAt(aPerson, index);
    }
    return wasAdded;
  }

	/* Code from template association_MinimumNumberOfMethod */
	/**
	 * Returns the minimum number of Departments associated with this Hospital.
	 *
	 * @return the minimum number of Departments associated with this Hospital
	 */
  public static int minimumNumberOfDepartments()
  {
    return 0;
  }

	/* Code from template association_AddManyToOne */
	/**
	 * Creates a new Department associated with this Hospital and returns it.
	 *
	 * @return the new Department associated with this Hospital
	 */
  public Department addDepartment()
  {
    return new Department(this);
  }


	/**
	 * Adds a Department to the list of Departments associated with this Hospital.
	 *
	 * @param aDepartment the Department to be added
	 * @return true if the Department was successfully added, false otherwise
	 */
  public boolean addDepartment(Department aDepartment)
  {
    boolean wasAdded = false;
    if (departments.contains(aDepartment)) { return false; }
    Hospital existingHospital = aDepartment.getHospital();
    boolean isNewHospital = existingHospital != null && !this.equals(existingHospital);
    if (isNewHospital)
    {
      aDepartment.setHospital(this);
    }
    else
    {
      departments.add(aDepartment);
    }
    wasAdded = true;
    return wasAdded;
  }


	/**
	 * Removes the given Department from the list of Departments associated with
	 * this Hospital, if it is not currently assigned to a different hospital.
	 *
	 * @param aDepartment the Department to be removed
	 * @return true if the Department was successfully removed, false otherwise
	 */
  public boolean removeDepartment(Department aDepartment)
  {
    boolean wasRemoved = false;
    //Unable to remove aDepartment, as it must always have a hospital
    if (!this.equals(aDepartment.getHospital()))
    {
      departments.remove(aDepartment);
      wasRemoved = true;
    }
    return wasRemoved;
  }

	/* Code from template association_AddIndexControlFunctions */
	/**
	 * Adds the given Department to the list of Departments associated with this
	 * Hospital at the given index.
	 *
	 * @param aDepartment the Department to be added
	 * @param index       the index at which to add the Department
	 * @return true if the Department was successfully added, false otherwise
	 */
  public boolean addDepartmentAt(Department aDepartment, int index)
  {  
    boolean wasAdded = false;
    if(addDepartment(aDepartment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDepartments()) { index = numberOfDepartments() - 1; }
      departments.remove(aDepartment);
      departments.add(index, aDepartment);
      wasAdded = true;
    }
    return wasAdded;
  }

	/**
	 * Adds the given Department to the list of Departments associated with this
	 * Hospital at the given index, or moves it to the index if it already exists in
	 * the list.
	 *
	 * @param aDepartment the Department to be added or moved
	 * @param index       the index at which to add or move the Department
	 * @return true if the Department was successfully added or moved, false
	 *         otherwise
	 */

  public boolean addOrMoveDepartmentAt(Department aDepartment, int index)
  {
    boolean wasAdded = false;
    if(departments.contains(aDepartment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDepartments()) { index = numberOfDepartments() - 1; }
      departments.remove(aDepartment);
      departments.add(index, aDepartment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDepartmentAt(aDepartment, index);
    }
    return wasAdded;
  }

	/**
	 * Delete this hospital. Removes all persons associated with this hospital and
	 * deletes all departments associated with it.
	 */

  public void delete()
  {
    hospitalsByName.remove(getName());
    ArrayList<Person> copyOfPersons = new ArrayList<Person>(persons);
    persons.clear();
    for(Person aPerson : copyOfPersons)
    {
      aPerson.removeHospital(this);
    }
    while (departments.size() > 0)
    {
      Department aDepartment = departments.get(departments.size() - 1);
      aDepartment.delete();
      departments.remove(aDepartment);
    }
    
  }


	/**
	 * Returns a string representation of this hospital in the format:
	 * 
	 * <pre>
	 Hospital[name:NAME,address:ADDRESS,phone:PHONE]
	 * </pre>
	 */

  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "address" + "=" + (getAddress() != null ? !getAddress().equals(this)  ? getAddress().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "phone" + "=" + (getPhone() != null ? !getPhone().equals(this)  ? getPhone().toString().replaceAll("  ","    ") : "this" : "null");
  }
}