Feature: Initializing different web browsers
Scenario Outline: browser initialization
Given user should open <browser>
Examples:
|browser|
|edge|
|chrome|
Scenario Outline: Open url
When user enters valid url on <browser>
Then nopcommerce portal should be opened on <browser>
Examples:
|browser|
|edge|
|chrome|
Scenario Outline: Registration
When user user clicks on Register on <browser>
Then Register page should be opened on <browser>
Examples:
|browser|
|edge|
|chrome|
Scenario Outline: Register
	When user enters valid <fName>,<lName>,<pass> and click Register on <browser>
	Then user should be registered on <browser>
	Examples:
	|fName|lName|pass|browser|
	|TestUser|Testing|123456|chrome|
	|TestUser|Testing|123456|edge|
Scenario Outline: Logout to Login
When user click on logout after register on <browser>
Then user should be loggedout after register on <browser>
Examples:
|browser|
|edge|
|chrome|
Scenario Outline: Open login page
	When user click on login on <browser>
	Then login page should be displayed on <browser>
Examples:
|browser|
|edge|
|chrome|
Scenario Outline: Login
	When user enters valid <password> and click login on <browser>
	Then user should be logged in on <browser>
	Examples:
	|password|browser|
	|123456|chrome|
	|123456|edge|
Scenario Outline: Counting number of links
Given count the number of links on the page and store in list and text file on <browser>
Examples:
|browser|
|edge|
|chrome|
Scenario Outline: Opening each link in list on
Given open each link in list and get screenshot on <browser>
Examples:
|browser|
|edge|
|chrome|
Scenario Outline: Logout
When user click on logout on <browser>
Then user should be loggedout on <browser>
Examples:
|browser|
|edge|
|chrome|