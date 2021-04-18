
Feature: All the common steps we will have in this feature file

Scenario: customer api get call varification
    Given the authentication is completed here
    When I am sending "GET" request to this endpoint "/customers/6069f0308858e20017d698d8"
				|STA|statusCode|200|
    Then Verifying the following values
    	  |VAL|firstName|Mahfuz|
    	  |VAL|lastName|Akbur|
    		|VAL|phone|5435435543|

Scenario: customer api POST call varification
    Given the authentication is completed here
	 	When I am sending "POST" request to this endpoint "/customers"
				|STA|statusCode|200|
	 		 	|BOD|myTestData.xlsx|A:2|
    Then Verifying the following values
    	  |VAL|firstName|Md|
    	  |VAL|lastName|Obaidulla|
    		|VAL|phone|3475612578|
    		|VAL|email|mitul.li@yahoo.com|
 

    		

   
   
   
   