
Feature: All the common steps we will have in this feature file

  Scenario: Title of your scenario
    Given the authentication is completed here
    When I am sending "GET" request to this endpoint "/customers/6069f0308858e20017d698d8"
    Then Verifying the following values
    	  |VAL|"status"|200|
    		|VAL|"email"|md.abkur@yahoo.com|
    		|VAL|"email"|md.abkur@yahoo.com|
    		|BOD|"email"|md.mahfuz@yahoo.com|
