package ce204_hw2_organization_test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

import ce204_hw2_organization_lib.Address;
import ce204_hw2_organization_lib.Department;
import ce204_hw2_organization_lib.Doctor;
import ce204_hw2_organization_lib.History;
import ce204_hw2_organization_lib.Hospital;
import ce204_hw2_organization_lib.Patient;
import ce204_hw2_organization_lib.Person;
import ce204_hw2_organization_lib.Phone;
import ce204_hw2_organization_lib.Staff;
import ce204_hw2_organization_lib.Person.Gender;

public class ce204_hw2_organization_test {
	
	
	
	//Address Tests
	@Test
	public void testAddressObject() {
		Address address = new Address("RandomString1", "RandomString1", "RandomString1", "RandomString1");
		
		assertTrue(address.setStreet("RandomString1"));
        assertEquals("RandomString1", address.getStreet());
        assertTrue(address.setStreet("RandomString2"));
        assertEquals("RandomString2", address.getStreet());
        assertFalse(address.getStreet().equals("RandomString1"));
        
        assertTrue(address.setCity("RandomString1"));
        assertEquals("RandomString1", address.getCity());
        assertTrue(address.setCity("RandomString2"));
        assertEquals("RandomString2", address.getCity());
        assertFalse(address.getCity().equals("RandomString1"));
        
        assertTrue(address.setPostalCode("RandomString1"));
        assertEquals("RandomString1", address.getPostalCode());
        assertTrue(address.setPostalCode("RandomString2"));
        assertEquals("RandomString2", address.getPostalCode());
        assertFalse(address.getPostalCode().equals("RandomString1"));
        
        assertTrue(address.setCountry("RandomString1"));
        assertEquals("RandomString1", address.getCountry());
        assertTrue(address.setCountry("RandomString2"));
        assertEquals("RandomString2", address.getCountry());
        assertFalse(address.getCountry().equals("RandomString1"));
	}
	
	
	//Phone Tests
	@Test
	public void testPhoneObject() {
		Phone phone = new Phone("RandomString1","RandomString1","RandomString1");
		
		assertTrue( phone.setPhoneNumber("RandomString1"));
	    assertTrue( phone.getPhoneNumber().equals("RandomString1"));
	    assertTrue( phone.setPhoneNumber("RandomString2"));
	    assertTrue( phone.getPhoneNumber().equals("RandomString2"));
	    assertFalse( phone.getPhoneNumber().equals("RandomString1"));

	    assertTrue( phone.setPhoneHolderName("RandomString1"));
	    assertTrue( phone.getPhoneHolderName() =="RandomString1");
	    assertTrue( phone.setPhoneHolderName("RandomString2"));
	    assertTrue( phone.getPhoneHolderName()=="RandomString2");
	    assertFalse( phone.getPhoneHolderName() =="RandomString1");
	    
	    assertTrue( phone.setRelation("RandomString1"));
	    assertTrue( phone.getRelation().equals("RandomString1"));
	    assertTrue( phone.setRelation("RandomString2"));
	    assertTrue( phone.getRelation().equals("RandomString2"));
	    assertFalse( phone.getRelation().equals("RandomString1"));
	}
	
	//Hospital Tests
	@Test
	public void testHospitalObject() {
		Address address = new Address("RandomString1", "RandomString1", "RandomString1", "RandomString1");
		Phone phone = new Phone("RandomString1","RandomString1","RandomString1");
		Hospital aHospital = new Hospital("RandomString5",address, phone);
        
	    assertTrue( aHospital.setName("RandomString00"));
	    assertTrue( aHospital.getName().equals("RandomString00"));
	    assertTrue( aHospital.setName("RandomString2"));
	    assertTrue( aHospital.getName().equals("RandomString2"));
	    assertFalse( aHospital.getName().equals("RandomString1"));
	}
	
