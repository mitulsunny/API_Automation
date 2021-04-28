
Feature: All the common steps we will have in this feature file


Scenario: customer api POST call varification
    Given the authentication is completed here
	 	When I am sending "POST" request to this endpoint "/customers"
				|STA|statusCode     |200   |
	 		 	|BOD|myTestData.xlsx|A:2   |
	 		 	|VAR|_id            |xyz|
	 	Given the authentication is completed here
    When I am sending "GET" request to this endpoint "/customers/<xyz>"
				|STA|statusCode|200|
		Then Verifying the following values
    	  |VAL|firstName|Md									|
    	  |VAL|lastName	|Obaidulla	 				|
    		|VAL|phone		|3475612578					|
    		|VAL|email		|mitul.li@yahoo.com	|




    		

   
   
   
   