Meta:
@addNewCompany
Narrative:
As an admin or user
I want "create new company"
So that I can creat new company and see her in list company

Scenario: check the register company (short scenario)
Given go to Main page site
When as an user input login
When input data from xsl $file and check
Examples:
|file|
|./src/test/resources/testDataXLS/test.xlsx|