	//Person Tests
	@Test
	public void testPersonObject() {
		Address address = new Address("RandomString1", "RandomString1", "RandomString1", "RandomString1");
		Phone phone = new Phone("RandomString1","RandomString1","RandomString1");
		Person aPerson = new Person("RandomString1","RandomString1","RandomString1","RandomString1", Date.valueOf("1999-12-12"),Person.Gender.Male, address, phone);
		
		assertTrue( aPerson.setTitle("RandomString1"));
	    assertTrue( aPerson.getTitle().equals("RandomString1"));
	    assertTrue( aPerson.setTitle("RandomString2"));
	    assertTrue( aPerson.getTitle().equals("RandomString2"));
	    assertFalse( aPerson.getTitle().equals("RandomString1"));
	    
	    assertTrue( aPerson.setGivenName("RandomString1"));
	    assertTrue( aPerson.getGivenName().equals("RandomString1"));
	    assertTrue( aPerson.setGivenName("RandomString2"));
	    assertTrue( aPerson.getGivenName().equals("RandomString2"));
	    assertFalse( aPerson.getGivenName().equals("RandomString1"));
	    
	    assertTrue( aPerson.setMiddleName("RandomString1"));
	    assertTrue( aPerson.getMiddleName().equals("RandomString1"));
	    assertTrue( aPerson.setMiddleName("RandomString2"));
	    assertTrue( aPerson.getMiddleName().equals("RandomString2"));
	    assertFalse( aPerson.getMiddleName().equals("RandomString1"));
	    
	    assertTrue( aPerson.setFamilyName("RandomString1"));
	    assertTrue( aPerson.getFamilyName().equals("RandomString1"));
	    assertTrue( aPerson.setFamilyName("RandomString2"));
	    assertTrue( aPerson.getFamilyName().equals("RandomString2"));
	    assertFalse( aPerson.getFamilyName().equals("RandomString1"));
	    
	    assertTrue( aPerson.getName().equals("RandomString2 RandomString2 RandomString2 RandomString2"));
	    assertFalse( aPerson.getName().equals("RandomString2"));
	    assertFalse( aPerson.getName().equals("RandomString1"));
	    
	    Date aDate = Date.valueOf("1999-12-12");
	    assertTrue( aPerson.setBirthDate(aDate));
	    assertTrue( aPerson.getBirthDate().equals(aDate));
	}
	
	//Patient Tests
	@Test
	public void testPatientObject() {
		Address address = new Address("RandomString1", "RandomString1", "RandomString1", "RandomString1");
		Phone phone = new Phone("RandomString1","RandomString1","RandomString1");
		Patient aPatient = new Patient("RandomString1","RandomString1","RandomString1","RandomString1", Date.valueOf("1999-12-12"),Person.Gender.Male, address, phone, "1", Date.valueOf("2023-01-01"), new History());
		
		assertTrue( aPatient.setId("RandomString1"));
	    assertEquals( aPatient.getId(),"RandomString1");
	    assertTrue( aPatient.setId("RandomString2"));
	    assertEquals( aPatient.getId(), "RandomString2");
	    assertFalse( aPatient.getId().equals("RandomString1"));

	    assertTrue( aPatient.getAge() == 24);
	    assertTrue( aPatient.setBirthDate(new Date(100, 1, 1)));
	    assertTrue( aPatient.getAge() == 23);
	    assertTrue( aPatient.setBirthDate(new Date(50, 1, 1)));
	    assertTrue( aPatient.getAge() == 73);
	    
	    Date aDate = Date.valueOf("1999-12-12");
	    assertTrue( aPatient.setAccepted(aDate));
	    assertEquals( aPatient.getAccepted() , aDate);
	    
	    assertTrue( aPatient.getPrescriptions().length == 0);
	    assertTrue( aPatient.getAllergies().length == 0);
	    assertTrue( aPatient.getSpecialReqs().length == 0);
	    
	}
	
