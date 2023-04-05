/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/

package ce204_hw2_organization_lib;

// line 3 "../organization.ump"
// line 229 "../organization.ump"
public class Address
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Address Attributes
  private String street;
  private String city;
  private String postalCode;
  private String country;

  //------------------------
  // CONSTRUCTOR
  //------------------------

	/**
	 * Constructor for the Address class.
	 * 
	 * @param aStreet     the street address
	 * @param aCity       the city name
	 * @param aPostalCode the postal code
	 * @param aCountry    the country name
	 */

  public Address(String aStreet, String aCity, String aPostalCode, String aCountry)
  {
    street = aStreet;
    city = aCity;
    postalCode = aPostalCode;
    country = aCountry;
  }

  //------------------------
  // INTERFACE
  //------------------------

	/**
	 * Setter for the street attribute.
	 * 
	 * @param aStreet the new street address
	 * @return true if the attribute was set successfully, false otherwise
	 */

  public boolean setStreet(String aStreet)
  {
    boolean wasSet = false;
    street = aStreet;
    wasSet = true;
    return wasSet;
  }

	/**
	 * Setter for the city attribute.
	 * 
	 * @param aCity the new city name
	 * @return true if the attribute was set successfully, false otherwise
	 */
  public boolean setCity(String aCity)
  {
    boolean wasSet = false;
    city = aCity;
    wasSet = true;
    return wasSet;
  }


	/**
	 * Setter for the postalCode attribute.
	 * 
	 * @param aPostalCode the new postal code
	 * @return true if the attribute was set successfully, false otherwise
	 */

  public boolean setPostalCode(String aPostalCode)
  {
    boolean wasSet = false;
    postalCode = aPostalCode;
    wasSet = true;
    return wasSet;
  }

	/**
	 * Setter for the country attribute.
	 * 
	 * @param aCountry the new country name
	 * @return true if the attribute was set successfully, false otherwise
	 */

  public boolean setCountry(String aCountry)
  {
    boolean wasSet = false;
    country = aCountry;
    wasSet = true;
    return wasSet;
  }


	/**
	 * Getter for the street attribute.
	 * 
	 * @return the street address
	 */

  public String getStreet()
  {
    return street;
  }

	/**
	 * Getter for the city attribute.
	 * 
	 * @return the city name
	 */

  public String getCity()
  {
    return city;
  }

	/**
	 * Getter for the postalCode attribute.
	 * 
	 * @return the postal code
	 */

  public String getPostalCode()
  {
    return postalCode;
  }

	/**
	 * Getter for the country attribute.
	 * 
	 * @return the country name
	 */

  public String getCountry()
  {
    return country;
  }

  public void delete()
  {}

	/**
	 * Returns a string representation of the address.
	 * 
	 * @return the address as a string
	 */

  public String toString()
  {
    return super.toString() + "["+
            "street" + ":" + getStreet()+ "," +
            "city" + ":" + getCity()+ "," +
            "postalCode" + ":" + getPostalCode()+ "," +
            "country" + ":" + getCountry()+ "]";
  }
}