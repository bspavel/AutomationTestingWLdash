Meta:
@checkAddNewCompany
Narrative:
As an admin or user
I want "create new company"
So that I can creat new company and see her in list company

Scenario: check the register company (short scenario)
Given go to Main page site
When as an user input login
When go to Register Company page
When to enter data $typePage in fields
And input data from xsl $file and check
Then get success message
Examples:
|message|typePage|file|
|Data has been saved|company|./src/test/resources/testDataXLS/allTestData.xlsx|