	//Staff Tests
	@Test
	public void testStaffObject() {
		Address address = new Address("RandomString1", "RandomString1", "RandomString1", "RandomString1");
		Phone phone = new Phone("RandomString1","RandomString1","RandomString1");
		Hospital aHospital = new Hospital("RandomString4",address, phone);
		Department aDepartment = new Department(aHospital);
		
        Staff aStaff = new Staff("RandomString1","RandomString1","RandomString1","RandomString1", Date.valueOf("1999-12-12"),Person.Gender.Male, address, phone, Date.valueOf("2020-12-12"), aDepartment);    
        
        Date aDate = Date.valueOf("1999-12-12");
        assertTrue( aStaff.setJoined(aDate));
        assertEquals( aStaff.getJoined() , aDate);
        
        assertTrue( aStaff.getEducation().length == 0);
        assertTrue( aStaff.getCertification().length == 0);
        assertTrue( aStaff.getLanguages().length == 0);
        
	}
	
	//Doctor Tests
	@Test
	public void testDoctorObject() {
		Address address = new Address("RandomString1", "RandomString1", "RandomString1", "RandomString1");
		Phone phone = new Phone("RandomString1","RandomString1","RandomString1");
		Hospital aHospital = new Hospital("RandomString3",address, phone);
		Department aDepartment = new Department(aHospital);

        Doctor aDoctor = new Doctor("RandomString1","RandomString1","RandomString1","RandomString1", Date.valueOf("1999-12-12"),Person.Gender.Male, address, phone, Date.valueOf("2020-12-12"), aDepartment);

        assertTrue( aDoctor.getSpecialty().length == 0);
        assertTrue( aDoctor.getLocations().length == 0);
        assertTrue( aDoctor.getEducation().length == 0);
        assertTrue( aDoctor.getCertification().length == 0);
        assertTrue( aDoctor.getLanguages().length == 0);
	}
	
	//Association Tests
	@Test
	public void testAssociations() {
		Address address = new Address("RandomString1", "RandomString1", "RandomString1", "RandomString1");
		Phone phone = new Phone("RandomString1","RandomString1","RandomString1");
		Hospital aHospital = new Hospital("RandomString213",address, phone);
		
		assertTrue (aHospital.numberOfDepartments()== 0);
		
		Address baddress = new Address("RandomString1", "RandomString1", "RandomString1", "RandomString1");
		Phone bphone = new Phone("RandomString1","RandomString1","RandomString1");
		Hospital baHospital = new Hospital("RandomString1",address, phone);
		
		Department aDepartment = new Department(aHospital);
		Department baDepartment = new Department(baHospital);
		
		aDepartment.setHospital(baHospital);
		baDepartment.setHospital(aHospital);
		
        assertEquals(aDepartment.getHospital() , baHospital);              
        assertEquals(baDepartment.getHospital() , aHospital );
        
        aHospital.addDepartment(aDepartment);
        aDepartment.delete(); 
        //baDepartment still inside
        assertTrue (aHospital.numberOfDepartments() == 1);
        
        
        aHospital = new Hospital("RandomString21",address, phone);
        aHospital.addDepartment(aDepartment);
        aHospital.addDepartment(baDepartment);  
        baDepartment.setHospital(aHospital);
  
        assertEquals( aHospital.getDepartment(1),baDepartment); 
        assertEquals( baDepartment.getHospital(), aHospital);
        assertEquals( aHospital.numberOfDepartments(),  2);
        
        assertTrue(aDepartment.numberOfStaffs()== 0);

		
        Staff aStaff = new Staff("RandomString1","RandomString1","RandomString1","RandomString1", Date.valueOf("1999-12-12"),Person.Gender.Male, address, phone, Date.valueOf("2020-12-12"), aDepartment);
        Staff baStaff = new Staff("RandomString1","RandomString1","RandomString1","RandomString1", Date.valueOf("1999-12-12"),Person.Gender.Male, address, phone, Date.valueOf("2020-12-12"), aDepartment);    
        aStaff.setDepartment(baDepartment);
        baStaff.setDepartment(aDepartment);
        assertEquals(aStaff.getDepartment() , baDepartment);              
        assertEquals(baStaff.getDepartment() , aDepartment );
        assertTrue (aDepartment.numberOfStaffs() == 1);		
		
	}
	
	
	 
}
