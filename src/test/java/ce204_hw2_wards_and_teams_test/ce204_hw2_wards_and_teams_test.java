package ce204_hw2_wards_and_teams_test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import ce204_hw2_wards_and_teams_lib.Address;
import ce204_hw2_wards_and_teams_lib.ConsultantDoctor;
import ce204_hw2_wards_and_teams_lib.History;
import ce204_hw2_wards_and_teams_lib.Hospital;
import ce204_hw2_wards_and_teams_lib.Patient;
import ce204_hw2_wards_and_teams_lib.Phone;
import ce204_hw2_wards_and_teams_lib.Team;
import ce204_hw2_wards_and_teams_lib.Ward;

public class ce204_hw2_wards_and_teams_test {

	
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
        
	    assertTrue( aHospital.setName("RandomString1"));
	    assertTrue( aHospital.getName().equals("RandomString1"));
	    assertTrue( aHospital.setName("RandomString2"));
	    assertTrue( aHospital.getName().equals("RandomString2"));
	    assertFalse( aHospital.getName().equals("RandomString1"));
	}
	

	//Team Tests
	@Test
	public void testTeamObject() {
		Address address = new Address("RandomString1", "RandomString1", "RandomString1", "RandomString1");
		Phone phone = new Phone("RandomString1","RandomString1","RandomString1");
		Hospital aHospital = new Hospital("RandomString5",address, phone);
		ConsultantDoctor cDoctor = new ConsultantDoctor();
		Team team = new Team("Team1", aHospital, cDoctor);
		assertEquals(team.numberOfDoctors(), 0);
		assertEquals(team.minimumNumberOfPatients(), 0);
		address = new Address("RandomString1", "RandomString1", "RandomString1", "RandomString1");
		phone = new Phone("RandomString1","RandomString1","RandomString1");
		Patient aPatient = new Patient("1", Patient.Gender.Male, Date.valueOf("2023-01-01"), Date.valueOf("2023-01-01"), new History(), team, cDoctor, null);
		assertTrue(team.addPatient(aPatient));
	}
	

}
