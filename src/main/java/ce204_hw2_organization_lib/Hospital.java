/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

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

  public boolean setAddress(Address aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhone(Phone aPhone)
  {
    boolean wasSet = false;
    phone = aPhone;
    wasSet = true;
    return wasSet;
  }

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

  public Address getAddress()
  {
    return address;
  }

  public Phone getPhone()
  {
    return phone;
  }
  /* Code from template association_GetMany */
  public Person getPerson(int index)
  {
    Person aPerson = persons.get(index);
    return aPerson;
  }

  public List<Person> getPersons()
  {
    List<Person> newPersons = Collections.unmodifiableList(persons);
    return newPersons;
  }

  public int numberOfPersons()
  {
    int number = persons.size();
    return number;
  }

  public boolean hasPersons()
  {
    boolean has = persons.size() > 0;
    return has;
  }

  public int indexOfPerson(Person aPerson)
  {
    int index = persons.indexOf(aPerson);
    return index;
  }
  /* Code from template association_GetMany */
  public Department getDepartment(int index)
  {
    Department aDepartment = departments.get(index);
    return aDepartment;
  }

  public List<Department> getDepartments()
  {
    List<Department> newDepartments = Collections.unmodifiableList(departments);
    return newDepartments;
  }

  public int numberOfDepartments()
  {
    int number = departments.size();
    return number;
  }

  public boolean hasDepartments()
  {
    boolean has = departments.size() > 0;
    return has;
  }

  public int indexOfDepartment(Department aDepartment)
  {
    int index = departments.indexOf(aDepartment);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPersons()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
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
  public static int minimumNumberOfDepartments()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Department addDepartment()
  {
    return new Department(this);
  }

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


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "address" + "=" + (getAddress() != null ? !getAddress().equals(this)  ? getAddress().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "phone" + "=" + (getPhone() != null ? !getPhone().equals(this)  ? getPhone().toString().replaceAll("  ","    ") : "this" : "null");
  }
}