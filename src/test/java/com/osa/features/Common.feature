
Feature: All the common steps we will have in this feature file

  Scenario Outline: Title of your scenario
    Given the authentication is completed here
    When I am sending "GET" request to this endpoint "/customers/<id>"
    Then Verifying the following values
    	  |VAL|firstName|<fName>|
    	  |VAL|lastName|<lName>|
    		|VAL|phone|<phone>|
   Examples:
   |id|fName|lName|phone|
   |6069f0308858e20017d698d8|	Mahfuz|	Akbur|5435435543|
   |5fbe8ffae338390017999a61|	MD|	Islam|2345678765|
