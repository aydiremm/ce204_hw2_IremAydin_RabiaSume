package ce204_hw2_treatment_test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import ce204_hw2_treatment_lib.Doctor;
import ce204_hw2_treatment_lib.Examination;
import ce204_hw2_treatment_lib.Patient;
import ce204_hw2_treatment_lib.Prescription;
import ce204_hw2_treatment_lib.Therapy;

public class ce204_hw2_treatment_test {

	

	
	//Association Tests
	@Test
	public void testAssociations() {
		Examination aExamination = new Examination();
        Patient aPatient = new Patient(aExamination);
        
        
        assertEquals(aPatient.getExamination(), aExamination);
        
        
        Examination baExamination = new Examination();        
        aExamination = new Examination();   
        aPatient = new Patient(aExamination);

        aPatient.setExamination(baExamination);
        assertEquals( aPatient.getExamination(),baExamination);
        
        aExamination = new Examination();
        Doctor aDoctor = new Doctor(aExamination);
        assertEquals(aDoctor.getExamination(), aExamination);
        
        baExamination = new Examination();
        aExamination = new Examination();
        aDoctor = new Doctor(aExamination);
        aDoctor.setExamination(baExamination);
        assertEquals( aDoctor.getExamination(),baExamination);   
        
        aExamination = new Examination();
        assertEquals(aExamination.numberOfPatients(), 0);
        
        baExamination = new Examination();
        aExamination = new Examination();
        aPatient = new Patient(aExamination); 
        Patient baPatient = new Patient(aExamination);
        aPatient.setExamination(baExamination);
        assertEquals(aPatient.getExamination() , baExamination);              
        assertEquals(baPatient.getExamination() , aExamination);
        
        baExamination = new Examination();
        aExamination = new Examination();
        aPatient = new Patient(aExamination); 
        aExamination.addPatient(aPatient);
        aPatient.delete(); 
        assertEquals(aExamination.numberOfPatients(), 0);

        baExamination = new Examination();
        aExamination = new Examination();
        aPatient = new Patient(aExamination);
        baPatient = new Patient(aExamination);
        

        aExamination.addPatient(aPatient);
        aExamination.addPatient(baPatient);  
  
        assertEquals( aExamination.getPatient(1),baPatient); 
        assertEquals( baPatient.getExamination(), aExamination);
        assertEquals( aExamination.numberOfPatients(),  2);


        baExamination = new Examination();
        aExamination = new Examination();
        aDoctor = new Doctor(aExamination); 
        Doctor baDoctor = new Doctor(aExamination);
        
        aDoctor.setExamination(baExamination);
        assertEquals(aDoctor.getExamination(), baExamination);              
        assertEquals(baDoctor.getExamination(), aExamination);

        baExamination = new Examination();
        aExamination = new Examination();
        aDoctor = new Doctor(aExamination); 
        baDoctor = new Doctor(aExamination);
        

        aExamination.addDoctor(aDoctor);
        aExamination.addDoctor(baDoctor);  
  
        assertEquals( aExamination.getDoctor(1),baDoctor); 
        assertEquals( baDoctor.getExamination(), aExamination);
        assertEquals( aExamination.numberOfDoctors(),  2);
        
        Prescription aPrescription = new Prescription();
        assertTrue(aPrescription.numberOfTherapies()== 0);
        
        Prescription baPrescription = new Prescription();
        aPrescription = new Prescription();

        Therapy aTherapy = new Therapy(aPrescription); 
        Therapy baTherapy = new Therapy(aPrescription);
        
        aTherapy.setPrescription(baPrescription);
        assertEquals(aTherapy.getPrescription() , baPrescription);              
        assertEquals(baTherapy.getPrescription() , aPrescription );
        
        baPrescription = new Prescription();
        aPrescription = new Prescription();
        aTherapy = new Therapy(aPrescription); 
        aPrescription.addTherapy(aTherapy);
        aTherapy.delete(); 
        assertTrue (aPrescription.numberOfTherapies() == 0);

        aPrescription = new Prescription();
        aTherapy = new Therapy(aPrescription); 
        assertTrue (aTherapy.getPrescription() == aPrescription);
        
        baPrescription = new Prescription();
        aPrescription = new Prescription();
        aTherapy = new Therapy(aPrescription);
        aTherapy.setPrescription(baPrescription);
        assertEquals(aTherapy.getPrescription(),baPrescription);  
        
	}

}
