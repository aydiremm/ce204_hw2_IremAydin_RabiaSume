/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/

package ce204_hw2_wards_and_teams_lib;

// line 8 "../wards_and_teams.ump"
// line 90 "../wards_and_teams.ump"
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

  public boolean setStreet(String aStreet)
  {
    boolean wasSet = false;
    street = aStreet;
    wasSet = true;
    return wasSet;
  }

  public boolean setCity(String aCity)
  {
    boolean wasSet = false;
    city = aCity;
    wasSet = true;
    return wasSet;
  }

  public boolean setPostalCode(String aPostalCode)
  {
    boolean wasSet = false;
    postalCode = aPostalCode;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountry(String aCountry)
  {
    boolean wasSet = false;
    country = aCountry;
    wasSet = true;
    return wasSet;
  }

  public String getStreet()
  {
    return street;
  }

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