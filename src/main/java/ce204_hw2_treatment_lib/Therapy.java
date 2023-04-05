/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_treatment_lib;
import java.util.*;

// line 45 "../treatment.ump"
// line 94 "../treatment.ump"
public class Therapy extends Treatment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Therapy Associations
  private Prescription prescription;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  /**
   * Constructs a new Therapy object with the specified prescription.
   *
   * @param aPrescription The prescription associated with this therapy.
   * @throws RuntimeException if the prescription is not set successfully.
   */
  public Therapy(Prescription aPrescription)
  {
    super();
    boolean didAddPrescription = setPrescription(aPrescription);
    if (!didAddPrescription)
    {
      throw new RuntimeException("Unable to create therapy due to prescription. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Prescription getPrescription()
  {
    return prescription;
  }
  /* Code from template association_SetOneToMany */
  /**
   * Sets the prescription associated with this therapy.
   *
   * @param aPrescription The prescription to associate with this therapy.
   * @return true if the prescription is set successfully, false otherwise.
   */
  public boolean setPrescription(Prescription aPrescription)
  {
    boolean wasSet = false;
    if (aPrescription == null)
    {
      return wasSet;
    }

    Prescription existingPrescription = prescription;
    prescription = aPrescription;
    if (existingPrescription != null && !existingPrescription.equals(aPrescription))
    {
      existingPrescription.removeTherapy(this);
    }
    prescription.addTherapy(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Prescription placeholderPrescription = prescription;
    this.prescription = null;
    if(placeholderPrescription != null)
    {
      placeholderPrescription.removeTherapy(this);
    }
    super.delete();
  }

}