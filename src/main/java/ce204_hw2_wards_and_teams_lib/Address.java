//PLEASE DO NOT EDIT THIS CODE/

//This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!/
/**

@file
@brief This file contains the implementation of the Address class.
This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language.
Please do not edit this code.
*/
package ce204_hw2_wards_and_teams_lib;

// line 9 "../../model.ump"
// line 107 "../../model.ump"
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

  Constructs an Address object with the given street, city, postal code, and country.
  @param aStreet The street of the address.
  @param aCity The city of the address.
  @param aPostalCode The postal code of the address.
  @param aCountry The country of the address.
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

  Sets the street of the address.
  @param aStreet The new street of the address.
  @return true if the street was set, false otherwise.
  */
  public boolean setStreet(String aStreet)
  {
    boolean wasSet = false;
    street = aStreet;
    wasSet = true;
    return wasSet;
  }
  /**

  Sets the city of the address.
  @param aCity The new city of the address.
  @return true if the city was set, false otherwise.
  */
  public boolean setCity(String aCity)
  {
    boolean wasSet = false;
    city = aCity;
    wasSet = true;
    return wasSet;
  }
  /**

  Sets the postal code of the address.
  @param aPostalCode The new postal code of the address.
  @return true if the postal code was set, false otherwise.
  */
  public boolean setPostalCode(String aPostalCode)
  {
    boolean wasSet = false;
    postalCode = aPostalCode;
    wasSet = true;
    return wasSet;
  }
  /**

  Sets the country of the address.
  @param aCountry The new country of the address.
  @return true if the country was set, false otherwise.
  */
  public boolean setCountry(String aCountry)
  {
    boolean wasSet = false;
    country = aCountry;
    wasSet = true;
    return wasSet;
  }
  /**

  Returns the street of the address.
  @return The street of the address.
  */
  
  public String getStreet()
  {
    return street;
  }
  /**

  Returns the city of the address.
  @return The city of the address.
  */
  public String getCity()
  {
    return city;
  }

  public String getPostalCode()
  {
    return postalCode;
  }

  public String getCountry()
  {
    return country;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "street" + ":" + getStreet()+ "," +
            "city" + ":" + getCity()+ "," +
            "postalCode" + ":" + getPostalCode()+ "," +
            "country" + ":" + getCountry()+ "]";
  }
}