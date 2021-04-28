Feature: All the common steps we will have in this feature file xyz

#
#Scenario: customer api get call varification
    #Given the authentication is completed here
    #When I am sending "GET" request to this endpoint "/customers/6069f0308858e20017d698d8"
#				|STA|statusCode|200|
    #Then Verifying the following values
    #	  |VAL|firstName|Mahfuz|
    #	  |VAL|lastName|Akbur	 |
    #		|VAL|phone|5435435543|

#	 	Given the authentication is completed here
    #When I am sending "GET" request to this endpoint "/customers/<userId>"
    #Then Verifying the following values
    #	  |VAL|firstName|Md|
    #	  |VAL|lastName|Obaidulla|
    #		|VAL|phone|3475612578|
    #		|VAL|email|mitul.li@yahoo.com|
 #


#Scenario Outline: customer api get call varification xyz
    #Given the authentication is completed here
    #When I am sending "GET" request to this endpoint "/students/<userId>"
#				|STA|statusCode|200|
    #Then Verifying the following values
    #	  |VAL|firstName|<fName>|
    #	  |VAL|lastName|<lName>|
    #		|VAL|phoneNumbers[<indexOne>].localAreaCode			|<areaCodeOne>			|
    #		|VAL|phoneNumbers[<indexOne>].localPhoneNumber	|<phoneNumberOne>		|
    #		|VAL|phoneNumbers[<indexOne>].type							|<phoneTypeOne>			|
    #		|VAL|phoneNumbers[<indexTwo>].localAreaCode			|<areaCodeTwo>			|
    #		|VAL|phoneNumbers[<indexTwo>].localPhoneNumber	|<phoneNumbereTwo>	|
    #		|VAL|phoneNumbers[<indexTwo>].type							|<phoneTypeTwo>			|
    #		|VAL|phoneNumbers[<indexThree>].localAreaCode		|<areaCodeThree>		|
    #		|VAL|phoneNumbers[<indexThree>].localPhoneNumber|<phoneNumbereThree>|
    #		|VAL|phoneNumbers[<indexThree>].type						|<phoneTypeThree>		|
#Examples:
#		|userId									 |fName		|lName|indexOne|areaCodeOne|phoneNumberOne|phoneTypeOne|indexTwo|areaCodeTwo|phoneNumbereTwo|phoneTypeTwo|indexThree|areaCodeThree|phoneNumbereThree|phoneTypeThree|
#		|6080a3dad52967001773ee2b|Mohammad|Akburs|0			 |347			   |5612345				|Work				 | 1			|646				|5678789				|Cell				 |2					|841				|4565678						|Home					 |
#		|6080a39cd52967001773ee2a|Md			|Obaidulla|0	 |841			   |4565678				|Day				 | 1			|333				|3333333				|Home				 |2					|444				|4444444						|Cell					 |