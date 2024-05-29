@users
Feature: Adding the users to the List.
Background: 
Given User is on reqres URL

@add
Scenario Outline: Add user
When User enters the "<name>" and "<job>"
And users hit the users API
Then Users are added to list
Examples:
|name|job|
|Pooja|Sr.Eng|
|Chetan|Sr.Analysit|

@update
Scenario: Update the user 
When User enters name & job
|Deepa|Consultant|
|Kunal|Consultant|
And user hits the API
Then User data is updated

